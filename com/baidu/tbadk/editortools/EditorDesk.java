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
import d.b.b.e.m.e;
import d.b.b.e.p.l;
import d.b.h0.w.h;
import d.b.h0.w.n;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class EditorDesk extends KPSwitchFSPanelFrameLayout {

    /* renamed from: f  reason: collision with root package name */
    public LinkedList<h> f13840f;

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<n> f13841g;

    /* renamed from: h  reason: collision with root package name */
    public int f13842h;
    public n i;
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
            if (EditorDesk.this.i != null) {
                EditorDesk.this.i.b();
            }
        }
    }

    public EditorDesk(Context context, EditorTools editorTools) {
        super(context);
        this.f13842h = R.color.CAM_X0206;
        this.i = null;
        this.j = true;
        this.k = false;
        this.m = new a();
        this.f13840f = new LinkedList<>();
        this.f13841g = new LinkedList<>();
        this.l = editorTools;
    }

    public void d(h hVar) {
        this.f13840f.add(hVar);
    }

    public void e(n nVar) {
        this.f13841g.add(nVar);
    }

    public void f() {
        Iterator<n> it = this.f13841g.iterator();
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
        n nVar = this.i;
        if (nVar != null) {
            nVar.hide();
        }
        this.i = null;
    }

    public void h(int i) {
        if (m(i)) {
            if (p()) {
                this.j = true;
            } else {
                this.j = false;
            }
            boolean z = this.k;
            Iterator<n> it = this.f13841g.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.k = true;
                }
                if (next.getToolId() == i) {
                    this.i = next;
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
                    l.w(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                e.a().postDelayed(this.m, 250L);
            }
            j();
        }
    }

    public void i() {
        this.i = null;
        this.f13840f.clear();
        this.f13841g.clear();
    }

    public void j() {
        setVisibility(0);
    }

    public final void k(n nVar) {
        if (nVar instanceof MoreDeskView) {
            ((MoreDeskView) nVar).p(this.f13840f);
            nVar.init();
        }
    }

    public h l(int i) {
        Iterator<h> it = this.f13840f.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public final boolean m(int i) {
        Iterator<n> it = this.f13841g.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public void n() {
        n nVar = this.i;
        if (nVar != null) {
            nVar.hide();
        }
        this.i = null;
        setVisibility(8);
    }

    public void o() {
        if (this.i != null) {
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
        Iterator<n> it = this.f13841g.iterator();
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

    public void r(int i) {
        int i2 = this.f13842h;
        if (i2 > 0) {
            SkinManager.setBackgroundColor(this, i2, i);
        }
        Iterator<h> it = this.f13840f.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<n> it2 = this.f13841g.iterator();
        while (it2.hasNext()) {
            n next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
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

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.f13842h = i;
    }

    public void setDeskLauncherEnabled(boolean z) {
        Iterator<h> it = this.f13840f.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (next != null && (next instanceof View)) {
                ((View) next).setEnabled(z);
            }
        }
    }

    public boolean t(boolean z, int i) {
        Iterator<h> it = this.f13840f.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (next instanceof View) {
                View view = (View) next;
                if (next.getToolId() == i) {
                    view.setEnabled(z);
                    return true;
                }
            }
        }
        return false;
    }
}
