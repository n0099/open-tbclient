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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.card.u;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.i;
import java.util.HashSet;
/* loaded from: classes.dex */
public class b {
    public static int cvE;
    private static b cvH;
    private a cvF;
    private HashSet<String> cvG;
    private CustomMessageListener TB = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.e.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.cvG != null) {
                b.this.cvG.clear();
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
                        aVar.cvK = false;
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
        public int count;
        public long cvJ;
        public boolean cvK;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.cvK = false;
        }
    }

    public b() {
        cvE = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.TB);
    }

    public static b aiY() {
        if (cvH == null) {
            synchronized (u.class) {
                if (cvH == null) {
                    cvH = new b();
                }
            }
        }
        return cvH;
    }

    private boolean aiZ() {
        if (this.cvF == null) {
            this.cvF = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cvF.cvK) {
            return true;
        }
        if (this.cvF.isRunning) {
            this.cvF.count++;
            if (currentTimeMillis - this.cvF.cvJ < 120000) {
                if (this.cvF.count >= cvE) {
                    this.cvF.cvK = true;
                    a(this.cvF);
                    return true;
                }
            } else {
                this.cvF.isRunning = false;
                this.cvF.count = 0;
            }
        } else {
            this.cvF.isRunning = true;
            this.cvF.cvJ = currentTimeMillis;
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

    public void M(bl blVar) {
        if (blVar != null && blVar.sz()) {
            aj ajVar = new aj("c11717");
            ajVar.g("fid", blVar.getFid());
            ajVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, blVar.aaA);
            ajVar.aa("obj_param2", blVar.aaB);
            ajVar.aa("obj_param1", blVar.aaF);
            ajVar.r("obj_locate", 1);
            ajVar.aa("tid", blVar.getTid());
            u.WB().a(ajVar);
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bl blVar) {
        if (aVar != null && aVar.cvB && blVar != null && blVar.getTid() != null) {
            if (this.cvG == null) {
                this.cvG = new HashSet<>();
            }
            if (!this.cvG.contains(blVar.getTid()) && !aiZ()) {
                this.cvG.add(blVar.getTid());
                aj ajVar = new aj("c11439");
                ajVar.aa("fid", aVar.cvD);
                ajVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, blVar.aaA);
                ajVar.aa("obj_param2", blVar.aaB);
                ajVar.aa("obj_param1", blVar.aaC);
                ajVar.r("obj_locate", aVar.cvC);
                ajVar.aa("tid", blVar.getTid());
                ajVar.aa("obj_param3", blVar.aaF);
                ajVar.r("obj_id", A(blVar));
                ajVar.aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                ajVar.g("exposure_time", System.currentTimeMillis());
                ajVar.r("obj_name", blVar.sU() != null && (blVar.sU().aAP() != null || blVar.sU().Iv() != null) ? 1 : 0);
                u.WB().a(ajVar);
                if (blVar.ss()) {
                    aj ajVar2 = new aj("c12099");
                    ajVar2.aa("fid", aVar.cvD);
                    ajVar2.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, blVar.aaA);
                    ajVar2.aa("obj_param2", blVar.aaB);
                    ajVar2.aa("obj_param1", blVar.aaC);
                    ajVar2.r("obj_locate", aVar.cvC);
                    ajVar2.aa("tid", blVar.getTid());
                    ajVar2.aa("obj_param3", blVar.aaF);
                    ajVar2.r("obj_id", A(blVar));
                    ajVar2.aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                    u.WB().a(ajVar2);
                }
            }
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bl blVar, int i) {
        if (aVar != null && aVar.cvB && blVar != null && blVar.getTid() != null) {
            u.WB().dE(true);
            aj ajVar = new aj("c11438");
            ajVar.aa("fid", aVar.cvD);
            ajVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, blVar.aaA);
            ajVar.aa("obj_param2", blVar.aaB);
            ajVar.aa("obj_param1", blVar.aaC);
            ajVar.r("obj_locate", aVar.cvC);
            ajVar.aa("tid", blVar.getTid());
            ajVar.r("obj_type", i);
            ajVar.aa("obj_param3", blVar.aaF);
            ajVar.r("obj_id", A(blVar));
            ajVar.aa("obj_to", N(blVar));
            TiebaStatic.log(ajVar);
            if (blVar.ss()) {
                aj ajVar2 = new aj("c12098");
                ajVar2.aa("fid", aVar.cvD);
                ajVar2.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, blVar.aaA);
                ajVar2.aa("obj_param2", blVar.aaB);
                ajVar2.aa("obj_param1", blVar.aaC);
                ajVar2.r("obj_locate", aVar.cvC);
                ajVar2.aa("tid", blVar.getTid());
                ajVar2.r("obj_type", i);
                ajVar2.aa("obj_param3", blVar.aaF);
                ajVar2.r("obj_id", A(blVar));
                ajVar2.aa("obj_to", N(blVar));
                TiebaStatic.log(ajVar2);
            }
        }
    }

    public static void a(i iVar, int i, int i2) {
        if (iVar != null && iVar.aPh() != null && iVar.gfq == 1) {
            TiebaStatic.log(new aj("c11440").aa("fid", iVar.aPh().getId()).r("obj_locate", i).r("obj_type", i2));
        }
    }

    private int A(bl blVar) {
        if (blVar.sJ() == null || blVar.sJ().channelId <= 0) {
            return 0;
        }
        return (int) blVar.sJ().channelId;
    }

    private String N(bl blVar) {
        return blVar.aaG ? String.valueOf(blVar.sG()) : String.valueOf(4);
    }
}
