package com.baidu.tieba.frs.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.ca;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.n;
import java.util.HashSet;
/* loaded from: classes.dex */
public class b {
    public static int bYU;
    private static b bYX;
    private a bYV;
    private HashSet<String> bYW;
    private CustomMessageListener Sj = new c(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private Handler mHandler = new d(this, Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long bYZ;
        public boolean bZa;
        public int count;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.bZa = false;
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }

    public b() {
        bYU = com.baidu.tbadk.core.sharedPref.b.tX().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.Sj);
    }

    public static b acs() {
        if (bYX == null) {
            synchronized (ca.class) {
                if (bYX == null) {
                    bYX = new b();
                }
            }
        }
        return bYX;
    }

    private boolean act() {
        if (this.bYV == null) {
            this.bYV = new a(this, null);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bYV.bZa) {
            return true;
        }
        if (this.bYV.isRunning) {
            this.bYV.count++;
            if (currentTimeMillis - this.bYV.bYZ < 120000) {
                if (this.bYV.count >= bYU) {
                    this.bYV.bZa = true;
                    a(this.bYV);
                    return true;
                }
            } else {
                this.bYV.isRunning = false;
                this.bYV.count = 0;
            }
        } else {
            this.bYV.isRunning = true;
            this.bYV.bYZ = currentTimeMillis;
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

    public void C(bk bkVar) {
        if (bkVar != null && bkVar.ss()) {
            as asVar = new as("c11717");
            asVar.g("fid", bkVar.getFid());
            asVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bkVar.YQ);
            asVar.aa("obj_param2", bkVar.YR);
            asVar.aa("obj_param1", bkVar.YV);
            asVar.s("obj_locate", 1);
            asVar.aa("tid", bkVar.getTid());
            ca.To().a(asVar);
        }
    }

    public void a(com.baidu.tieba.frs.c.a aVar, bk bkVar) {
        if (aVar != null && aVar.bYR && bkVar != null && bkVar.getTid() != null) {
            if (this.bYW == null) {
                this.bYW = new HashSet<>();
            }
            if (!this.bYW.contains(bkVar.getTid()) && !act()) {
                this.bYW.add(bkVar.getTid());
                as asVar = new as("c11439");
                asVar.aa("fid", aVar.bYT);
                asVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bkVar.YQ);
                asVar.aa("obj_param2", bkVar.YR);
                asVar.aa("obj_param1", bkVar.YS);
                asVar.s("obj_locate", aVar.bYS);
                asVar.aa("tid", bkVar.getTid());
                asVar.aa("obj_param3", bkVar.YV);
                asVar.s("obj_id", r(bkVar));
                asVar.aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                ca.To().a(asVar);
                if (bkVar.sl()) {
                    as asVar2 = new as("c12099");
                    asVar2.aa("fid", aVar.bYT);
                    asVar2.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bkVar.YQ);
                    asVar2.aa("obj_param2", bkVar.YR);
                    asVar2.aa("obj_param1", bkVar.YS);
                    asVar2.s("obj_locate", aVar.bYS);
                    asVar2.aa("tid", bkVar.getTid());
                    asVar2.aa("obj_param3", bkVar.YV);
                    asVar2.s("obj_id", r(bkVar));
                    asVar2.aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                    ca.To().a(asVar2);
                }
            }
        }
    }

    public void a(com.baidu.tieba.frs.c.a aVar, bk bkVar, int i) {
        if (aVar != null && aVar.bYR && bkVar != null && bkVar.getTid() != null) {
            ca.To().dc(true);
            as asVar = new as("c11438");
            asVar.aa("fid", aVar.bYT);
            asVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bkVar.YQ);
            asVar.aa("obj_param2", bkVar.YR);
            asVar.aa("obj_param1", bkVar.YS);
            asVar.s("obj_locate", aVar.bYS);
            asVar.aa("tid", bkVar.getTid());
            asVar.s("obj_type", i);
            asVar.aa("obj_param3", bkVar.YV);
            asVar.s("obj_id", r(bkVar));
            asVar.aa("obj_to", D(bkVar));
            TiebaStatic.log(asVar);
            if (bkVar.sl()) {
                as asVar2 = new as("c12098");
                asVar2.aa("fid", aVar.bYT);
                asVar2.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bkVar.YQ);
                asVar2.aa("obj_param2", bkVar.YR);
                asVar2.aa("obj_param1", bkVar.YS);
                asVar2.s("obj_locate", aVar.bYS);
                asVar2.aa("tid", bkVar.getTid());
                asVar2.s("obj_type", i);
                asVar2.aa("obj_param3", bkVar.YV);
                asVar2.s("obj_id", r(bkVar));
                asVar2.aa("obj_to", D(bkVar));
                TiebaStatic.log(asVar2);
            }
        }
    }

    public static void a(n nVar, int i, int i2) {
        if (nVar != null && nVar.aHE() != null && nVar.frQ == 1) {
            TiebaStatic.log(new as("c11440").aa("fid", nVar.aHE().getId()).s("obj_locate", i).s("obj_type", i2));
        }
    }

    private int r(bk bkVar) {
        if (bkVar.sC() == null || bkVar.sC().channelId <= 0) {
            return 0;
        }
        return (int) bkVar.sC().channelId;
    }

    private String D(bk bkVar) {
        return bkVar.YW ? String.valueOf(bkVar.sz()) : String.valueOf(4);
    }
}
