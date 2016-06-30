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
    private C0058a bQg;
    private f bQh;
    private DrawerLayout.DrawerListener bQi = new b(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0058a extends DrawerLayout {
        public C0058a(Context context) {
            super(context);
        }

        @Override // android.view.View
        public void setOnDragListener(View.OnDragListener onDragListener) {
            super.setOnDragListener(onDragListener);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public ViewGroup p(Activity activity) {
        if (this.bQg == null) {
            this.bQg = new C0058a(activity);
            this.bQg.setDrawerListener(this.bQi);
        }
        return this.bQg;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void a(Activity activity, View view, View view2) {
        activity.setContentView(this.bQg);
        this.bQg.addView(view);
        this.bQg.addView(view2, new DrawerLayout.LayoutParams((int) (k.A(activity) * 0.72f), -1, GravityCompat.END));
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void Yh() {
        this.bQg.openDrawer(GravityCompat.END);
        if (this.bQh != null) {
            this.bQh.Yf();
        }
    }

    public void ZM() {
        this.bQg.closeDrawer(GravityCompat.END);
        if (this.bQh != null) {
            this.bQh.Yg();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void dC(boolean z) {
        if (z) {
            this.bQg.setDrawerLockMode(0);
        } else {
            this.bQg.setDrawerLockMode(1);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void a(f fVar) {
        this.bQh = fVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public boolean isMenuShowing() {
        return this.bQg.isDrawerOpen(GravityCompat.END);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void dD(boolean z) {
        if (isMenuShowing()) {
            ZM();
        } else {
            Yh();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void showContent(boolean z) {
        ZM();
    }
}
