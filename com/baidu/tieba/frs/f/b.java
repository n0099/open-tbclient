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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.u;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.i;
import java.util.HashSet;
/* loaded from: classes.dex */
public class b {
    public static int cEk;
    private static b cEn;
    private a cEl;
    private HashSet<String> cEm;
    private CustomMessageListener SH = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.f.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.cEm != null) {
                b.this.cEm.clear();
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
                        aVar.cEq = false;
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
        public long cEp;
        public boolean cEq;
        public int count;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.cEq = false;
        }
    }

    public b() {
        cEk = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.SH);
    }

    public static b alj() {
        if (cEn == null) {
            synchronized (u.class) {
                if (cEn == null) {
                    cEn = new b();
                }
            }
        }
        return cEn;
    }

    private boolean alk() {
        if (this.cEl == null) {
            this.cEl = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cEl.cEq) {
            return true;
        }
        if (this.cEl.isRunning) {
            this.cEl.count++;
            if (currentTimeMillis - this.cEl.cEp < 120000) {
                if (this.cEl.count >= cEk) {
                    this.cEl.cEq = true;
                    a(this.cEl);
                    return true;
                }
            } else {
                this.cEl.isRunning = false;
                this.cEl.count = 0;
            }
        } else {
            this.cEl.isRunning = true;
            this.cEl.cEp = currentTimeMillis;
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

    public void Q(bj bjVar) {
        if (bjVar != null && bjVar.sv()) {
            ak akVar = new ak("c11717");
            akVar.f("fid", bjVar.getFid());
            akVar.ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bjVar.ZH);
            akVar.ad("obj_param2", bjVar.ZI);
            akVar.ad("obj_param1", bjVar.ZM);
            akVar.r("obj_locate", 1);
            akVar.ad("tid", bjVar.getTid());
            u.XY().a(akVar);
        }
    }

    public void a(com.baidu.tieba.frs.f.a aVar, bj bjVar) {
        if (aVar != null && aVar.cEh && bjVar != null && bjVar.getTid() != null) {
            if (this.cEm == null) {
                this.cEm = new HashSet<>();
            }
            if (!this.cEm.contains(bjVar.getTid()) && !alk()) {
                this.cEm.add(bjVar.getTid());
                ak akVar = new ak("c11439");
                akVar.ad("fid", aVar.cEj);
                akVar.ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bjVar.ZH);
                akVar.ad("obj_param2", bjVar.ZI);
                akVar.ad("obj_param1", bjVar.ZJ);
                akVar.r("obj_locate", aVar.cEi);
                akVar.ad("tid", bjVar.getTid());
                akVar.ad("obj_param3", bjVar.ZM);
                akVar.r("obj_id", E(bjVar));
                akVar.ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                akVar.f("exposure_time", System.currentTimeMillis());
                boolean z = (bjVar.sR() == null || (bjVar.sR().aDg() == null && bjVar.sR().ID() == null)) ? false : true;
                if (z && bjVar.sR().aDg() != null && bjVar.sR().aDg().Iv() != null && bjVar.sR().aDg().Iv().size() > 0) {
                    akVar.r("obj_name", bjVar.sR().giQ ? 3 : 2);
                } else {
                    akVar.r("obj_name", z ? 1 : 0);
                }
                u.XY().a(akVar);
                if (bjVar.so()) {
                    ak akVar2 = new ak("c12099");
                    akVar2.ad("fid", aVar.cEj);
                    akVar2.ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bjVar.ZH);
                    akVar2.ad("obj_param2", bjVar.ZI);
                    akVar2.ad("obj_param1", bjVar.ZJ);
                    akVar2.r("obj_locate", aVar.cEi);
                    akVar2.ad("tid", bjVar.getTid());
                    akVar2.ad("obj_param3", bjVar.ZM);
                    akVar2.r("obj_id", E(bjVar));
                    akVar2.ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                    u.XY().a(akVar2);
                }
            }
        }
    }

    public void a(com.baidu.tieba.frs.f.a aVar, bj bjVar, int i) {
        if (aVar != null && aVar.cEh && bjVar != null && bjVar.getTid() != null) {
            u.XY().dI(true);
            ak akVar = new ak("c11438");
            akVar.ad("fid", aVar.cEj);
            akVar.ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bjVar.ZH);
            akVar.ad("obj_param2", bjVar.ZI);
            akVar.ad("obj_param1", bjVar.ZJ);
            akVar.r("obj_locate", aVar.cEi);
            akVar.ad("tid", bjVar.getTid());
            akVar.r("obj_type", i);
            akVar.ad("obj_param3", bjVar.ZM);
            akVar.r("obj_id", E(bjVar));
            akVar.ad("obj_to", R(bjVar));
            TiebaStatic.log(akVar);
            if (bjVar.so()) {
                ak akVar2 = new ak("c12098");
                akVar2.ad("fid", aVar.cEj);
                akVar2.ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bjVar.ZH);
                akVar2.ad("obj_param2", bjVar.ZI);
                akVar2.ad("obj_param1", bjVar.ZJ);
                akVar2.r("obj_locate", aVar.cEi);
                akVar2.ad("tid", bjVar.getTid());
                akVar2.r("obj_type", i);
                akVar2.ad("obj_param3", bjVar.ZM);
                akVar2.r("obj_id", E(bjVar));
                akVar2.ad("obj_to", R(bjVar));
                TiebaStatic.log(akVar2);
            }
        }
    }

    public static void a(i iVar, int i, int i2) {
        if (iVar != null && iVar.aOV() != null && iVar.gfK == 1) {
            TiebaStatic.log(new ak("c11440").ad("fid", iVar.aOV().getId()).r("obj_locate", i).r("obj_type", i2));
        }
    }

    private int E(bj bjVar) {
        if (bjVar.sF() == null || bjVar.sF().channelId <= 0) {
            return 0;
        }
        return (int) bjVar.sF().channelId;
    }

    private String R(bj bjVar) {
        return bjVar.ZN ? String.valueOf(bjVar.sC()) : String.valueOf(4);
    }
}
