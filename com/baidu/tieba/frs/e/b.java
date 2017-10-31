package com.baidu.tieba.frs.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.u;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.j;
import java.util.HashSet;
/* loaded from: classes.dex */
public class b {
    public static int cOW;
    private static b cOZ;
    private a cOX;
    private HashSet<String> cOY;
    private CustomMessageListener Tc = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.e.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.cOY != null) {
                b.this.cOY.clear();
            }
        }
    };
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.e.b.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 5:
                    if ((message.obj instanceof a) && (aVar = (a) message.obj) != null) {
                        aVar.cPc = false;
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
        public long cPb;
        public boolean cPc;
        public int count;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.cPc = false;
        }
    }

    public b() {
        cOW = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.Tc);
    }

    public static b aoe() {
        if (cOZ == null) {
            synchronized (u.class) {
                if (cOZ == null) {
                    cOZ = new b();
                }
            }
        }
        return cOZ;
    }

    private boolean aof() {
        if (this.cOX == null) {
            this.cOX = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cOX.cPc) {
            return true;
        }
        if (this.cOX.isRunning) {
            this.cOX.count++;
            if (currentTimeMillis - this.cOX.cPb < 120000) {
                if (this.cOX.count >= cOW) {
                    this.cOX.cPc = true;
                    a(this.cOX);
                    return true;
                }
            } else {
                this.cOX.isRunning = false;
                this.cOX.count = 0;
            }
        } else {
            this.cOX.isRunning = true;
            this.cOX.cPb = currentTimeMillis;
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

    public void N(bh bhVar) {
        if (bhVar != null && bhVar.sp()) {
            ak akVar = new ak("c11717");
            akVar.f(ImageViewerConfig.FORUM_ID, bhVar.getFid());
            akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bhVar.ZQ);
            akVar.ac("obj_param2", bhVar.ZR);
            akVar.ac("obj_param1", bhVar.ZV);
            akVar.r("obj_locate", 1);
            akVar.ac("tid", bhVar.getTid());
            u.ZX().a(akVar);
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bh bhVar) {
        if (aVar != null && aVar.cOT && bhVar != null && bhVar.getTid() != null) {
            if (this.cOY == null) {
                this.cOY = new HashSet<>();
            }
            if (!this.cOY.contains(bhVar.getTid()) && !aof()) {
                this.cOY.add(bhVar.getTid());
                ak akVar = new ak("c11439");
                akVar.ac(ImageViewerConfig.FORUM_ID, aVar.cOV);
                akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bhVar.ZQ);
                akVar.ac("obj_param2", bhVar.ZR);
                akVar.ac("obj_param1", bhVar.ZS);
                akVar.r("obj_locate", aVar.cOU);
                akVar.ac("tid", bhVar.getTid());
                akVar.ac("obj_param3", bhVar.ZV);
                akVar.r("obj_id", z(bhVar));
                akVar.ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                akVar.f("exposure_time", System.currentTimeMillis());
                boolean z = (bhVar.sL() == null || (bhVar.sL().aEt() == null && bhVar.sL().IQ() == null)) ? false : true;
                if (z && bhVar.sL().aEt() != null && bhVar.sL().aEt().II() != null && bhVar.sL().aEt().II().size() > 0) {
                    akVar.r("obj_name", bhVar.sL().gpQ ? 3 : 2);
                } else {
                    akVar.r("obj_name", z ? 1 : 0);
                }
                u.ZX().a(akVar);
                if (bhVar.sh()) {
                    ak akVar2 = new ak("c12099");
                    akVar2.ac(ImageViewerConfig.FORUM_ID, aVar.cOV);
                    akVar2.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bhVar.ZQ);
                    akVar2.ac("obj_param2", bhVar.ZR);
                    akVar2.ac("obj_param1", bhVar.ZS);
                    akVar2.r("obj_locate", aVar.cOU);
                    akVar2.ac("tid", bhVar.getTid());
                    akVar2.ac("obj_param3", bhVar.ZV);
                    akVar2.r("obj_id", z(bhVar));
                    akVar2.ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                    u.ZX().a(akVar2);
                }
            }
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bh bhVar, int i) {
        if (aVar != null && aVar.cOT && bhVar != null && bhVar.getTid() != null) {
            u.ZX().dA(true);
            ak akVar = new ak("c11438");
            akVar.ac(ImageViewerConfig.FORUM_ID, aVar.cOV);
            akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bhVar.ZQ);
            akVar.ac("obj_param2", bhVar.ZR);
            akVar.ac("obj_param1", bhVar.ZS);
            akVar.r("obj_locate", aVar.cOU);
            akVar.ac("tid", bhVar.getTid());
            akVar.r("obj_type", i);
            akVar.ac("obj_param3", bhVar.ZV);
            akVar.r("obj_id", z(bhVar));
            akVar.ac("obj_to", O(bhVar));
            TiebaStatic.log(akVar);
            if (bhVar.sh()) {
                ak akVar2 = new ak("c12098");
                akVar2.ac(ImageViewerConfig.FORUM_ID, aVar.cOV);
                akVar2.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bhVar.ZQ);
                akVar2.ac("obj_param2", bhVar.ZR);
                akVar2.ac("obj_param1", bhVar.ZS);
                akVar2.r("obj_locate", aVar.cOU);
                akVar2.ac("tid", bhVar.getTid());
                akVar2.r("obj_type", i);
                akVar2.ac("obj_param3", bhVar.ZV);
                akVar2.r("obj_id", z(bhVar));
                akVar2.ac("obj_to", O(bhVar));
                TiebaStatic.log(akVar2);
            }
        }
    }

    public static void a(j jVar, int i, int i2) {
        if (jVar != null && jVar.aPM() != null && jVar.gmI == 1) {
            TiebaStatic.log(new ak("c11440").ac(ImageViewerConfig.FORUM_ID, jVar.aPM().getId()).r("obj_locate", i).r("obj_type", i2));
        }
    }

    private int z(bh bhVar) {
        if (bhVar.sz() == null || bhVar.sz().channelId <= 0) {
            return 0;
        }
        return (int) bhVar.sz().channelId;
    }

    private String O(bh bhVar) {
        return bhVar.ZW ? String.valueOf(bhVar.sw()) : String.valueOf(4);
    }
}
