package com.baidu.tieba.im.floatwindow;

import android.graphics.Point;
import android.os.Handler;
import android.os.SystemClock;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements n {
    private long aYL = 0;
    final /* synthetic */ b aYM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aYM = bVar;
    }

    @Override // com.baidu.tieba.im.floatwindow.n
    public void R(int i, int i2) {
        com.baidu.tieba.im.floatwindow.view.f Nz;
        Handler handler;
        com.baidu.tieba.im.floatwindow.view.a Ny;
        com.baidu.tieba.im.floatwindow.view.f Nz2;
        boolean a;
        com.baidu.tieba.im.floatwindow.view.f Nz3;
        com.baidu.tieba.im.floatwindow.view.f Nz4;
        if (SystemClock.elapsedRealtime() - this.aYL <= 300) {
            return;
        }
        Nz = this.aYM.Nz();
        handler = this.aYM.handler;
        Nz.b(handler);
        b bVar = this.aYM;
        Ny = this.aYM.Ny();
        j NG = Ny.NG();
        Nz2 = this.aYM.Nz();
        a = bVar.a(NG, Nz2.NX());
        if (a) {
            Nz4 = this.aYM.Nz();
            Nz4.NY();
            return;
        }
        Nz3 = this.aYM.Nz();
        Nz3.NZ();
    }

    @Override // com.baidu.tieba.im.floatwindow.n
    public void S(int i, int i2) {
        this.aYL = SystemClock.elapsedRealtime();
    }

    @Override // com.baidu.tieba.im.floatwindow.n
    public void ND() {
        com.baidu.tieba.im.floatwindow.view.a Ny;
        com.baidu.tieba.im.floatwindow.view.f Nz;
        boolean a;
        com.baidu.tieba.im.floatwindow.view.a Ny2;
        com.baidu.tieba.im.floatwindow.view.f Nz2;
        Handler handler;
        b bVar = this.aYM;
        Ny = this.aYM.Ny();
        j NG = Ny.NG();
        Nz = this.aYM.Nz();
        a = bVar.a(NG, Nz.NX());
        if (a) {
            this.aYM.cK(true);
        } else {
            Ny2 = this.aYM.Ny();
            Ny2.NU();
        }
        Nz2 = this.aYM.Nz();
        handler = this.aYM.handler;
        Nz2.c(handler);
    }

    @Override // com.baidu.tieba.im.floatwindow.n
    public void NE() {
        com.baidu.tieba.im.floatwindow.view.a Ny;
        com.baidu.tieba.im.floatwindow.view.a Ny2;
        com.baidu.tieba.im.floatwindow.view.f Nz;
        Handler handler;
        Ny = this.aYM.Ny();
        if (!Ny.NT()) {
            Point point = new Point(TbadkCoreApplication.m255getInst().getResources().getDimensionPixelSize(u.ds30), TbadkCoreApplication.m255getInst().getResources().getDimensionPixelSize(u.ds20));
            this.aYM.aYy = false;
            Ny2 = this.aYM.Ny();
            Ny2.b(point);
            Nz = this.aYM.Nz();
            handler = this.aYM.handler;
            Nz.c(handler);
        }
    }
}
