package com.baidu.tieba.frs.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.u;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.i;
import java.util.HashSet;
/* loaded from: classes.dex */
public class b {
    public static int cFV;
    private static b cFY;
    private a cFW;
    private HashSet<String> cFX;
    private CustomMessageListener SV = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.f.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.cFX != null) {
                b.this.cFX.clear();
            }
        }
    };
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.f.b.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.cGb = false;
                        aVar.isRunning = false;
                        aVar.count = 0;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long cGa;
        public boolean cGb;
        public int count;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.cGb = false;
        }
    }

    public b() {
        cFV = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.SV);
    }

    public static b aly() {
        if (cFY == null) {
            synchronized (u.class) {
                if (cFY == null) {
                    cFY = new b();
                }
            }
        }
        return cFY;
    }

    private boolean alz() {
        if (this.cFW == null) {
            this.cFW = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cFW.cGb) {
            return true;
        }
        if (this.cFW.isRunning) {
            this.cFW.count++;
            if (currentTimeMillis - this.cFW.cGa < 120000) {
                if (this.cFW.count >= cFV) {
                    this.cFW.cGb = true;
                    a(this.cFW);
                    return true;
                }
            } else {
                this.cFW.isRunning = false;
                this.cFW.count = 0;
            }
        } else {
            this.cFW.isRunning = true;
            this.cFW.cGa = currentTimeMillis;
        }
        return false;
    }

    private void a(a aVar) {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 5;
        obtainMessage.obj = aVar;
        this.mHandler.removeMessages(5);
        this.mHandler.sendMessageDelayed(obtainMessage, ReportUserInfoModel.TIME_INTERVAL);
    }

    public void L(bh bhVar) {
        if (bhVar != null && bhVar.sp()) {
            ak akVar = new ak("c11717");
            akVar.f("fid", bhVar.getFid());
            akVar.ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bhVar.ZH);
            akVar.ad("obj_param2", bhVar.ZI);
            akVar.ad("obj_param1", bhVar.ZM);
            akVar.r("obj_locate", 1);
            akVar.ad("tid", bhVar.getTid());
            u.XR().a(akVar);
        }
    }

    public void a(com.baidu.tieba.frs.f.a aVar, bh bhVar) {
        if (aVar != null && aVar.cFS && bhVar != null && bhVar.getTid() != null) {
            if (this.cFX == null) {
                this.cFX = new HashSet<>();
            }
            if (!this.cFX.contains(bhVar.getTid()) && !alz()) {
                this.cFX.add(bhVar.getTid());
                ak akVar = new ak("c11439");
                akVar.ad("fid", aVar.cFU);
                akVar.ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bhVar.ZH);
                akVar.ad("obj_param2", bhVar.ZI);
                akVar.ad("obj_param1", bhVar.ZJ);
                akVar.r("obj_locate", aVar.cFT);
                akVar.ad("tid", bhVar.getTid());
                akVar.ad("obj_param3", bhVar.ZM);
                akVar.r("obj_id", z(bhVar));
                akVar.ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                akVar.f("exposure_time", System.currentTimeMillis());
                boolean z = (bhVar.sL() == null || (bhVar.sL().aCd() == null && bhVar.sL().IL() == null)) ? false : true;
                if (z && bhVar.sL().aCd() != null && bhVar.sL().aCd().ID() != null && bhVar.sL().aCd().ID().size() > 0) {
                    akVar.r("obj_name", bhVar.sL().ghu ? 3 : 2);
                } else {
                    akVar.r("obj_name", z ? 1 : 0);
                }
                u.XR().a(akVar);
                if (bhVar.si()) {
                    ak akVar2 = new ak("c12099");
                    akVar2.ad("fid", aVar.cFU);
                    akVar2.ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bhVar.ZH);
                    akVar2.ad("obj_param2", bhVar.ZI);
                    akVar2.ad("obj_param1", bhVar.ZJ);
                    akVar2.r("obj_locate", aVar.cFT);
                    akVar2.ad("tid", bhVar.getTid());
                    akVar2.ad("obj_param3", bhVar.ZM);
                    akVar2.r("obj_id", z(bhVar));
                    akVar2.ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                    u.XR().a(akVar2);
                }
            }
        }
    }

    public void a(com.baidu.tieba.frs.f.a aVar, bh bhVar, int i) {
        if (aVar != null && aVar.cFS && bhVar != null && bhVar.getTid() != null) {
            u.XR().dC(true);
            ak akVar = new ak("c11438");
            akVar.ad("fid", aVar.cFU);
            akVar.ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bhVar.ZH);
            akVar.ad("obj_param2", bhVar.ZI);
            akVar.ad("obj_param1", bhVar.ZJ);
            akVar.r("obj_locate", aVar.cFT);
            akVar.ad("tid", bhVar.getTid());
            akVar.r("obj_type", i);
            akVar.ad("obj_param3", bhVar.ZM);
            akVar.r("obj_id", z(bhVar));
            akVar.ad("obj_to", M(bhVar));
            TiebaStatic.log(akVar);
            if (bhVar.si()) {
                ak akVar2 = new ak("c12098");
                akVar2.ad("fid", aVar.cFU);
                akVar2.ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bhVar.ZH);
                akVar2.ad("obj_param2", bhVar.ZI);
                akVar2.ad("obj_param1", bhVar.ZJ);
                akVar2.r("obj_locate", aVar.cFT);
                akVar2.ad("tid", bhVar.getTid());
                akVar2.r("obj_type", i);
                akVar2.ad("obj_param3", bhVar.ZM);
                akVar2.r("obj_id", z(bhVar));
                akVar2.ad("obj_to", M(bhVar));
                TiebaStatic.log(akVar2);
            }
        }
    }

    public static void a(i iVar, int i, int i2) {
        if (iVar != null && iVar.aMZ() != null && iVar.gel == 1) {
            TiebaStatic.log(new ak("c11440").ad("fid", iVar.aMZ().getId()).r("obj_locate", i).r("obj_type", i2));
        }
    }

    private int z(bh bhVar) {
        if (bhVar.sz() == null || bhVar.sz().channelId <= 0) {
            return 0;
        }
        return (int) bhVar.sz().channelId;
    }

    private String M(bh bhVar) {
        return bhVar.ZN ? String.valueOf(bhVar.sw()) : String.valueOf(4);
    }
}
