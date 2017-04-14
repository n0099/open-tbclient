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
    private C0056a bYw;
    private f bYx;
    private DrawerLayout.DrawerListener bYy = new b(this);

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
        if (this.bYw == null) {
            this.bYw = new C0056a(activity);
            this.bYw.setDrawerListener(this.bYy);
        }
        return this.bYw;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void a(Activity activity, View view, View view2) {
        activity.setContentView(this.bYw);
        this.bYw.addView(view);
        this.bYw.addView(view2, new DrawerLayout.LayoutParams((int) (k.af(activity) * 0.72f), -1, GravityCompat.END));
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void abJ() {
        this.bYw.openDrawer(GravityCompat.END);
        if (this.bYx != null) {
            this.bYx.abH();
        }
    }

    public void adc() {
        this.bYw.closeDrawer(GravityCompat.END);
        if (this.bYx != null) {
            this.bYx.abI();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void dZ(boolean z) {
        if (z) {
            this.bYw.setDrawerLockMode(0);
        } else {
            this.bYw.setDrawerLockMode(1);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void a(f fVar) {
        this.bYx = fVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public boolean abK() {
        return this.bYw.isDrawerOpen(GravityCompat.END);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void ea(boolean z) {
        if (abK()) {
            adc();
        } else {
            abJ();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.g
    public void eb(boolean z) {
        adc();
    }
}
