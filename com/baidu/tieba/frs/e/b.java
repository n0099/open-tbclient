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
    public static int cxH;
    private static b cxK;
    private a cxI;
    private HashSet<String> cxJ;
    private CustomMessageListener TD = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.e.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.cxJ != null) {
                b.this.cxJ.clear();
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
                        aVar.cxN = false;
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
        public long cxM;
        public boolean cxN;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.cxN = false;
        }
    }

    public b() {
        cxH = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.TD);
    }

    public static b ajF() {
        if (cxK == null) {
            synchronized (u.class) {
                if (cxK == null) {
                    cxK = new b();
                }
            }
        }
        return cxK;
    }

    private boolean ajG() {
        if (this.cxI == null) {
            this.cxI = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cxI.cxN) {
            return true;
        }
        if (this.cxI.isRunning) {
            this.cxI.count++;
            if (currentTimeMillis - this.cxI.cxM < 120000) {
                if (this.cxI.count >= cxH) {
                    this.cxI.cxN = true;
                    a(this.cxI);
                    return true;
                }
            } else {
                this.cxI.isRunning = false;
                this.cxI.count = 0;
            }
        } else {
            this.cxI.isRunning = true;
            this.cxI.cxM = currentTimeMillis;
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
            ajVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, blVar.aaC);
            ajVar.aa("obj_param2", blVar.aaD);
            ajVar.aa("obj_param1", blVar.aaH);
            ajVar.r("obj_locate", 1);
            ajVar.aa("tid", blVar.getTid());
            u.WX().a(ajVar);
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bl blVar) {
        if (aVar != null && aVar.cxE && blVar != null && blVar.getTid() != null) {
            if (this.cxJ == null) {
                this.cxJ = new HashSet<>();
            }
            if (!this.cxJ.contains(blVar.getTid()) && !ajG()) {
                this.cxJ.add(blVar.getTid());
                aj ajVar = new aj("c11439");
                ajVar.aa("fid", aVar.cxG);
                ajVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, blVar.aaC);
                ajVar.aa("obj_param2", blVar.aaD);
                ajVar.aa("obj_param1", blVar.aaE);
                ajVar.r("obj_locate", aVar.cxF);
                ajVar.aa("tid", blVar.getTid());
                ajVar.aa("obj_param3", blVar.aaH);
                ajVar.r("obj_id", A(blVar));
                ajVar.aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                ajVar.g("exposure_time", System.currentTimeMillis());
                ajVar.r("obj_name", blVar.sU() != null && (blVar.sU().aBw() != null || blVar.sU().Iv() != null) ? 1 : 0);
                u.WX().a(ajVar);
                if (blVar.ss()) {
                    aj ajVar2 = new aj("c12099");
                    ajVar2.aa("fid", aVar.cxG);
                    ajVar2.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, blVar.aaC);
                    ajVar2.aa("obj_param2", blVar.aaD);
                    ajVar2.aa("obj_param1", blVar.aaE);
                    ajVar2.r("obj_locate", aVar.cxF);
                    ajVar2.aa("tid", blVar.getTid());
                    ajVar2.aa("obj_param3", blVar.aaH);
                    ajVar2.r("obj_id", A(blVar));
                    ajVar2.aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                    u.WX().a(ajVar2);
                }
            }
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bl blVar, int i) {
        if (aVar != null && aVar.cxE && blVar != null && blVar.getTid() != null) {
            u.WX().dF(true);
            aj ajVar = new aj("c11438");
            ajVar.aa("fid", aVar.cxG);
            ajVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, blVar.aaC);
            ajVar.aa("obj_param2", blVar.aaD);
            ajVar.aa("obj_param1", blVar.aaE);
            ajVar.r("obj_locate", aVar.cxF);
            ajVar.aa("tid", blVar.getTid());
            ajVar.r("obj_type", i);
            ajVar.aa("obj_param3", blVar.aaH);
            ajVar.r("obj_id", A(blVar));
            ajVar.aa("obj_to", N(blVar));
            TiebaStatic.log(ajVar);
            if (blVar.ss()) {
                aj ajVar2 = new aj("c12098");
                ajVar2.aa("fid", aVar.cxG);
                ajVar2.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, blVar.aaC);
                ajVar2.aa("obj_param2", blVar.aaD);
                ajVar2.aa("obj_param1", blVar.aaE);
                ajVar2.r("obj_locate", aVar.cxF);
                ajVar2.aa("tid", blVar.getTid());
                ajVar2.r("obj_type", i);
                ajVar2.aa("obj_param3", blVar.aaH);
                ajVar2.r("obj_id", A(blVar));
                ajVar2.aa("obj_to", N(blVar));
                TiebaStatic.log(ajVar2);
            }
        }
    }

    public static void a(i iVar, int i, int i2) {
        if (iVar != null && iVar.aPO() != null && iVar.ghi == 1) {
            TiebaStatic.log(new aj("c11440").aa("fid", iVar.aPO().getId()).r("obj_locate", i).r("obj_type", i2));
        }
    }

    private int A(bl blVar) {
        if (blVar.sJ() == null || blVar.sJ().channelId <= 0) {
            return 0;
        }
        return (int) blVar.sJ().channelId;
    }

    private String N(bl blVar) {
        return blVar.aaI ? String.valueOf(blVar.sG()) : String.valueOf(4);
    }
}
