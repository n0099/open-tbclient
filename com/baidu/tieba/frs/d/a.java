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
    private C0057a bZV;
    private f bZW;
    private DrawerLayout.DrawerListener bZX = new b(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0057a extends DrawerLayout {
        public C0057a(Context context) {
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
        if (this.bZV == null) {
            this.bZV = new C0057a(activity);
            this.bZV.setDrawerListener(this.bZX);
        }
        return this.bZV;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void a(Activity activity, View view, View view2) {
        activity.setContentView(this.bZV);
        this.bZV.addView(view);
        this.bZV.addView(view2, new DrawerLayout.LayoutParams((int) (k.ag(activity) * 0.72f), -1, GravityCompat.END));
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void abm() {
        this.bZV.openDrawer(GravityCompat.END);
        if (this.bZW != null) {
            this.bZW.abk();
        }
    }

    public void adi() {
        this.bZV.closeDrawer(GravityCompat.END);
        if (this.bZW != null) {
            this.bZW.abl();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void dX(boolean z) {
        if (z) {
            this.bZV.setDrawerLockMode(0);
        } else {
            this.bZV.setDrawerLockMode(1);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void a(f fVar) {
        this.bZW = fVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public boolean abn() {
        return this.bZV.isDrawerOpen(GravityCompat.END);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void dY(boolean z) {
        if (abn()) {
            adi();
        } else {
            abm();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void dZ(boolean z) {
        adi();
    }
}
