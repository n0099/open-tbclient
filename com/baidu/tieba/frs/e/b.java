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
    public static int cYF;
    private static b cYI;
    private a cYG;
    private HashSet<String> cYH;
    private CustomMessageListener TJ = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.e.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.cYH != null) {
                b.this.cYH.clear();
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
                        aVar.cYL = false;
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
        public long cYK;
        public boolean cYL;
        public int count;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.cYL = false;
        }
    }

    public b() {
        cYF = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.TJ);
    }

    public static b aqn() {
        if (cYI == null) {
            synchronized (s.class) {
                if (cYI == null) {
                    cYI = new b();
                }
            }
        }
        return cYI;
    }

    private boolean aqo() {
        if (this.cYG == null) {
            this.cYG = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cYG.cYL) {
            return true;
        }
        if (this.cYG.isRunning) {
            this.cYG.count++;
            if (currentTimeMillis - this.cYG.cYK < 120000) {
                if (this.cYG.count >= cYF) {
                    this.cYG.cYL = true;
                    a(this.cYG);
                    return true;
                }
            } else {
                this.cYG.isRunning = false;
                this.cYG.count = 0;
            }
        } else {
            this.cYG.isRunning = true;
            this.cYG.cYK = currentTimeMillis;
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

    public void Q(bd bdVar) {
        if (bdVar != null && bdVar.ss()) {
            ak akVar = new ak("c11717");
            akVar.f(ImageViewerConfig.FORUM_ID, bdVar.getFid());
            akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdVar.aaj);
            akVar.ac("obj_param2", bdVar.aak);
            akVar.ac("obj_param1", bdVar.aao);
            akVar.r("obj_locate", 1);
            akVar.ac("tid", bdVar.getTid());
            s.abU().a(akVar);
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bd bdVar) {
        if (aVar != null && aVar.cYC && bdVar != null && bdVar.getTid() != null) {
            if (this.cYH == null) {
                this.cYH = new HashSet<>();
            }
            if (!this.cYH.contains(bdVar.getTid()) && !aqo()) {
                this.cYH.add(bdVar.getTid());
                ak akVar = new ak("c11439");
                akVar.ac(ImageViewerConfig.FORUM_ID, aVar.cYE);
                akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdVar.aaj);
                akVar.ac("obj_param2", bdVar.aak);
                akVar.ac("obj_param1", bdVar.aal);
                akVar.r("obj_locate", aVar.cYD);
                akVar.ac("tid", bdVar.getTid());
                akVar.ac("obj_param3", bdVar.aao);
                akVar.r("obj_id", C(bdVar));
                akVar.ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                akVar.f("exposure_time", System.currentTimeMillis());
                boolean z = (bdVar.sO() == null || (bdVar.sO().bwr() == null && bdVar.sO().Jy() == null)) ? false : true;
                if (z && bdVar.sO().bwr() != null && bdVar.sO().bwr().Jq() != null && bdVar.sO().bwr().Jq().size() > 0) {
                    akVar.r("obj_name", bdVar.sO().gzM ? 3 : 2);
                } else {
                    akVar.r("obj_name", z ? 1 : 0);
                }
                s.abU().a(akVar);
                if (bdVar.sk()) {
                    ak akVar2 = new ak("c12099");
                    akVar2.ac(ImageViewerConfig.FORUM_ID, aVar.cYE);
                    akVar2.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdVar.aaj);
                    akVar2.ac("obj_param2", bdVar.aak);
                    akVar2.ac("obj_param1", bdVar.aal);
                    akVar2.r("obj_locate", aVar.cYD);
                    akVar2.ac("tid", bdVar.getTid());
                    akVar2.ac("obj_param3", bdVar.aao);
                    akVar2.r("obj_id", C(bdVar));
                    akVar2.ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                    s.abU().a(akVar2);
                }
            }
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bd bdVar, int i) {
        if (aVar != null && aVar.cYC && bdVar != null && bdVar.getTid() != null) {
            s.abU().dT(true);
            ak akVar = new ak("c11438");
            akVar.ac(ImageViewerConfig.FORUM_ID, aVar.cYE);
            akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdVar.aaj);
            akVar.ac("obj_param2", bdVar.aak);
            akVar.ac("obj_param1", bdVar.aal);
            akVar.r("obj_locate", aVar.cYD);
            akVar.ac("tid", bdVar.getTid());
            akVar.r("obj_type", i);
            akVar.ac("obj_param3", bdVar.aao);
            akVar.r("obj_id", C(bdVar));
            akVar.ac("obj_to", R(bdVar));
            TiebaStatic.log(akVar);
            if (bdVar.sk()) {
                ak akVar2 = new ak("c12098");
                akVar2.ac(ImageViewerConfig.FORUM_ID, aVar.cYE);
                akVar2.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdVar.aaj);
                akVar2.ac("obj_param2", bdVar.aak);
                akVar2.ac("obj_param1", bdVar.aal);
                akVar2.r("obj_locate", aVar.cYD);
                akVar2.ac("tid", bdVar.getTid());
                akVar2.r("obj_type", i);
                akVar2.ac("obj_param3", bdVar.aao);
                akVar2.r("obj_id", C(bdVar));
                akVar2.ac("obj_to", R(bdVar));
                TiebaStatic.log(akVar2);
            }
        }
    }

    public static void a(k kVar, int i, int i2) {
        if (kVar != null && kVar.aRf() != null && kVar.gwD == 1) {
            TiebaStatic.log(new ak("c11440").ac(ImageViewerConfig.FORUM_ID, kVar.aRf().getId()).r("obj_locate", i).r("obj_type", i2));
        }
    }

    private int C(bd bdVar) {
        if (bdVar.sC() == null || bdVar.sC().channelId <= 0) {
            return 0;
        }
        return (int) bdVar.sC().channelId;
    }

    private String R(bd bdVar) {
        return bdVar.aap ? String.valueOf(bdVar.sz()) : String.valueOf(4);
    }
}
