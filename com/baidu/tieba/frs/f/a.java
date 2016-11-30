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
    private C0061a cgM;
    private f cgN;
    private DrawerLayout.DrawerListener cgO = new b(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0061a extends DrawerLayout {
        public C0061a(Context context) {
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
        if (this.cgM == null) {
            this.cgM = new C0061a(activity);
            this.cgM.setDrawerListener(this.cgO);
        }
        return this.cgM;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void a(Activity activity, View view, View view2) {
        activity.setContentView(this.cgM);
        this.cgM.addView(view);
        this.cgM.addView(view2, new DrawerLayout.LayoutParams((int) (k.K(activity) * 0.72f), -1, GravityCompat.END));
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void aeS() {
        this.cgM.openDrawer(GravityCompat.END);
        if (this.cgN != null) {
            this.cgN.aeQ();
        }
    }

    public void agI() {
        this.cgM.closeDrawer(GravityCompat.END);
        if (this.cgN != null) {
            this.cgN.aeR();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void ei(boolean z) {
        if (z) {
            this.cgM.setDrawerLockMode(0);
        } else {
            this.cgM.setDrawerLockMode(1);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void a(f fVar) {
        this.cgN = fVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public boolean aeT() {
        return this.cgM.isDrawerOpen(GravityCompat.END);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void ej(boolean z) {
        if (aeT()) {
            agI();
        } else {
            aeS();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void ek(boolean z) {
        agI();
    }
}
