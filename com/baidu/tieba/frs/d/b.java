package com.baidu.tieba.frs.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.n;
import java.util.HashSet;
/* loaded from: classes.dex */
public class b {
    public static int cff;
    private static b cfi;
    private a cfg;
    private HashSet<String> cfh;
    private CustomMessageListener RW = new c(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private Handler mHandler = new d(this, Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long cfk;
        public boolean cfl;
        public int count;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.cfl = false;
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }

    public b() {
        cff = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.RW);
    }

    public static b adw() {
        if (cfi == null) {
            synchronized (cf.class) {
                if (cfi == null) {
                    cfi = new b();
                }
            }
        }
        return cfi;
    }

    private boolean adx() {
        if (this.cfg == null) {
            this.cfg = new a(this, null);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cfg.cfl) {
            return true;
        }
        if (this.cfg.isRunning) {
            this.cfg.count++;
            if (currentTimeMillis - this.cfg.cfk < 120000) {
                if (this.cfg.count >= cff) {
                    this.cfg.cfl = true;
                    a(this.cfg);
                    return true;
                }
            } else {
                this.cfg.isRunning = false;
                this.cfg.count = 0;
            }
        } else {
            this.cfg.isRunning = true;
            this.cfg.cfk = currentTimeMillis;
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

    public void H(bl blVar) {
        if (blVar != null && blVar.so()) {
            as asVar = new as("c11717");
            asVar.f("fid", blVar.getFid());
            asVar.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, blVar.YM);
            asVar.Z("obj_param2", blVar.YN);
            asVar.Z("obj_param1", blVar.YR);
            asVar.r("obj_locate", 1);
            asVar.Z("tid", blVar.getTid());
            cf.Uw().a(asVar);
        }
    }

    public void a(com.baidu.tieba.frs.d.a aVar, bl blVar) {
        if (aVar != null && aVar.cfc && blVar != null && blVar.getTid() != null) {
            if (this.cfh == null) {
                this.cfh = new HashSet<>();
            }
            if (!this.cfh.contains(blVar.getTid()) && !adx()) {
                this.cfh.add(blVar.getTid());
                as asVar = new as("c11439");
                asVar.Z("fid", aVar.cfe);
                asVar.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, blVar.YM);
                asVar.Z("obj_param2", blVar.YN);
                asVar.Z("obj_param1", blVar.YO);
                asVar.r("obj_locate", aVar.cfd);
                asVar.Z("tid", blVar.getTid());
                asVar.Z("obj_param3", blVar.YR);
                asVar.r("obj_id", v(blVar));
                asVar.Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                asVar.r("obj_name", blVar.sG() != null && blVar.sG().avd() != null && !au.isEmpty(blVar.sG().bU(TbadkCoreApplication.m9getInst())) ? 1 : 0);
                cf.Uw().a(asVar);
                if (blVar.sh()) {
                    as asVar2 = new as("c12099");
                    asVar2.Z("fid", aVar.cfe);
                    asVar2.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, blVar.YM);
                    asVar2.Z("obj_param2", blVar.YN);
                    asVar2.Z("obj_param1", blVar.YO);
                    asVar2.r("obj_locate", aVar.cfd);
                    asVar2.Z("tid", blVar.getTid());
                    asVar2.Z("obj_param3", blVar.YR);
                    asVar2.r("obj_id", v(blVar));
                    asVar2.Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                    cf.Uw().a(asVar2);
                }
            }
        }
    }

    public void a(com.baidu.tieba.frs.d.a aVar, bl blVar, int i) {
        if (aVar != null && aVar.cfc && blVar != null && blVar.getTid() != null) {
            cf.Uw().dt(true);
            as asVar = new as("c11438");
            asVar.Z("fid", aVar.cfe);
            asVar.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, blVar.YM);
            asVar.Z("obj_param2", blVar.YN);
            asVar.Z("obj_param1", blVar.YO);
            asVar.r("obj_locate", aVar.cfd);
            asVar.Z("tid", blVar.getTid());
            asVar.r("obj_type", i);
            asVar.Z("obj_param3", blVar.YR);
            asVar.r("obj_id", v(blVar));
            asVar.Z("obj_to", I(blVar));
            TiebaStatic.log(asVar);
            if (blVar.sh()) {
                as asVar2 = new as("c12098");
                asVar2.Z("fid", aVar.cfe);
                asVar2.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, blVar.YM);
                asVar2.Z("obj_param2", blVar.YN);
                asVar2.Z("obj_param1", blVar.YO);
                asVar2.r("obj_locate", aVar.cfd);
                asVar2.Z("tid", blVar.getTid());
                asVar2.r("obj_type", i);
                asVar2.Z("obj_param3", blVar.YR);
                asVar2.r("obj_id", v(blVar));
                asVar2.Z("obj_to", I(blVar));
                TiebaStatic.log(asVar2);
            }
        }
    }

    public static void a(n nVar, int i, int i2) {
        if (nVar != null && nVar.aIz() != null && nVar.fzF == 1) {
            TiebaStatic.log(new as("c11440").Z("fid", nVar.aIz().getId()).r("obj_locate", i).r("obj_type", i2));
        }
    }

    private int v(bl blVar) {
        if (blVar.sx() == null || blVar.sx().channelId <= 0) {
            return 0;
        }
        return (int) blVar.sx().channelId;
    }

    private String I(bl blVar) {
        return blVar.YS ? String.valueOf(blVar.su()) : String.valueOf(4);
    }
}
