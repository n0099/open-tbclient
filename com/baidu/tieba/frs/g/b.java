package com.baidu.tieba.frs.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.tbadkCore.p;
import java.util.HashSet;
/* loaded from: classes.dex */
public class b {
    public static int cdg;
    private static b cdj;
    private a cdh;
    private HashSet<String> cdi;
    private CustomMessageListener Oh = new c(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private Handler mHandler = new d(this, Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public long cdl;
        public boolean cdm;
        public int count;
        public boolean iO;

        private a() {
            this.iO = false;
            this.count = 0;
            this.cdm = false;
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }

    public b() {
        cdg = com.baidu.tbadk.core.sharedPref.b.tS().getInt("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.Oh);
    }

    public static b aeX() {
        if (cdj == null) {
            synchronized (cd.class) {
                if (cdj == null) {
                    cdj = new b();
                }
            }
        }
        return cdj;
    }

    private boolean aeY() {
        if (this.cdh == null) {
            this.cdh = new a(this, null);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cdh.cdm) {
            return true;
        }
        if (this.cdh.iO) {
            this.cdh.count++;
            if (currentTimeMillis - this.cdh.cdl < 120000) {
                if (this.cdh.count >= cdg) {
                    this.cdh.cdm = true;
                    a(this.cdh);
                    return true;
                }
            } else {
                this.cdh.iO = false;
                this.cdh.count = 0;
            }
        } else {
            this.cdh.iO = true;
            this.cdh.cdl = currentTimeMillis;
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

    public void a(com.baidu.tieba.frs.g.a aVar, bg bgVar) {
        if (aVar != null && aVar.cdd && bgVar != null && bgVar.getTid() != null) {
            if (this.cdi == null) {
                this.cdi = new HashSet<>();
            }
            if (!this.cdi.contains(bgVar.getTid()) && !aeY()) {
                this.cdi.add(bgVar.getTid());
                ay ayVar = new ay("c11439");
                ayVar.ab("fid", aVar.cdf);
                ayVar.ab("obj_source", bgVar.UD);
                ayVar.ab("obj_param2", bgVar.UE);
                ayVar.ab("obj_param1", bgVar.UF);
                ayVar.s("obj_locate", aVar.cde);
                ayVar.ab("tid", bgVar.getTid());
                cd.NI().b(ayVar);
            }
        }
    }

    public void a(com.baidu.tieba.frs.g.a aVar, bg bgVar, int i) {
        if (aVar != null && aVar.cdd && bgVar != null && bgVar.getTid() != null) {
            cd.NI().cs(true);
            ay ayVar = new ay("c11438");
            ayVar.ab("fid", aVar.cdf);
            ayVar.ab("obj_source", bgVar.UD);
            ayVar.ab("obj_param2", bgVar.UE);
            ayVar.ab("obj_param1", bgVar.UF);
            ayVar.s("obj_locate", aVar.cde);
            ayVar.ab("tid", bgVar.getTid());
            ayVar.s("obj_type", i);
            TiebaStatic.log(ayVar);
        }
    }

    public static void a(p pVar, int i, int i2) {
        if (pVar != null && pVar.aLP() != null && pVar.fpX == 1) {
            TiebaStatic.log(new ay("c11440").ab("fid", pVar.aLP().getId()).s("obj_locate", i).s("obj_type", i2));
        }
    }
}
