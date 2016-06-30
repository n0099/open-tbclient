package com.baidu.tieba.frs.g;

import android.support.v4.widget.DrawerLayout;
import android.view.View;
import com.baidu.tieba.frs.entelechy.b.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements DrawerLayout.DrawerListener {
    final /* synthetic */ a bQj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bQj = aVar;
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(View view, float f) {
        f fVar;
        if (f == 0.0f) {
            fVar = this.bQj.bQh;
            fVar.Yg();
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(View view) {
        f fVar;
        f fVar2;
        fVar = this.bQj.bQh;
        if (fVar != null) {
            fVar2 = this.bQj.bQh;
            fVar2.onOpened();
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(View view) {
        f fVar;
        f fVar2;
        fVar = this.bQj.bQh;
        if (fVar != null) {
            fVar2 = this.bQj.bQh;
            fVar2.onClosed();
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerStateChanged(int i) {
        f fVar;
        f fVar2;
        if (i == 1) {
            fVar = this.bQj.bQh;
            if (fVar != null) {
                fVar2 = this.bQj.bQh;
                fVar2.Yf();
            }
        }
    }
}
