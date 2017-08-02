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
    public static int cum;
    private static b cup;
    private a cun;
    private HashSet<String> cuo;
    private CustomMessageListener Se = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.f.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.cuo != null) {
                b.this.cuo.clear();
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
                        aVar.cus = false;
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
        public long cur;
        public boolean cus;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.cus = false;
        }
    }

    public b() {
        cum = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.Se);
    }

    public static b aiM() {
        if (cup == null) {
            synchronized (u.class) {
                if (cup == null) {
                    cup = new b();
                }
            }
        }
        return cup;
    }

    private boolean aiN() {
        if (this.cun == null) {
            this.cun = new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cun.cus) {
            return true;
        }
        if (this.cun.isRunning) {
            this.cun.count++;
            if (currentTimeMillis - this.cun.cur < 120000) {
                if (this.cun.count >= cum) {
                    this.cun.cus = true;
                    a(this.cun);
                    return true;
                }
            } else {
                this.cun.isRunning = false;
                this.cun.count = 0;
            }
        } else {
            this.cun.isRunning = true;
            this.cun.cur = currentTimeMillis;
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
        if (blVar != null && blVar.sp()) {
            aj ajVar = new aj("c11717");
            ajVar.f("fid", blVar.getFid());
            ajVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, blVar.Ze);
            ajVar.aa("obj_param2", blVar.Zf);
            ajVar.aa("obj_param1", blVar.Zj);
            ajVar.r("obj_locate", 1);
            ajVar.aa("tid", blVar.getTid());
            u.Ww().a(ajVar);
        }
    }

    public void a(com.baidu.tieba.frs.f.a aVar, bl blVar) {
        if (aVar != null && aVar.cuj && blVar != null && blVar.getTid() != null) {
            if (this.cuo == null) {
                this.cuo = new HashSet<>();
            }
            if (!this.cuo.contains(blVar.getTid()) && !aiN()) {
                this.cuo.add(blVar.getTid());
                aj ajVar = new aj("c11439");
                ajVar.aa("fid", aVar.cul);
                ajVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, blVar.Ze);
                ajVar.aa("obj_param2", blVar.Zf);
                ajVar.aa("obj_param1", blVar.Zg);
                ajVar.r("obj_locate", aVar.cuk);
                ajVar.aa("tid", blVar.getTid());
                ajVar.aa("obj_param3", blVar.Zj);
                ajVar.r("obj_id", A(blVar));
                ajVar.aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                ajVar.f("exposure_time", System.currentTimeMillis());
                ajVar.r("obj_name", blVar.sK() != null && (blVar.sK().aAE() != null || blVar.sK().Io() != null) ? 1 : 0);
                u.Ww().a(ajVar);
                if (blVar.si()) {
                    aj ajVar2 = new aj("c12099");
                    ajVar2.aa("fid", aVar.cul);
                    ajVar2.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, blVar.Ze);
                    ajVar2.aa("obj_param2", blVar.Zf);
                    ajVar2.aa("obj_param1", blVar.Zg);
                    ajVar2.r("obj_locate", aVar.cuk);
                    ajVar2.aa("tid", blVar.getTid());
                    ajVar2.aa("obj_param3", blVar.Zj);
                    ajVar2.r("obj_id", A(blVar));
                    ajVar2.aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                    u.Ww().a(ajVar2);
                }
            }
        }
    }

    public void a(com.baidu.tieba.frs.f.a aVar, bl blVar, int i) {
        if (aVar != null && aVar.cuj && blVar != null && blVar.getTid() != null) {
            u.Ww().dE(true);
            aj ajVar = new aj("c11438");
            ajVar.aa("fid", aVar.cul);
            ajVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, blVar.Ze);
            ajVar.aa("obj_param2", blVar.Zf);
            ajVar.aa("obj_param1", blVar.Zg);
            ajVar.r("obj_locate", aVar.cuk);
            ajVar.aa("tid", blVar.getTid());
            ajVar.r("obj_type", i);
            ajVar.aa("obj_param3", blVar.Zj);
            ajVar.r("obj_id", A(blVar));
            ajVar.aa("obj_to", N(blVar));
            TiebaStatic.log(ajVar);
            if (blVar.si()) {
                aj ajVar2 = new aj("c12098");
                ajVar2.aa("fid", aVar.cul);
                ajVar2.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, blVar.Ze);
                ajVar2.aa("obj_param2", blVar.Zf);
                ajVar2.aa("obj_param1", blVar.Zg);
                ajVar2.r("obj_locate", aVar.cuk);
                ajVar2.aa("tid", blVar.getTid());
                ajVar2.r("obj_type", i);
                ajVar2.aa("obj_param3", blVar.Zj);
                ajVar2.r("obj_id", A(blVar));
                ajVar2.aa("obj_to", N(blVar));
                TiebaStatic.log(ajVar2);
            }
        }
    }

    public static void a(i iVar, int i, int i2) {
        if (iVar != null && iVar.aOW() != null && iVar.gef == 1) {
            TiebaStatic.log(new aj("c11440").aa("fid", iVar.aOW().getId()).r("obj_locate", i).r("obj_type", i2));
        }
    }

    private int A(bl blVar) {
        if (blVar.sz() == null || blVar.sz().channelId <= 0) {
            return 0;
        }
        return (int) blVar.sz().channelId;
    }

    private String N(bl blVar) {
        return blVar.Zk ? String.valueOf(blVar.sw()) : String.valueOf(4);
    }
}
