package com.baidu.tieba.frs.e;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.k;
import com.baidu.tieba.frs.entelechy.b.f;
import com.baidu.tieba.frs.entelechy.b.g;
/* loaded from: classes.dex */
public class a implements g {
    private C0059a bMv;
    private f bMw;
    private DrawerLayout.DrawerListener bMx = new b(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0059a extends DrawerLayout {
        public C0059a(Context context) {
            super(context);
        }

        @Override // android.view.View
        public void setOnDragListener(View.OnDragListener onDragListener) {
            super.setOnDragListener(onDragListener);
        }

        @Override // android.support.v4.widget.DrawerLayout, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            if (i == 4) {
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }

        @Override // android.support.v4.widget.DrawerLayout, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyUp(int i, KeyEvent keyEvent) {
            if (i == 4) {
                return false;
            }
            return super.onKeyUp(i, keyEvent);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public ViewGroup t(Activity activity) {
        if (this.bMv == null) {
            this.bMv = new C0059a(activity);
            this.bMv.setDrawerListener(this.bMx);
        }
        return this.bMv;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void a(Activity activity, View view, View view2) {
        activity.setContentView(this.bMv);
        this.bMv.addView(view);
        this.bMv.addView(view2, new DrawerLayout.LayoutParams((int) (k.I(activity) * 0.72f), -1, GravityCompat.END));
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void Zn() {
        this.bMv.openDrawer(GravityCompat.END);
        if (this.bMw != null) {
            this.bMw.Zl();
        }
    }

    public void abe() {
        this.bMv.closeDrawer(GravityCompat.END);
        if (this.bMw != null) {
            this.bMw.Zm();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void dS(boolean z) {
        if (z) {
            this.bMv.setDrawerLockMode(0);
        } else {
            this.bMv.setDrawerLockMode(1);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void a(f fVar) {
        this.bMw = fVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public boolean Zo() {
        return this.bMv.isDrawerOpen(GravityCompat.END);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void dT(boolean z) {
        if (Zo()) {
            abe();
        } else {
            Zn();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void dU(boolean z) {
        abe();
    }
}
