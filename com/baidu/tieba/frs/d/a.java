package com.baidu.tieba.frs.d;

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
    private C0056a caN;
    private f caO;
    private DrawerLayout.DrawerListener caP = new b(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0056a extends DrawerLayout {
        public C0056a(Context context) {
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
        if (this.caN == null) {
            this.caN = new C0056a(activity);
            this.caN.setDrawerListener(this.caP);
        }
        return this.caN;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void a(Activity activity, View view, View view2) {
        activity.setContentView(this.caN);
        this.caN.addView(view);
        this.caN.addView(view2, new DrawerLayout.LayoutParams((int) (k.af(activity) * 0.72f), -1, GravityCompat.END));
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void acK() {
        this.caN.openDrawer(GravityCompat.END);
        if (this.caO != null) {
            this.caO.acI();
        }
    }

    public void aed() {
        this.caN.closeDrawer(GravityCompat.END);
        if (this.caO != null) {
            this.caO.acJ();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void ej(boolean z) {
        if (z) {
            this.caN.setDrawerLockMode(0);
        } else {
            this.caN.setDrawerLockMode(1);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void a(f fVar) {
        this.caO = fVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public boolean acL() {
        return this.caN.isDrawerOpen(GravityCompat.END);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void ek(boolean z) {
        if (acL()) {
            aed();
        } else {
            acK();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void el(boolean z) {
        aed();
    }
}
