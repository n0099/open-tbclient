package com.baidu.tieba.frs.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.n;
import java.util.HashSet;
/* loaded from: classes.dex */
public class b {
    public static int bYP;
    private static b bYS;
    private a bYQ;
    private HashSet<String> bYR;
    private CustomMessageListener SO = new c(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private Handler mHandler = new d(this, Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long bYU;
        public boolean bYV;
        public int count;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.bYV = false;
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }

    public b() {
        bYP = com.baidu.tbadk.core.sharedPref.b.uL().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.SO);
    }

    public static b adp() {
        if (bYS == null) {
            synchronized (cc.class) {
                if (bYS == null) {
                    bYS = new b();
                }
            }
        }
        return bYS;
    }

    private boolean adq() {
        if (this.bYQ == null) {
            this.bYQ = new a(this, null);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bYQ.bYV) {
            return true;
        }
        if (this.bYQ.isRunning) {
            this.bYQ.count++;
            if (currentTimeMillis - this.bYQ.bYU < 120000) {
                if (this.bYQ.count >= bYP) {
                    this.bYQ.bYV = true;
                    a(this.bYQ);
                    return true;
                }
            } else {
                this.bYQ.isRunning = false;
                this.bYQ.count = 0;
            }
        } else {
            this.bYQ.isRunning = true;
            this.bYQ.bYU = currentTimeMillis;
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

    public void x(bi biVar) {
        if (biVar != null && biVar.ti()) {
            as asVar = new as("c11717");
            asVar.g("fid", biVar.getFid());
            asVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, biVar.Zx);
            asVar.aa("obj_param2", biVar.Zy);
            asVar.aa("obj_param1", biVar.ZC);
            asVar.s("obj_locate", 1);
            asVar.aa("tid", biVar.getTid());
            cc.ST().a(asVar);
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bi biVar) {
        if (aVar != null && aVar.bYM && biVar != null && biVar.getTid() != null) {
            if (this.bYR == null) {
                this.bYR = new HashSet<>();
            }
            if (!this.bYR.contains(biVar.getTid()) && !adq()) {
                this.bYR.add(biVar.getTid());
                as asVar = new as("c11439");
                asVar.aa("fid", aVar.bYO);
                asVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, biVar.Zx);
                asVar.aa("obj_param2", biVar.Zy);
                asVar.aa("obj_param1", biVar.Zz);
                asVar.s("obj_locate", aVar.bYN);
                asVar.aa("tid", biVar.getTid());
                asVar.aa("obj_param3", biVar.ZC);
                asVar.s("obj_id", m(biVar));
                asVar.aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                asVar.s("obj_type", 1);
                cc.ST().a(asVar);
            }
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bi biVar, int i) {
        if (aVar != null && aVar.bYM && biVar != null && biVar.getTid() != null) {
            cc.ST().cP(true);
            as asVar = new as("c11438");
            asVar.aa("fid", aVar.bYO);
            asVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, biVar.Zx);
            asVar.aa("obj_param2", biVar.Zy);
            asVar.aa("obj_param1", biVar.Zz);
            asVar.s("obj_locate", aVar.bYN);
            asVar.aa("tid", biVar.getTid());
            asVar.s("obj_type", i);
            asVar.aa("obj_param3", biVar.ZC);
            asVar.s("obj_id", m(biVar));
            asVar.aa("obj_to", y(biVar));
            TiebaStatic.log(asVar);
        }
    }

    public static void a(n nVar, int i, int i2) {
        if (nVar != null && nVar.aJw() != null && nVar.ftt == 1) {
            TiebaStatic.log(new as("c11440").aa("fid", nVar.aJw().getId()).s("obj_locate", i).s("obj_type", i2));
        }
    }

    private int m(bi biVar) {
        if (biVar.ts() == null || biVar.ts().channelId <= 0) {
            return 0;
        }
        return (int) biVar.ts().channelId;
    }

    private String y(bi biVar) {
        return biVar.ZD ? String.valueOf(biVar.tp()) : String.valueOf(4);
    }
}
