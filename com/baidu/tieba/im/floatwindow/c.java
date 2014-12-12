package com.baidu.tieba.im.floatwindow;

import android.graphics.Point;
import android.os.Handler;
import android.os.SystemClock;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements n {
    private long aXp = 0;
    final /* synthetic */ b aXq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aXq = bVar;
    }

    @Override // com.baidu.tieba.im.floatwindow.n
    public void Q(int i, int i2) {
        com.baidu.tieba.im.floatwindow.view.f Nd;
        Handler handler;
        com.baidu.tieba.im.floatwindow.view.a Nc;
        com.baidu.tieba.im.floatwindow.view.f Nd2;
        boolean a;
        com.baidu.tieba.im.floatwindow.view.f Nd3;
        com.baidu.tieba.im.floatwindow.view.f Nd4;
        if (SystemClock.elapsedRealtime() - this.aXp <= 300) {
            return;
        }
        Nd = this.aXq.Nd();
        handler = this.aXq.handler;
        Nd.b(handler);
        b bVar = this.aXq;
        Nc = this.aXq.Nc();
        j Nk = Nc.Nk();
        Nd2 = this.aXq.Nd();
        a = bVar.a(Nk, Nd2.NB());
        if (a) {
            Nd4 = this.aXq.Nd();
            Nd4.NC();
            return;
        }
        Nd3 = this.aXq.Nd();
        Nd3.ND();
    }

    @Override // com.baidu.tieba.im.floatwindow.n
    public void R(int i, int i2) {
        this.aXp = SystemClock.elapsedRealtime();
    }

    @Override // com.baidu.tieba.im.floatwindow.n
    public void Nh() {
        com.baidu.tieba.im.floatwindow.view.a Nc;
        com.baidu.tieba.im.floatwindow.view.f Nd;
        boolean a;
        com.baidu.tieba.im.floatwindow.view.a Nc2;
        com.baidu.tieba.im.floatwindow.view.f Nd2;
        Handler handler;
        b bVar = this.aXq;
        Nc = this.aXq.Nc();
        j Nk = Nc.Nk();
        Nd = this.aXq.Nd();
        a = bVar.a(Nk, Nd.NB());
        if (a) {
            this.aXq.cF(true);
        } else {
            Nc2 = this.aXq.Nc();
            Nc2.Ny();
        }
        Nd2 = this.aXq.Nd();
        handler = this.aXq.handler;
        Nd2.c(handler);
    }

    @Override // com.baidu.tieba.im.floatwindow.n
    public void Ni() {
        com.baidu.tieba.im.floatwindow.view.a Nc;
        com.baidu.tieba.im.floatwindow.view.a Nc2;
        com.baidu.tieba.im.floatwindow.view.f Nd;
        Handler handler;
        Nc = this.aXq.Nc();
        if (!Nc.Nx()) {
            Point point = new Point(TbadkCoreApplication.m255getInst().getResources().getDimensionPixelSize(u.ds30), TbadkCoreApplication.m255getInst().getResources().getDimensionPixelSize(u.ds20));
            this.aXq.aXc = false;
            Nc2 = this.aXq.Nc();
            Nc2.b(point);
            Nd = this.aXq.Nd();
            handler = this.aXq.handler;
            Nd.c(handler);
        }
    }
}
