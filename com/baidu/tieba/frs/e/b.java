package com.baidu.tieba.frs.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.n;
import java.util.HashSet;
/* loaded from: classes.dex */
public class b {
    public static int cao;
    private static b car;
    private a cap;
    private HashSet<String> caq;
    private CustomMessageListener Sw = new c(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private Handler mHandler = new d(this, Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long cat;
        public boolean cau;
        public int count;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.cau = false;
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }

    public b() {
        cao = com.baidu.tbadk.core.sharedPref.b.uo().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.Sw);
    }

    public static b adv() {
        if (car == null) {
            synchronized (cc.class) {
                if (car == null) {
                    car = new b();
                }
            }
        }
        return car;
    }

    private boolean adw() {
        if (this.cap == null) {
            this.cap = new a(this, null);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cap.cau) {
            return true;
        }
        if (this.cap.isRunning) {
            this.cap.count++;
            if (currentTimeMillis - this.cap.cat < 120000) {
                if (this.cap.count >= cao) {
                    this.cap.cau = true;
                    a(this.cap);
                    return true;
                }
            } else {
                this.cap.isRunning = false;
                this.cap.count = 0;
            }
        } else {
            this.cap.isRunning = true;
            this.cap.cat = currentTimeMillis;
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

    public void A(bj bjVar) {
        if (bjVar != null && bjVar.sK()) {
            as asVar = new as("c11717");
            asVar.g("fid", bjVar.getFid());
            asVar.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bjVar.Zh);
            asVar.Z("obj_param2", bjVar.Zi);
            asVar.Z("obj_param1", bjVar.Zm);
            asVar.s("obj_locate", 1);
            asVar.Z("tid", bjVar.getTid());
            cc.Sv().a(asVar);
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bj bjVar) {
        if (aVar != null && aVar.cal && bjVar != null && bjVar.getTid() != null) {
            if (this.caq == null) {
                this.caq = new HashSet<>();
            }
            if (!this.caq.contains(bjVar.getTid()) && !adw()) {
                this.caq.add(bjVar.getTid());
                as asVar = new as("c11439");
                asVar.Z("fid", aVar.can);
                asVar.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bjVar.Zh);
                asVar.Z("obj_param2", bjVar.Zi);
                asVar.Z("obj_param1", bjVar.Zj);
                asVar.s("obj_locate", aVar.cam);
                asVar.Z("tid", bjVar.getTid());
                asVar.Z("obj_param3", bjVar.Zm);
                asVar.s("obj_id", m(bjVar));
                asVar.Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                asVar.s("obj_type", 1);
                cc.Sv().a(asVar);
            }
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bj bjVar, int i) {
        if (aVar != null && aVar.cal && bjVar != null && bjVar.getTid() != null) {
            cc.Sv().cN(true);
            as asVar = new as("c11438");
            asVar.Z("fid", aVar.can);
            asVar.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bjVar.Zh);
            asVar.Z("obj_param2", bjVar.Zi);
            asVar.Z("obj_param1", bjVar.Zj);
            asVar.s("obj_locate", aVar.cam);
            asVar.Z("tid", bjVar.getTid());
            asVar.s("obj_type", i);
            asVar.Z("obj_param3", bjVar.Zm);
            asVar.s("obj_id", m(bjVar));
            asVar.Z("obj_to", B(bjVar));
            TiebaStatic.log(asVar);
        }
    }

    public static void a(n nVar, int i, int i2) {
        if (nVar != null && nVar.aJp() != null && nVar.frI == 1) {
            TiebaStatic.log(new as("c11440").Z("fid", nVar.aJp().getId()).s("obj_locate", i).s("obj_type", i2));
        }
    }

    private int m(bj bjVar) {
        if (bjVar.sU() == null || bjVar.sU().channelId <= 0) {
            return 0;
        }
        return (int) bjVar.sU().channelId;
    }

    private String B(bj bjVar) {
        return bjVar.Zn ? String.valueOf(bjVar.sR()) : String.valueOf(4);
    }
}
