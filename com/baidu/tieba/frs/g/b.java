package com.baidu.tieba.frs.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.tbadkCore.o;
import java.util.HashSet;
/* loaded from: classes.dex */
public class b {
    public static int bMO;
    private static b bMR;
    private a bMP;
    private HashSet<String> bMQ;
    private CustomMessageListener Oh = new c(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private Handler mHandler = new d(this, Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long bMT;
        public boolean bMU;
        public int count;
        public boolean iO;

        private a() {
            this.iO = false;
            this.count = 0;
            this.bMU = false;
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }

    public b() {
        bMO = com.baidu.tbadk.core.sharedPref.b.tW().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.Oh);
    }

    public static b abq() {
        if (bMR == null) {
            synchronized (bz.class) {
                if (bMR == null) {
                    bMR = new b();
                }
            }
        }
        return bMR;
    }

    private boolean abr() {
        if (this.bMP == null) {
            this.bMP = new a(this, null);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bMP.bMU) {
            return true;
        }
        if (this.bMP.iO) {
            this.bMP.count++;
            if (currentTimeMillis - this.bMP.bMT < 120000) {
                if (this.bMP.count >= bMO) {
                    this.bMP.bMU = true;
                    a(this.bMP);
                    return true;
                }
            } else {
                this.bMP.iO = false;
                this.bMP.count = 0;
            }
        } else {
            this.bMP.iO = true;
            this.bMP.bMT = currentTimeMillis;
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

    public void x(bg bgVar) {
        if (bgVar != null && bgVar.sx()) {
            at atVar = new at("c11717");
            atVar.g("fid", bgVar.getFid());
            atVar.ab("obj_source", bgVar.UJ);
            atVar.ab("obj_param2", bgVar.UK);
            atVar.ab("obj_param1", bgVar.UO);
            atVar.s("obj_locate", 1);
            atVar.ab("tid", bgVar.getTid());
            bz.OH().a(atVar);
        }
    }

    public void a(com.baidu.tieba.frs.g.a aVar, bg bgVar) {
        if (aVar != null && aVar.bML && bgVar != null && bgVar.getTid() != null) {
            if (this.bMQ == null) {
                this.bMQ = new HashSet<>();
            }
            if (!this.bMQ.contains(bgVar.getTid()) && !abr()) {
                this.bMQ.add(bgVar.getTid());
                at atVar = new at("c11439");
                atVar.ab("fid", aVar.bMN);
                atVar.ab("obj_source", bgVar.UJ);
                atVar.ab("obj_param2", bgVar.UK);
                atVar.ab("obj_param1", bgVar.UL);
                atVar.s("obj_locate", aVar.bMM);
                atVar.ab("tid", bgVar.getTid());
                bz.OH().a(atVar);
            }
        }
    }

    public void a(com.baidu.tieba.frs.g.a aVar, bg bgVar, int i) {
        if (aVar != null && aVar.bML && bgVar != null && bgVar.getTid() != null) {
            bz.OH().cz(true);
            at atVar = new at("c11438");
            atVar.ab("fid", aVar.bMN);
            atVar.ab("obj_source", bgVar.UJ);
            atVar.ab("obj_param2", bgVar.UK);
            atVar.ab("obj_param1", bgVar.UL);
            atVar.s("obj_locate", aVar.bMM);
            atVar.ab("tid", bgVar.getTid());
            atVar.s("obj_type", i);
            TiebaStatic.log(atVar);
        }
    }

    public static void a(o oVar, int i, int i2) {
        if (oVar != null && oVar.aIk() != null && oVar.fdP == 1) {
            TiebaStatic.log(new at("c11440").ab("fid", oVar.aIk().getId()).s("obj_locate", i).s("obj_type", i2));
        }
    }
}
