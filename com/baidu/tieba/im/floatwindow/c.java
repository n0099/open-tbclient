package com.baidu.tieba.im.floatwindow;

import android.graphics.Point;
import android.os.Handler;
import android.os.SystemClock;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements n {
    private long aYK = 0;
    final /* synthetic */ b aYL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aYL = bVar;
    }

    @Override // com.baidu.tieba.im.floatwindow.n
    public void S(int i, int i2) {
        com.baidu.tieba.im.floatwindow.view.f Nu;
        Handler handler;
        com.baidu.tieba.im.floatwindow.view.a Nt;
        com.baidu.tieba.im.floatwindow.view.f Nu2;
        boolean a;
        com.baidu.tieba.im.floatwindow.view.f Nu3;
        com.baidu.tieba.im.floatwindow.view.f Nu4;
        if (SystemClock.elapsedRealtime() - this.aYK <= 300) {
            return;
        }
        Nu = this.aYL.Nu();
        handler = this.aYL.handler;
        Nu.b(handler);
        b bVar = this.aYL;
        Nt = this.aYL.Nt();
        j NB = Nt.NB();
        Nu2 = this.aYL.Nu();
        a = bVar.a(NB, Nu2.NS());
        if (a) {
            Nu4 = this.aYL.Nu();
            Nu4.NT();
            return;
        }
        Nu3 = this.aYL.Nu();
        Nu3.NU();
    }

    @Override // com.baidu.tieba.im.floatwindow.n
    public void T(int i, int i2) {
        this.aYK = SystemClock.elapsedRealtime();
    }

    @Override // com.baidu.tieba.im.floatwindow.n
    public void Ny() {
        com.baidu.tieba.im.floatwindow.view.a Nt;
        com.baidu.tieba.im.floatwindow.view.f Nu;
        boolean a;
        com.baidu.tieba.im.floatwindow.view.a Nt2;
        com.baidu.tieba.im.floatwindow.view.f Nu2;
        Handler handler;
        b bVar = this.aYL;
        Nt = this.aYL.Nt();
        j NB = Nt.NB();
        Nu = this.aYL.Nu();
        a = bVar.a(NB, Nu.NS());
        if (a) {
            this.aYL.cK(true);
        } else {
            Nt2 = this.aYL.Nt();
            Nt2.NP();
        }
        Nu2 = this.aYL.Nu();
        handler = this.aYL.handler;
        Nu2.c(handler);
    }

    @Override // com.baidu.tieba.im.floatwindow.n
    public void Nz() {
        com.baidu.tieba.im.floatwindow.view.a Nt;
        com.baidu.tieba.im.floatwindow.view.a Nt2;
        com.baidu.tieba.im.floatwindow.view.f Nu;
        Handler handler;
        Nt = this.aYL.Nt();
        if (!Nt.NO()) {
            Point point = new Point(TbadkCoreApplication.m255getInst().getResources().getDimensionPixelSize(u.ds30), TbadkCoreApplication.m255getInst().getResources().getDimensionPixelSize(u.ds20));
            this.aYL.aYx = false;
            Nt2 = this.aYL.Nt();
            Nt2.b(point);
            Nu = this.aYL.Nu();
            handler = this.aYL.handler;
            Nu.c(handler);
        }
    }
}
