package com.baidu.tieba.frs.h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.tbadkCore.p;
import java.util.HashSet;
/* loaded from: classes.dex */
public class b {
    public static int chf;
    private static b chi;
    private a chg;
    private HashSet<String> chh;
    private CustomMessageListener Ol = new c(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private Handler mHandler = new d(this, Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long chk;
        public boolean chl;
        public int count;
        public boolean iP;

        private a() {
            this.iP = false;
            this.count = 0;
            this.chl = false;
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }

    public b() {
        chf = com.baidu.tbadk.core.sharedPref.b.um().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.Ol);
    }

    public static b agV() {
        if (chi == null) {
            synchronized (bx.class) {
                if (chi == null) {
                    chi = new b();
                }
            }
        }
        return chi;
    }

    private boolean agW() {
        if (this.chg == null) {
            this.chg = new a(this, null);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.chg.chl) {
            return true;
        }
        if (this.chg.iP) {
            this.chg.count++;
            if (currentTimeMillis - this.chg.chk < 120000) {
                if (this.chg.count >= chf) {
                    this.chg.chl = true;
                    a(this.chg);
                    return true;
                }
            } else {
                this.chg.iP = false;
                this.chg.count = 0;
            }
        } else {
            this.chg.iP = true;
            this.chg.chk = currentTimeMillis;
        }
        return false;
    }

    private void a(a aVar) {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 5;
        obtainMessage.obj = aVar;
        this.mHandler.removeMessages(5);
        this.mHandler.sendMessageDelayed(obtainMessage, 300000L);
    }

    public void s(bk bkVar) {
        if (bkVar != null && bkVar.sI()) {
            av avVar = new av("c11717");
            avVar.g("fid", bkVar.getFid());
            avVar.ab("obj_source", bkVar.Vl);
            avVar.ab("obj_param2", bkVar.Vm);
            avVar.ab("obj_param1", bkVar.Vq);
            avVar.s("obj_locate", 1);
            avVar.ab("tid", bkVar.getTid());
            bx.Pl().a(avVar);
        }
    }

    public void a(com.baidu.tieba.frs.h.a aVar, bk bkVar) {
        if (aVar != null && aVar.chc && bkVar != null && bkVar.getTid() != null) {
            if (this.chh == null) {
                this.chh = new HashSet<>();
            }
            if (!this.chh.contains(bkVar.getTid()) && !agW()) {
                this.chh.add(bkVar.getTid());
                av avVar = new av("c11439");
                avVar.ab("fid", aVar.che);
                avVar.ab("obj_source", bkVar.Vl);
                avVar.ab("obj_param2", bkVar.Vm);
                avVar.ab("obj_param1", bkVar.Vn);
                avVar.s("obj_locate", aVar.chd);
                avVar.ab("tid", bkVar.getTid());
                bx.Pl().a(avVar);
            }
        }
    }

    public void a(com.baidu.tieba.frs.h.a aVar, bk bkVar, int i) {
        if (aVar != null && aVar.chc && bkVar != null && bkVar.getTid() != null) {
            bx.Pl().cx(true);
            av avVar = new av("c11438");
            avVar.ab("fid", aVar.che);
            avVar.ab("obj_source", bkVar.Vl);
            avVar.ab("obj_param2", bkVar.Vm);
            avVar.ab("obj_param1", bkVar.Vn);
            avVar.s("obj_locate", aVar.chd);
            avVar.ab("tid", bkVar.getTid());
            avVar.s("obj_type", i);
            TiebaStatic.log(avVar);
        }
    }

    public static void a(p pVar, int i, int i2) {
        if (pVar != null && pVar.aOk() != null && pVar.fzN == 1) {
            TiebaStatic.log(new av("c11440").ab("fid", pVar.aOk().getId()).s("obj_locate", i).s("obj_type", i2));
        }
    }
}
