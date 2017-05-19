package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class h extends FrameLayout {
    private int ayO;
    private LinkedList<p> ayY;
    private LinkedList<y> ayZ;
    private y aza;
    private boolean azb;
    private boolean azc;
    private j azd;
    private Runnable aze;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, j jVar) {
        super(context);
        this.ayO = w.e.common_color_10255;
        this.aza = null;
        this.azb = true;
        this.azc = false;
        this.aze = new i(this);
        this.ayY = new LinkedList<>();
        this.ayZ = new LinkedList<>();
        this.azd = jVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(p pVar) {
        this.ayY.add(pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(y yVar) {
        this.ayZ.add(yVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ct() {
        Iterator<y> it = this.ayZ.iterator();
        while (it.hasNext()) {
            y next = it.next();
            if (next.getToolId() == 2) {
                b(next);
            }
            if (next instanceof View) {
                View view = (View) next;
                view.setVisibility(8);
                addView(view, -1, getContext().getResources().getDimensionPixelSize(w.f.ds460));
            }
            next.init();
        }
        invalidate();
    }

    private void b(y yVar) {
        if (yVar instanceof q) {
            ((q) yVar).h(this.ayY);
            yVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aza = null;
        this.ayY.clear();
        this.ayZ.clear();
    }

    protected void lW() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.aza != null) {
            this.aza.hide();
        }
        this.aza = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void et(int i) {
        if (ew(i)) {
            if (Cw()) {
                this.azb = true;
            } else {
                this.azb = false;
            }
            boolean z = this.azc;
            Iterator<y> it = this.ayZ.iterator();
            while (it.hasNext()) {
                y next = it.next();
                if (!z && TbadkCoreApplication.m9getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.m9getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.azc = true;
                }
                if (next.getToolId() == i) {
                    this.aza = next;
                    if (this.azb) {
                        next.lW();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.azb && (getContext() instanceof Activity)) {
                if (this.azd != null) {
                    this.azd.Cy();
                } else {
                    com.baidu.adp.lib.util.k.b(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.h.fS().postDelayed(this.aze, 250L);
            }
            lW();
        }
    }

    private boolean ew(int i) {
        Iterator<y> it = this.ayZ.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public p ev(int i) {
        Iterator<p> it = this.ayY.iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.ayO > 0) {
            aq.e(this, this.ayO, i);
        }
        Iterator<p> it = this.ayY.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<y> it2 = this.ayZ.iterator();
        while (it2.hasNext()) {
            y next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean Cv() {
        return getVisibility() == 0 && Cw();
    }

    private boolean Cw() {
        Iterator<y> it = this.ayZ.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.ayO = i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            aR(true);
        }
        super.requestDisallowInterceptTouchEvent(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        aR(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    private void aR(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
