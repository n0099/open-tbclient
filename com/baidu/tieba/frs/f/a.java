package com.baidu.tieba.frs.f;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.k;
import com.baidu.tieba.frs.entelechy.b.f;
import com.baidu.tieba.frs.entelechy.b.g;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
public class a implements g {
    private SlidingMenu bsB;
    f bsC;
    private SlidingMenu.OnOpenedListener bsD = new b(this);
    private SlidingMenu.OnClosedListener bsE = new c(this);

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public ViewGroup n(Activity activity) {
        if (this.bsB == null) {
            this.bsB = new SlidingMenu(activity);
            this.bsB.setBackgroundColor(activity.getResources().getColor(17170444));
            this.bsB.setMode(1);
            this.bsB.setTouchModeAbove(1);
            this.bsB.setBehindOffset((int) (k.B(activity) * 0.3d));
            this.bsB.setBehindScrollScale(0.5f);
            this.bsB.setFadeDegree(0.35f);
            this.bsB.setOnOpenedListener(this.bsD);
            this.bsB.setOnClosedListener(this.bsE);
        }
        return this.bsB;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void a(Activity activity, View view, View view2) {
        if (this.bsB != null) {
            activity.setContentView(view);
            this.bsB.attachToActivity(activity, 1, true);
            this.bsB.setMenu(view2);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void SG() {
        if (this.bsB != null) {
            this.bsB.showMenu();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void df(boolean z) {
        if (this.bsB != null) {
            this.bsB.setSlidingEnabled(z);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void a(f fVar) {
        this.bsC = fVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public boolean isMenuShowing() {
        if (this.bsB != null) {
            return this.bsB.isMenuShowing();
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void toggle(boolean z) {
        if (this.bsB != null) {
            this.bsB.toggle(z);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void showContent(boolean z) {
        if (this.bsB != null) {
            this.bsB.showContent(z);
        }
    }
}
