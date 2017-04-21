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
    public static int cbg;
    private static b cbj;
    private a cbh;
    private HashSet<String> cbi;
    private CustomMessageListener SQ = new c(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private Handler mHandler = new d(this, Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long cbl;
        public boolean cbm;
        public int count;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.cbm = false;
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }

    public b() {
        cbg = com.baidu.tbadk.core.sharedPref.b.uL().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.SQ);
    }

    public static b aeq() {
        if (cbj == null) {
            synchronized (cc.class) {
                if (cbj == null) {
                    cbj = new b();
                }
            }
        }
        return cbj;
    }

    private boolean aer() {
        if (this.cbh == null) {
            this.cbh = new a(this, null);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cbh.cbm) {
            return true;
        }
        if (this.cbh.isRunning) {
            this.cbh.count++;
            if (currentTimeMillis - this.cbh.cbl < 120000) {
                if (this.cbh.count >= cbg) {
                    this.cbh.cbm = true;
                    a(this.cbh);
                    return true;
                }
            } else {
                this.cbh.isRunning = false;
                this.cbh.count = 0;
            }
        } else {
            this.cbh.isRunning = true;
            this.cbh.cbl = currentTimeMillis;
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
            asVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, biVar.Zy);
            asVar.aa("obj_param2", biVar.Zz);
            asVar.aa("obj_param1", biVar.ZD);
            asVar.s("obj_locate", 1);
            asVar.aa("tid", biVar.getTid());
            cc.TV().a(asVar);
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bi biVar) {
        if (aVar != null && aVar.cbd && biVar != null && biVar.getTid() != null) {
            if (this.cbi == null) {
                this.cbi = new HashSet<>();
            }
            if (!this.cbi.contains(biVar.getTid()) && !aer()) {
                this.cbi.add(biVar.getTid());
                as asVar = new as("c11439");
                asVar.aa("fid", aVar.cbf);
                asVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, biVar.Zy);
                asVar.aa("obj_param2", biVar.Zz);
                asVar.aa("obj_param1", biVar.ZA);
                asVar.s("obj_locate", aVar.cbe);
                asVar.aa("tid", biVar.getTid());
                asVar.aa("obj_param3", biVar.ZD);
                asVar.s("obj_id", m(biVar));
                asVar.aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                cc.TV().a(asVar);
                if (biVar.tb()) {
                    as asVar2 = new as("c12099");
                    asVar2.aa("fid", aVar.cbf);
                    asVar2.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, biVar.Zy);
                    asVar2.aa("obj_param2", biVar.Zz);
                    asVar2.aa("obj_param1", biVar.ZA);
                    asVar2.s("obj_locate", aVar.cbe);
                    asVar2.aa("tid", biVar.getTid());
                    asVar2.aa("obj_param3", biVar.ZD);
                    asVar2.s("obj_id", m(biVar));
                    asVar2.aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                    cc.TV().a(asVar2);
                }
            }
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bi biVar, int i) {
        if (aVar != null && aVar.cbd && biVar != null && biVar.getTid() != null) {
            cc.TV().cZ(true);
            as asVar = new as("c11438");
            asVar.aa("fid", aVar.cbf);
            asVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, biVar.Zy);
            asVar.aa("obj_param2", biVar.Zz);
            asVar.aa("obj_param1", biVar.ZA);
            asVar.s("obj_locate", aVar.cbe);
            asVar.aa("tid", biVar.getTid());
            asVar.s("obj_type", i);
            asVar.aa("obj_param3", biVar.ZD);
            asVar.s("obj_id", m(biVar));
            asVar.aa("obj_to", y(biVar));
            TiebaStatic.log(asVar);
            if (biVar.tb()) {
                as asVar2 = new as("c12098");
                asVar2.aa("fid", aVar.cbf);
                asVar2.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, biVar.Zy);
                asVar2.aa("obj_param2", biVar.Zz);
                asVar2.aa("obj_param1", biVar.ZA);
                asVar2.s("obj_locate", aVar.cbe);
                asVar2.aa("tid", biVar.getTid());
                asVar2.s("obj_type", i);
                asVar2.aa("obj_param3", biVar.ZD);
                asVar2.s("obj_id", m(biVar));
                asVar2.aa("obj_to", y(biVar));
                TiebaStatic.log(asVar2);
            }
        }
    }

    public static void a(n nVar, int i, int i2) {
        if (nVar != null && nVar.aKx() != null && nVar.fvK == 1) {
            TiebaStatic.log(new as("c11440").aa("fid", nVar.aKx().getId()).s("obj_locate", i).s("obj_type", i2));
        }
    }

    private int m(bi biVar) {
        if (biVar.ts() == null || biVar.ts().channelId <= 0) {
            return 0;
        }
        return (int) biVar.ts().channelId;
    }

    private String y(bi biVar) {
        return biVar.ZE ? String.valueOf(biVar.tp()) : String.valueOf(4);
    }
}
