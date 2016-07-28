package com.baidu.tieba.frs.g;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.k;
import com.baidu.tieba.frs.entelechy.b.f;
import com.baidu.tieba.frs.entelechy.b.g;
/* loaded from: classes.dex */
public class a implements g {
    private C0059a bRT;
    private f bRU;
    private DrawerLayout.DrawerListener bRV = new b(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0059a extends DrawerLayout {
        public C0059a(Context context) {
            super(context);
        }

        @Override // android.view.View
        public void setOnDragListener(View.OnDragListener onDragListener) {
            super.setOnDragListener(onDragListener);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public ViewGroup p(Activity activity) {
        if (this.bRT == null) {
            this.bRT = new C0059a(activity);
            this.bRT.setDrawerListener(this.bRV);
        }
        return this.bRT;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void a(Activity activity, View view, View view2) {
        activity.setContentView(this.bRT);
        this.bRT.addView(view);
        this.bRT.addView(view2, new DrawerLayout.LayoutParams((int) (k.A(activity) * 0.72f), -1, GravityCompat.END));
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void YB() {
        this.bRT.openDrawer(GravityCompat.END);
        if (this.bRU != null) {
            this.bRU.Yz();
        }
    }

    public void aal() {
        this.bRT.closeDrawer(GravityCompat.END);
        if (this.bRU != null) {
            this.bRU.YA();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void dA(boolean z) {
        if (z) {
            this.bRT.setDrawerLockMode(0);
        } else {
            this.bRT.setDrawerLockMode(1);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void a(f fVar) {
        this.bRU = fVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public boolean isMenuShowing() {
        return this.bRT.isDrawerOpen(GravityCompat.END);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void dB(boolean z) {
        if (isMenuShowing()) {
            aal();
        } else {
            YB();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void showContent(boolean z) {
        aal();
    }
}
