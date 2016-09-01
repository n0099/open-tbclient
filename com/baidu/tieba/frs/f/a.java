package com.baidu.tieba.frs.f;

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
    private C0058a ccZ;
    private f cda;
    private DrawerLayout.DrawerListener cdb = new b(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0058a extends DrawerLayout {
        public C0058a(Context context) {
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
        if (this.ccZ == null) {
            this.ccZ = new C0058a(activity);
            this.ccZ.setDrawerListener(this.cdb);
        }
        return this.ccZ;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void a(Activity activity, View view, View view2) {
        activity.setContentView(this.ccZ);
        this.ccZ.addView(view);
        this.ccZ.addView(view2, new DrawerLayout.LayoutParams((int) (k.K(activity) * 0.72f), -1, GravityCompat.END));
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void adn() {
        this.ccZ.openDrawer(GravityCompat.END);
        if (this.cda != null) {
            this.cda.adl();
        }
    }

    public void aeW() {
        this.ccZ.closeDrawer(GravityCompat.END);
        if (this.cda != null) {
            this.cda.adm();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void dW(boolean z) {
        if (z) {
            this.ccZ.setDrawerLockMode(0);
        } else {
            this.ccZ.setDrawerLockMode(1);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void a(f fVar) {
        this.cda = fVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public boolean isMenuShowing() {
        return this.ccZ.isDrawerOpen(GravityCompat.END);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void dX(boolean z) {
        if (isMenuShowing()) {
            aeW();
        } else {
            adn();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void showContent(boolean z) {
        aeW();
    }
}
