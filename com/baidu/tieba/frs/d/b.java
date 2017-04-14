package com.baidu.tieba.frs.d;

import android.support.v4.widget.DrawerLayout;
import android.view.View;
import com.baidu.tieba.frs.entelechy.b.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements DrawerLayout.DrawerListener {
    final /* synthetic */ a bYz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bYz = aVar;
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(View view, float f) {
        f fVar;
        if (f == 0.0f) {
            fVar = this.bYz.bYx;
            fVar.abI();
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(View view) {
        f fVar;
        f fVar2;
        fVar = this.bYz.bYx;
        if (fVar != null) {
            fVar2 = this.bYz.bYx;
            fVar2.abF();
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(View view) {
        f fVar;
        f fVar2;
        fVar = this.bYz.bYx;
        if (fVar != null) {
            fVar2 = this.bYz.bYx;
            fVar2.abG();
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerStateChanged(int i) {
        f fVar;
        f fVar2;
        if (i == 1) {
            fVar = this.bYz.bYx;
            if (fVar != null) {
                fVar2 = this.bYz.bYx;
                fVar2.abH();
            }
        }
    }
}
