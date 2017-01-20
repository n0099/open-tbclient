package com.baidu.tieba.frs.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.n;
import java.util.HashSet;
/* loaded from: classes.dex */
public class b {
    public static int bTc;
    private static b bTf;
    private a bTd;
    private HashSet<String> bTe;
    private CustomMessageListener Ns = new c(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private Handler mHandler = new d(this, Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long bTh;
        public boolean bTi;
        public int count;
        public boolean isRunning;

        private a() {
            this.isRunning = false;
            this.count = 0;
            this.bTi = false;
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }

    public b() {
        bTc = com.baidu.tbadk.core.sharedPref.b.tQ().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.Ns);
    }

    public static b acx() {
        if (bTf == null) {
            synchronized (cc.class) {
                if (bTf == null) {
                    bTf = new b();
                }
            }
        }
        return bTf;
    }

    private boolean acy() {
        if (this.bTd == null) {
            this.bTd = new a(this, null);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bTd.bTi) {
            return true;
        }
        if (this.bTd.isRunning) {
            this.bTd.count++;
            if (currentTimeMillis - this.bTd.bTh < 120000) {
                if (this.bTd.count >= bTc) {
                    this.bTd.bTi = true;
                    a(this.bTd);
                    return true;
                }
            } else {
                this.bTd.isRunning = false;
                this.bTd.count = 0;
            }
        } else {
            this.bTd.isRunning = true;
            this.bTd.bTh = currentTimeMillis;
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

    public void A(bh bhVar) {
        if (bhVar != null && bhVar.sp()) {
            ar arVar = new ar("c11717");
            arVar.g("fid", bhVar.getFid());
            arVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bhVar.TW);
            arVar.ab("obj_param2", bhVar.TX);
            arVar.ab("obj_param1", bhVar.Ub);
            arVar.s("obj_locate", 1);
            arVar.ab("tid", bhVar.getTid());
            cc.Rx().a(arVar);
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bh bhVar) {
        if (aVar != null && aVar.bSZ && bhVar != null && bhVar.getTid() != null) {
            if (this.bTe == null) {
                this.bTe = new HashSet<>();
            }
            if (!this.bTe.contains(bhVar.getTid()) && !acy()) {
                this.bTe.add(bhVar.getTid());
                ar arVar = new ar("c11439");
                arVar.ab("fid", aVar.bTb);
                arVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bhVar.TW);
                arVar.ab("obj_param2", bhVar.TX);
                arVar.ab("obj_param1", bhVar.TY);
                arVar.s("obj_locate", aVar.bTa);
                arVar.ab("tid", bhVar.getTid());
                arVar.ab("obj_param3", bhVar.Ub);
                arVar.s("obj_id", m(bhVar));
                arVar.ab(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                arVar.s("obj_type", 1);
                cc.Rx().a(arVar);
            }
        }
    }

    public void a(com.baidu.tieba.frs.e.a aVar, bh bhVar, int i) {
        if (aVar != null && aVar.bSZ && bhVar != null && bhVar.getTid() != null) {
            cc.Rx().cN(true);
            ar arVar = new ar("c11438");
            arVar.ab("fid", aVar.bTb);
            arVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bhVar.TW);
            arVar.ab("obj_param2", bhVar.TX);
            arVar.ab("obj_param1", bhVar.TY);
            arVar.s("obj_locate", aVar.bTa);
            arVar.ab("tid", bhVar.getTid());
            arVar.s("obj_type", i);
            arVar.ab("obj_param3", bhVar.Ub);
            arVar.s("obj_id", m(bhVar));
            arVar.ab("obj_to", B(bhVar));
            TiebaStatic.log(arVar);
        }
    }

    public static void a(n nVar, int i, int i2) {
        if (nVar != null && nVar.aJY() != null && nVar.fnk == 1) {
            TiebaStatic.log(new ar("c11440").ab("fid", nVar.aJY().getId()).s("obj_locate", i).s("obj_type", i2));
        }
    }

    private int m(bh bhVar) {
        if (bhVar.sz() == null || bhVar.sz().channelId <= 0) {
            return 0;
        }
        return (int) bhVar.sz().channelId;
    }

    private String B(bh bhVar) {
        return bhVar.Uc ? String.valueOf(bhVar.sw()) : String.valueOf(4);
    }
}
