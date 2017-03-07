package com.baidu.tieba.frs.d;

import android.support.v4.widget.DrawerLayout;
import android.view.View;
import com.baidu.tieba.frs.entelechy.b.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements DrawerLayout.DrawerListener {
    final /* synthetic */ a bZY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bZY = aVar;
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(View view, float f) {
        f fVar;
        if (f == 0.0f) {
            fVar = this.bZY.bZW;
            fVar.abl();
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(View view) {
        f fVar;
        f fVar2;
        fVar = this.bZY.bZW;
        if (fVar != null) {
            fVar2 = this.bZY.bZW;
            fVar2.abi();
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(View view) {
        f fVar;
        f fVar2;
        fVar = this.bZY.bZW;
        if (fVar != null) {
            fVar2 = this.bZY.bZW;
            fVar2.abj();
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerStateChanged(int i) {
        f fVar;
        f fVar2;
        if (i == 1) {
            fVar = this.bZY.bZW;
            if (fVar != null) {
                fVar2 = this.bZY.bZW;
                fVar2.abk();
            }
        }
    }
}
