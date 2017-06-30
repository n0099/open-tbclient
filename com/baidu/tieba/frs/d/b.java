package com.baidu.tieba.frs.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.n;
import java.util.HashSet;
/* loaded from: classes.dex */
public class b {
    public static int cnv;
    private static b cny;
    private a cnw;
    private HashSet<String> cnx;
    private CustomMessageListener RR = new c(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private Handler mHandler = new d(this, Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long cnA;
        public boolean cnB;
        public int count;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.cnB = false;
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }

    public b() {
        cnv = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.RR);
    }

    public static b aho() {
        if (cny == null) {
            synchronized (cf.class) {
                if (cny == null) {
                    cny = new b();
                }
            }
        }
        return cny;
    }

    private boolean ahp() {
        if (this.cnw == null) {
            this.cnw = new a(this, null);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cnw.cnB) {
            return true;
        }
        if (this.cnw.isRunning) {
            this.cnw.count++;
            if (currentTimeMillis - this.cnw.cnA < 120000) {
                if (this.cnw.count >= cnv) {
                    this.cnw.cnB = true;
                    a(this.cnw);
                    return true;
                }
            } else {
                this.cnw.isRunning = false;
                this.cnw.count = 0;
            }
        } else {
            this.cnw.isRunning = true;
            this.cnw.cnA = currentTimeMillis;
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

    public void I(bm bmVar) {
        if (bmVar != null && bmVar.sl()) {
            au auVar = new au("c11717");
            auVar.f("fid", bmVar.getFid());
            auVar.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bmVar.YN);
            auVar.Z("obj_param2", bmVar.YO);
            auVar.Z("obj_param1", bmVar.YS);
            auVar.r("obj_locate", 1);
            auVar.Z("tid", bmVar.getTid());
            cf.VN().a(auVar);
        }
    }

    public void a(com.baidu.tieba.frs.d.a aVar, bm bmVar) {
        if (aVar != null && aVar.cnr && bmVar != null && bmVar.getTid() != null) {
            if (this.cnx == null) {
                this.cnx = new HashSet<>();
            }
            if (!this.cnx.contains(bmVar.getTid()) && !ahp()) {
                this.cnx.add(bmVar.getTid());
                au auVar = new au("c11439");
                auVar.Z("fid", aVar.cnu);
                auVar.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bmVar.YN);
                auVar.Z("obj_param2", bmVar.YO);
                auVar.Z("obj_param1", bmVar.YP);
                auVar.r("obj_locate", aVar.cns);
                auVar.Z("tid", bmVar.getTid());
                auVar.Z("obj_param3", bmVar.YS);
                auVar.r("obj_id", w(bmVar));
                auVar.Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                auVar.f("exposure_time", System.currentTimeMillis());
                auVar.r("obj_name", bmVar.sE() != null && (bmVar.sE().azb() != null || bmVar.sE().Ic() != null) ? 1 : 0);
                cf.VN().a(auVar);
                if (bmVar.se()) {
                    au auVar2 = new au("c12099");
                    auVar2.Z("fid", aVar.cnu);
                    auVar2.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bmVar.YN);
                    auVar2.Z("obj_param2", bmVar.YO);
                    auVar2.Z("obj_param1", bmVar.YP);
                    auVar2.r("obj_locate", aVar.cns);
                    auVar2.Z("tid", bmVar.getTid());
                    auVar2.Z("obj_param3", bmVar.YS);
                    auVar2.r("obj_id", w(bmVar));
                    auVar2.Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                    cf.VN().a(auVar2);
                }
            }
        }
    }

    public void a(com.baidu.tieba.frs.d.a aVar, bm bmVar, int i) {
        if (aVar != null && aVar.cnr && bmVar != null && bmVar.getTid() != null) {
            cf.VN().dv(true);
            au auVar = new au("c11438");
            auVar.Z("fid", aVar.cnu);
            auVar.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bmVar.YN);
            auVar.Z("obj_param2", bmVar.YO);
            auVar.Z("obj_param1", bmVar.YP);
            auVar.r("obj_locate", aVar.cns);
            auVar.Z("tid", bmVar.getTid());
            auVar.r("obj_type", i);
            auVar.Z("obj_param3", bmVar.YS);
            auVar.r("obj_id", w(bmVar));
            auVar.Z("obj_to", J(bmVar));
            TiebaStatic.log(auVar);
            if (bmVar.se()) {
                au auVar2 = new au("c12098");
                auVar2.Z("fid", aVar.cnu);
                auVar2.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bmVar.YN);
                auVar2.Z("obj_param2", bmVar.YO);
                auVar2.Z("obj_param1", bmVar.YP);
                auVar2.r("obj_locate", aVar.cns);
                auVar2.Z("tid", bmVar.getTid());
                auVar2.r("obj_type", i);
                auVar2.Z("obj_param3", bmVar.YS);
                auVar2.r("obj_id", w(bmVar));
                auVar2.Z("obj_to", J(bmVar));
                TiebaStatic.log(auVar2);
            }
        }
    }

    public static void a(n nVar, int i, int i2) {
        if (nVar != null && nVar.aMt() != null && nVar.fJJ == 1) {
            TiebaStatic.log(new au("c11440").Z("fid", nVar.aMt().getId()).r("obj_locate", i).r("obj_type", i2));
        }
    }

    private int w(bm bmVar) {
        if (bmVar.sv() == null || bmVar.sv().channelId <= 0) {
            return 0;
        }
        return (int) bmVar.sv().channelId;
    }

    private String J(bm bmVar) {
        return bmVar.YT ? String.valueOf(bmVar.ss()) : String.valueOf(4);
    }
}
