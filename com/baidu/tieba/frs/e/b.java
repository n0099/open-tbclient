package com.baidu.tieba.frs.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.s;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.k;
import java.util.HashSet;
/* loaded from: classes.dex */
public class b {
    public static int cYR;
    private static b cYU;
    private a cYS;
    private HashSet<String> cYT;
    private CustomMessageListener TF = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.e.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.cYT != null) {
                b.this.cYT.clear();
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
                        aVar.cYX = false;
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
        public long cYW;
        public boolean cYX;
        public int count;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.cYX = false;
        }
    }

    public b() {
        cYR = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.TF);
    }

    public static b aqv() {
        if (cYU == null) {
            synchronized (s.class) {
                if (cYU == null) {
                    cYU = new b();
                }
            }
        }
        return cYU;
    }

    private boolean aqw() {
        if (this.cYS == null) {
            this.cYS = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cYS.cYX) {
            return true;
        }
        if (this.cYS.isRunning) {
            this.cYS.count++;
            if (currentTimeMillis - this.cYS.cYW < 120000) {
                if (this.cYS.count >= cYR) {
                    this.cYS.cYX = true;
                    a(this.cYS);
                    return true;
                }
            } else {
                this.cYS.isRunning = false;
                this.cYS.count = 0;
            }
        } else {
            this.cYS.isRunning = true;
            this.cYS.cYW = currentTimeMillis;
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

    public void S(bd bdVar) {
        if (bdVar != null && bdVar.sq()) {
            ak akVar = new ak("c11717");
            akVar.f(ImageViewerConfig.FORUM_ID, bdVar.getFid());
            akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdVar.aad);
            akVar.ac("obj_param2", bdVar.aae);
            akVar.ac("obj_param1", bdVar.aai);
            akVar.r("obj_locate", 1);
            akVar.ac("tid", bdVar.getTid());
            s.abW().a(akVar);
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bd bdVar) {
        if (aVar != null && aVar.cYO && bdVar != null && bdVar.getTid() != null) {
            if (this.cYT == null) {
                this.cYT = new HashSet<>();
            }
            if (!this.cYT.contains(bdVar.getTid()) && !aqw()) {
                this.cYT.add(bdVar.getTid());
                ak akVar = new ak("c11439");
                akVar.ac(ImageViewerConfig.FORUM_ID, aVar.cYQ);
                akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdVar.aad);
                akVar.ac("obj_param2", bdVar.aae);
                akVar.ac("obj_param1", bdVar.aaf);
                akVar.r("obj_locate", aVar.cYP);
                akVar.ac("tid", bdVar.getTid());
                akVar.ac("obj_param3", bdVar.aai);
                akVar.r("obj_id", E(bdVar));
                akVar.ac("uid", TbadkCoreApplication.getCurrentAccount());
                akVar.f("exposure_time", System.currentTimeMillis());
                boolean z = (bdVar.sM() == null || (bdVar.sM().bwX() == null && bdVar.sM().Jz() == null)) ? false : true;
                if (z && bdVar.sM().bwX() != null && bdVar.sM().bwX().Jr() != null && bdVar.sM().bwX().Jr().size() > 0) {
                    akVar.r("obj_name", bdVar.sM().gCv ? 3 : 2);
                } else {
                    akVar.r("obj_name", z ? 1 : 0);
                }
                s.abW().a(akVar);
                if (bdVar.si()) {
                    ak akVar2 = new ak("c12099");
                    akVar2.ac(ImageViewerConfig.FORUM_ID, aVar.cYQ);
                    akVar2.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdVar.aad);
                    akVar2.ac("obj_param2", bdVar.aae);
                    akVar2.ac("obj_param1", bdVar.aaf);
                    akVar2.r("obj_locate", aVar.cYP);
                    akVar2.ac("tid", bdVar.getTid());
                    akVar2.ac("obj_param3", bdVar.aai);
                    akVar2.r("obj_id", E(bdVar));
                    akVar2.ac("uid", TbadkCoreApplication.getCurrentAccount());
                    s.abW().a(akVar2);
                }
            }
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bd bdVar, int i) {
        if (aVar != null && aVar.cYO && bdVar != null && bdVar.getTid() != null) {
            s.abW().dU(true);
            ak akVar = new ak("c11438");
            akVar.ac(ImageViewerConfig.FORUM_ID, aVar.cYQ);
            akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdVar.aad);
            akVar.ac("obj_param2", bdVar.aae);
            akVar.ac("obj_param1", bdVar.aaf);
            akVar.r("obj_locate", aVar.cYP);
            akVar.ac("tid", bdVar.getTid());
            akVar.r("obj_type", i);
            akVar.ac("obj_param3", bdVar.aai);
            akVar.r("obj_id", E(bdVar));
            akVar.ac("obj_to", T(bdVar));
            TiebaStatic.log(akVar);
            if (bdVar.si()) {
                ak akVar2 = new ak("c12098");
                akVar2.ac(ImageViewerConfig.FORUM_ID, aVar.cYQ);
                akVar2.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdVar.aad);
                akVar2.ac("obj_param2", bdVar.aae);
                akVar2.ac("obj_param1", bdVar.aaf);
                akVar2.r("obj_locate", aVar.cYP);
                akVar2.ac("tid", bdVar.getTid());
                akVar2.r("obj_type", i);
                akVar2.ac("obj_param3", bdVar.aai);
                akVar2.r("obj_id", E(bdVar));
                akVar2.ac("obj_to", T(bdVar));
                TiebaStatic.log(akVar2);
            }
        }
    }

    public static void a(k kVar, int i, int i2) {
        if (kVar != null && kVar.aRn() != null && kVar.gzl == 1) {
            TiebaStatic.log(new ak("c11440").ac(ImageViewerConfig.FORUM_ID, kVar.aRn().getId()).r("obj_locate", i).r("obj_type", i2));
        }
    }

    private int E(bd bdVar) {
        if (bdVar.sA() == null || bdVar.sA().channelId <= 0) {
            return 0;
        }
        return (int) bdVar.sA().channelId;
    }

    private String T(bd bdVar) {
        return bdVar.aaj ? String.valueOf(bdVar.sx()) : String.valueOf(4);
    }
}
