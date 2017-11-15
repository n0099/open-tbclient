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
    public static int cPq;
    private static b cPt;
    private a cPr;
    private HashSet<String> cPs;
    private CustomMessageListener Tc = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.e.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.cPs != null) {
                b.this.cPs.clear();
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
                        aVar.cPw = false;
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
        public long cPv;
        public boolean cPw;
        public int count;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.cPw = false;
        }
    }

    public b() {
        cPq = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.Tc);
    }

    public static b aot() {
        if (cPt == null) {
            synchronized (u.class) {
                if (cPt == null) {
                    cPt = new b();
                }
            }
        }
        return cPt;
    }

    private boolean aou() {
        if (this.cPr == null) {
            this.cPr = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cPr.cPw) {
            return true;
        }
        if (this.cPr.isRunning) {
            this.cPr.count++;
            if (currentTimeMillis - this.cPr.cPv < 120000) {
                if (this.cPr.count >= cPq) {
                    this.cPr.cPw = true;
                    a(this.cPr);
                    return true;
                }
            } else {
                this.cPr.isRunning = false;
                this.cPr.count = 0;
            }
        } else {
            this.cPr.isRunning = true;
            this.cPr.cPv = currentTimeMillis;
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
            u.aaj().a(akVar);
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bh bhVar) {
        if (aVar != null && aVar.cPn && bhVar != null && bhVar.getTid() != null) {
            if (this.cPs == null) {
                this.cPs = new HashSet<>();
            }
            if (!this.cPs.contains(bhVar.getTid()) && !aou()) {
                this.cPs.add(bhVar.getTid());
                ak akVar = new ak("c11439");
                akVar.ac(ImageViewerConfig.FORUM_ID, aVar.cPp);
                akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bhVar.ZQ);
                akVar.ac("obj_param2", bhVar.ZR);
                akVar.ac("obj_param1", bhVar.ZS);
                akVar.r("obj_locate", aVar.cPo);
                akVar.ac("tid", bhVar.getTid());
                akVar.ac("obj_param3", bhVar.ZV);
                akVar.r("obj_id", z(bhVar));
                akVar.ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                akVar.f("exposure_time", System.currentTimeMillis());
                boolean z = (bhVar.sL() == null || (bhVar.sL().aEx() == null && bhVar.sL().Jb() == null)) ? false : true;
                if (z && bhVar.sL().aEx() != null && bhVar.sL().aEx().IT() != null && bhVar.sL().aEx().IT().size() > 0) {
                    akVar.r("obj_name", bhVar.sL().gqT ? 3 : 2);
                } else {
                    akVar.r("obj_name", z ? 1 : 0);
                }
                u.aaj().a(akVar);
                if (bhVar.sh()) {
                    ak akVar2 = new ak("c12099");
                    akVar2.ac(ImageViewerConfig.FORUM_ID, aVar.cPp);
                    akVar2.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bhVar.ZQ);
                    akVar2.ac("obj_param2", bhVar.ZR);
                    akVar2.ac("obj_param1", bhVar.ZS);
                    akVar2.r("obj_locate", aVar.cPo);
                    akVar2.ac("tid", bhVar.getTid());
                    akVar2.ac("obj_param3", bhVar.ZV);
                    akVar2.r("obj_id", z(bhVar));
                    akVar2.ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                    u.aaj().a(akVar2);
                }
            }
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bh bhVar, int i) {
        if (aVar != null && aVar.cPn && bhVar != null && bhVar.getTid() != null) {
            u.aaj().dF(true);
            ak akVar = new ak("c11438");
            akVar.ac(ImageViewerConfig.FORUM_ID, aVar.cPp);
            akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bhVar.ZQ);
            akVar.ac("obj_param2", bhVar.ZR);
            akVar.ac("obj_param1", bhVar.ZS);
            akVar.r("obj_locate", aVar.cPo);
            akVar.ac("tid", bhVar.getTid());
            akVar.r("obj_type", i);
            akVar.ac("obj_param3", bhVar.ZV);
            akVar.r("obj_id", z(bhVar));
            akVar.ac("obj_to", O(bhVar));
            TiebaStatic.log(akVar);
            if (bhVar.sh()) {
                ak akVar2 = new ak("c12098");
                akVar2.ac(ImageViewerConfig.FORUM_ID, aVar.cPp);
                akVar2.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bhVar.ZQ);
                akVar2.ac("obj_param2", bhVar.ZR);
                akVar2.ac("obj_param1", bhVar.ZS);
                akVar2.r("obj_locate", aVar.cPo);
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
        if (jVar != null && jVar.aPU() != null && jVar.gnK == 1) {
            TiebaStatic.log(new ak("c11440").ac(ImageViewerConfig.FORUM_ID, jVar.aPU().getId()).r("obj_locate", i).r("obj_type", i2));
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
