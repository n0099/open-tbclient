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
    private C0058a bSJ;
    private f bSK;
    private DrawerLayout.DrawerListener bSL = new b(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.d.a$a  reason: collision with other inner class name */
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
        if (this.bSJ == null) {
            this.bSJ = new C0058a(activity);
            this.bSJ.setDrawerListener(this.bSL);
        }
        return this.bSJ;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void a(Activity activity, View view, View view2) {
        activity.setContentView(this.bSJ);
        this.bSJ.addView(view);
        this.bSJ.addView(view2, new DrawerLayout.LayoutParams((int) (k.I(activity) * 0.72f), -1, GravityCompat.END));
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void aap() {
        this.bSJ.openDrawer(GravityCompat.END);
        if (this.bSK != null) {
            this.bSK.aan();
        }
    }

    public void acl() {
        this.bSJ.closeDrawer(GravityCompat.END);
        if (this.bSK != null) {
            this.bSK.aao();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void dX(boolean z) {
        if (z) {
            this.bSJ.setDrawerLockMode(0);
        } else {
            this.bSJ.setDrawerLockMode(1);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void a(f fVar) {
        this.bSK = fVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public boolean aaq() {
        return this.bSJ.isDrawerOpen(GravityCompat.END);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void dY(boolean z) {
        if (aaq()) {
            acl();
        } else {
            aap();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void dZ(boolean z) {
        acl();
    }
}
