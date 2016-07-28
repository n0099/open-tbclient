package com.baidu.tieba.frs.h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.bw;
import com.baidu.tieba.tbadkCore.p;
import java.util.HashSet;
/* loaded from: classes.dex */
public class b {
    public static int bSa;
    private static b bSd;
    private a bSb;
    private HashSet<String> bSc;
    private CustomMessageListener LT = new c(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private Handler mHandler = new d(this, Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long bSf;
        public boolean bSg;
        public int count;
        public boolean gv;

        private a() {
            this.gv = false;
            this.count = 0;
            this.bSg = false;
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }

    public b() {
        bSa = com.baidu.tbadk.core.sharedPref.b.sN().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.LT);
    }

    public static b aam() {
        if (bSd == null) {
            synchronized (bw.class) {
                if (bSd == null) {
                    bSd = new b();
                }
            }
        }
        return bSd;
    }

    private boolean aan() {
        if (this.bSb == null) {
            this.bSb = new a(this, null);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bSb.bSg) {
            return true;
        }
        if (this.bSb.gv) {
            this.bSb.count++;
            if (currentTimeMillis - this.bSb.bSf < 120000) {
                if (this.bSb.count >= bSa) {
                    this.bSb.bSg = true;
                    a(this.bSb);
                    return true;
                }
            } else {
                this.bSb.gv = false;
                this.bSb.count = 0;
            }
        } else {
            this.bSb.gv = true;
            this.bSb.bSf = currentTimeMillis;
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

    public void a(com.baidu.tieba.frs.h.a aVar, be beVar) {
        if (aVar != null && aVar.bRX && beVar != null && beVar.getTid() != null) {
            if (this.bSc == null) {
                this.bSc = new HashSet<>();
            }
            if (!this.bSc.contains(beVar.getTid()) && !aan()) {
                this.bSc.add(beVar.getTid());
                ay ayVar = new ay("c11439");
                ayVar.ab("fid", aVar.bRZ);
                ayVar.ab("obj_source", beVar.RT);
                ayVar.ab("obj_param2", beVar.RU);
                ayVar.ab("obj_param1", beVar.RV);
                ayVar.s("obj_locate", aVar.bRY);
                ayVar.ab("tid", beVar.getTid());
                bw.Lf().b(ayVar);
            }
        }
    }

    public void a(com.baidu.tieba.frs.h.a aVar, be beVar, int i) {
        if (aVar != null && aVar.bRX && beVar != null && beVar.getTid() != null) {
            bw.Lf().cm(true);
            ay ayVar = new ay("c11438");
            ayVar.ab("fid", aVar.bRZ);
            ayVar.ab("obj_source", beVar.RT);
            ayVar.ab("obj_param2", beVar.RU);
            ayVar.ab("obj_param1", beVar.RV);
            ayVar.s("obj_locate", aVar.bRY);
            ayVar.ab("tid", beVar.getTid());
            ayVar.s("obj_type", i);
            TiebaStatic.log(ayVar);
        }
    }

    public static void a(p pVar, int i, int i2) {
        if (pVar != null && pVar.aGX() != null && pVar.fig == 1) {
            TiebaStatic.log(new ay("c11440").ab("fid", pVar.aGX().getId()).s("obj_locate", i).s("obj_type", i2));
        }
    }
}
