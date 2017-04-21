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
    private int ayR;
    private LinkedList<p> aza;
    private LinkedList<y> azb;
    private y azc;
    private boolean azd;
    private boolean aze;
    private j azf;
    private Runnable azg;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, j jVar) {
        super(context);
        this.ayR = w.e.common_color_10255;
        this.azc = null;
        this.azd = true;
        this.aze = false;
        this.azg = new i(this);
        this.aza = new LinkedList<>();
        this.azb = new LinkedList<>();
        this.azf = jVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(p pVar) {
        this.aza.add(pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(y yVar) {
        this.azb.add(yVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Do() {
        Iterator<y> it = this.azb.iterator();
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
            ((q) yVar).h(this.aza);
            yVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.azc = null;
        this.aza.clear();
        this.azb.clear();
    }

    protected void mp() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.azc != null) {
            this.azc.hide();
        }
        this.azc = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ex(int i) {
        if (eA(i)) {
            if (Dr()) {
                this.azd = true;
            } else {
                this.azd = false;
            }
            boolean z = this.aze;
            Iterator<y> it = this.azb.iterator();
            while (it.hasNext()) {
                y next = it.next();
                if (!z && TbadkCoreApplication.m9getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.m9getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.aze = true;
                }
                if (next.getToolId() == i) {
                    this.azc = next;
                    if (this.azd) {
                        next.mp();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.azd && (getContext() instanceof Activity)) {
                if (this.azf != null) {
                    this.azf.Dt();
                } else {
                    com.baidu.adp.lib.util.k.b(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.h.fS().postDelayed(this.azg, 250L);
            }
            mp();
        }
    }

    private boolean eA(int i) {
        Iterator<y> it = this.azb.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public p ez(int i) {
        Iterator<p> it = this.aza.iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.ayR > 0) {
            aq.e(this, this.ayR, i);
        }
        Iterator<p> it = this.aza.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<y> it2 = this.azb.iterator();
        while (it2.hasNext()) {
            y next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean Dq() {
        return getVisibility() == 0 && Dr();
    }

    private boolean Dr() {
        Iterator<y> it = this.azb.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.ayR = i;
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
