package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.editortools.noConflictPanel.widget.KPSwitchFSPanelFrameLayout;
import com.baidu.tieba.R;
import d.a.c.e.m.e;
import d.a.c.e.p.l;
import d.a.m0.w.h;
import d.a.m0.w.n;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class EditorDesk extends KPSwitchFSPanelFrameLayout {

    /* renamed from: f  reason: collision with root package name */
    public LinkedList<h> f12804f;

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<n> f12805g;

    /* renamed from: h  reason: collision with root package name */
    public int f12806h;

    /* renamed from: i  reason: collision with root package name */
    public n f12807i;
    public boolean j;
    public boolean k;
    public EditorTools l;
    public Runnable m;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EditorDesk.this.f12807i != null) {
                EditorDesk.this.f12807i.b();
            }
        }
    }

    public EditorDesk(Context context, EditorTools editorTools) {
        super(context);
        this.f12806h = R.color.CAM_X0206;
        this.f12807i = null;
        this.j = true;
        this.k = false;
        this.m = new a();
        this.f12804f = new LinkedList<>();
        this.f12805g = new LinkedList<>();
        this.l = editorTools;
    }

    public void d(h hVar) {
        this.f12804f.add(hVar);
    }

    public void e(n nVar) {
        this.f12805g.add(nVar);
    }

    public void f() {
        Iterator<n> it = this.f12805g.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next.getToolId() == 2) {
                k(next);
            }
            if (next instanceof View) {
                View view = (View) next;
                view.setVisibility(8);
                addView(view, -1, getContext().getResources().getDimensionPixelSize(R.dimen.ds460));
            }
            next.init();
        }
        invalidate();
    }

    public void g() {
        n nVar = this.f12807i;
        if (nVar != null) {
            nVar.hide();
        }
        this.f12807i = null;
    }

    public void h(int i2) {
        if (m(i2)) {
            if (p()) {
                this.j = true;
            } else {
                this.j = false;
            }
            boolean z = this.k;
            Iterator<n> it = this.f12805g.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.k = true;
                }
                if (next.getToolId() == i2) {
                    this.f12807i = next;
                    if (this.j) {
                        next.b();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.j && (getContext() instanceof Activity)) {
                EditorTools editorTools = this.l;
                if (editorTools != null) {
                    editorTools.p();
                } else {
                    l.x(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                e.a().postDelayed(this.m, 250L);
            }
            j();
        }
    }

    public void i() {
        this.f12807i = null;
        this.f12804f.clear();
        this.f12805g.clear();
    }

    public void j() {
        setVisibility(0);
    }

    public final void k(n nVar) {
        if (nVar instanceof MoreDeskView) {
            ((MoreDeskView) nVar).p(this.f12804f);
            nVar.init();
        }
    }

    public h l(int i2) {
        Iterator<h> it = this.f12804f.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (next.getToolId() == i2) {
                return next;
            }
        }
        return null;
    }

    public final boolean m(int i2) {
        Iterator<n> it = this.f12805g.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i2) {
                return true;
            }
        }
        return false;
    }

    public void n() {
        n nVar = this.f12807i;
        if (nVar != null) {
            nVar.hide();
        }
        this.f12807i = null;
        setVisibility(8);
    }

    public void o() {
        if (this.f12807i != null) {
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        s(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public final boolean p() {
        Iterator<n> it = this.f12805g.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean q() {
        return getVisibility() == 0 && p();
    }

    public void r(int i2) {
        int i3 = this.f12806h;
        if (i3 > 0) {
            SkinManager.setBackgroundColor(this, i3, i2);
        }
        Iterator<h> it = this.f12804f.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i2);
        }
        Iterator<n> it2 = this.f12805g.iterator();
        while (it2.hasNext()) {
            n next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            s(true);
        }
        super.requestDisallowInterceptTouchEvent(false);
    }

    public final void s(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setBackgroundColorId(int i2) {
        super.setBackgroundColor(getContext().getResources().getColor(i2));
        this.f12806h = i2;
    }

    public void setDeskLauncherEnabled(boolean z) {
        Iterator<h> it = this.f12804f.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (next != null && (next instanceof View)) {
                ((View) next).setEnabled(z);
            }
        }
    }

    public boolean t(boolean z, int i2) {
        Iterator<h> it = this.f12804f.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (next instanceof View) {
                View view = (View) next;
                if (next.getToolId() == i2) {
                    view.setEnabled(z);
                    return true;
                }
            }
        }
        return false;
    }
}
