package com.baidu.tieba.frs.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.tbadkCore.p;
import java.util.HashSet;
/* loaded from: classes.dex */
public class b {
    public static int cde;
    private static b cdh;
    private a cdf;
    private HashSet<String> cdg;
    private CustomMessageListener Oi = new c(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private Handler mHandler = new d(this, Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long cdj;
        public boolean cdk;
        public int count;
        public boolean iO;

        private a() {
            this.iO = false;
            this.count = 0;
            this.cdk = false;
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }

    public b() {
        cde = com.baidu.tbadk.core.sharedPref.b.uh().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.Oi);
    }

    public static b afl() {
        if (cdh == null) {
            synchronized (cb.class) {
                if (cdh == null) {
                    cdh = new b();
                }
            }
        }
        return cdh;
    }

    private boolean afm() {
        if (this.cdf == null) {
            this.cdf = new a(this, null);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cdf.cdk) {
            return true;
        }
        if (this.cdf.iO) {
            this.cdf.count++;
            if (currentTimeMillis - this.cdf.cdj < 120000) {
                if (this.cdf.count >= cde) {
                    this.cdf.cdk = true;
                    a(this.cdf);
                    return true;
                }
            } else {
                this.cdf.iO = false;
                this.cdf.count = 0;
            }
        } else {
            this.cdf.iO = true;
            this.cdf.cdj = currentTimeMillis;
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

    public void a(com.baidu.tieba.frs.g.a aVar, bi biVar) {
        if (aVar != null && aVar.cdb && biVar != null && biVar.getTid() != null) {
            if (this.cdg == null) {
                this.cdg = new HashSet<>();
            }
            if (!this.cdg.contains(biVar.getTid()) && !afm()) {
                this.cdg.add(biVar.getTid());
                ax axVar = new ax("c11439");
                axVar.ab("fid", aVar.cdd);
                axVar.ab("obj_source", biVar.UO);
                axVar.ab("obj_param2", biVar.UQ);
                axVar.ab("obj_param1", biVar.UR);
                axVar.s("obj_locate", aVar.cdc);
                axVar.ab("tid", biVar.getTid());
                cb.Oj().a(axVar);
            }
        }
    }

    public void a(com.baidu.tieba.frs.g.a aVar, bi biVar, int i) {
        if (aVar != null && aVar.cdb && biVar != null && biVar.getTid() != null) {
            cb.Oj().cs(true);
            ax axVar = new ax("c11438");
            axVar.ab("fid", aVar.cdd);
            axVar.ab("obj_source", biVar.UO);
            axVar.ab("obj_param2", biVar.UQ);
            axVar.ab("obj_param1", biVar.UR);
            axVar.s("obj_locate", aVar.cdc);
            axVar.ab("tid", biVar.getTid());
            axVar.s("obj_type", i);
            TiebaStatic.log(axVar);
        }
    }

    public static void a(p pVar, int i, int i2) {
        if (pVar != null && pVar.aMr() != null && pVar.fsD == 1) {
            TiebaStatic.log(new ax("c11440").ab("fid", pVar.aMr().getId()).s("obj_locate", i).s("obj_type", i2));
        }
    }
}
