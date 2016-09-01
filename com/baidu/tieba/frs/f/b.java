package com.baidu.tieba.frs.f;

import android.support.v4.widget.DrawerLayout;
import android.view.View;
import com.baidu.tieba.frs.entelechy.b.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements DrawerLayout.DrawerListener {
    final /* synthetic */ a cdc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cdc = aVar;
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(View view, float f) {
        f fVar;
        if (f == 0.0f) {
            fVar = this.cdc.cda;
            fVar.adm();
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(View view) {
        f fVar;
        f fVar2;
        fVar = this.cdc.cda;
        if (fVar != null) {
            fVar2 = this.cdc.cda;
            fVar2.onOpened();
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(View view) {
        f fVar;
        f fVar2;
        fVar = this.cdc.cda;
        if (fVar != null) {
            fVar2 = this.cdc.cda;
            fVar2.onClosed();
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerStateChanged(int i) {
        f fVar;
        f fVar2;
        if (i == 1) {
            fVar = this.cdc.cda;
            if (fVar != null) {
                fVar2 = this.cdc.cda;
                fVar2.adl();
            }
        }
    }
}
