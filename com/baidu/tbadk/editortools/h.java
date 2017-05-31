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
    private int ayA;
    private LinkedList<p> ayK;
    private LinkedList<y> ayL;
    private y ayM;
    private boolean ayN;
    private boolean ayO;
    private j ayP;
    private Runnable ayQ;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, j jVar) {
        super(context);
        this.ayA = w.e.common_color_10255;
        this.ayM = null;
        this.ayN = true;
        this.ayO = false;
        this.ayQ = new i(this);
        this.ayK = new LinkedList<>();
        this.ayL = new LinkedList<>();
        this.ayP = jVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(p pVar) {
        this.ayK.add(pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(y yVar) {
        this.ayL.add(yVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Cn() {
        Iterator<y> it = this.ayL.iterator();
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
            ((q) yVar).h(this.ayK);
            yVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.ayM = null;
        this.ayK.clear();
        this.ayL.clear();
    }

    protected void lO() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.ayM != null) {
            this.ayM.hide();
        }
        this.ayM = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eu(int i) {
        if (ex(i)) {
            if (Cq()) {
                this.ayN = true;
            } else {
                this.ayN = false;
            }
            boolean z = this.ayO;
            Iterator<y> it = this.ayL.iterator();
            while (it.hasNext()) {
                y next = it.next();
                if (!z && TbadkCoreApplication.m9getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.m9getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.ayO = true;
                }
                if (next.getToolId() == i) {
                    this.ayM = next;
                    if (this.ayN) {
                        next.lO();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.ayN && (getContext() instanceof Activity)) {
                if (this.ayP != null) {
                    this.ayP.Cs();
                } else {
                    com.baidu.adp.lib.util.k.b(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.h.fS().postDelayed(this.ayQ, 250L);
            }
            lO();
        }
    }

    private boolean ex(int i) {
        Iterator<y> it = this.ayL.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public p ew(int i) {
        Iterator<p> it = this.ayK.iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.ayA > 0) {
            aq.e(this, this.ayA, i);
        }
        Iterator<p> it = this.ayK.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<y> it2 = this.ayL.iterator();
        while (it2.hasNext()) {
            y next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean Cp() {
        return getVisibility() == 0 && Cq();
    }

    private boolean Cq() {
        Iterator<y> it = this.ayL.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.ayA = i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            aP(true);
        }
        super.requestDisallowInterceptTouchEvent(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        aP(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    private void aP(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
