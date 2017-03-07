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
    private LinkedList<p> ayI;
    private LinkedList<y> ayJ;
    private y ayK;
    private boolean ayL;
    private boolean ayM;
    private j ayN;
    private Runnable ayO;
    private int ayz;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, j jVar) {
        super(context);
        this.ayz = w.e.common_color_10255;
        this.ayK = null;
        this.ayL = true;
        this.ayM = false;
        this.ayO = new i(this);
        this.ayI = new LinkedList<>();
        this.ayJ = new LinkedList<>();
        this.ayN = jVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(p pVar) {
        this.ayI.add(pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(y yVar) {
        this.ayJ.add(yVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CQ() {
        Iterator<y> it = this.ayJ.iterator();
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
            ((q) yVar).h(this.ayI);
            yVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.ayK = null;
        this.ayI.clear();
        this.ayJ.clear();
    }

    protected void ml() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.ayK != null) {
            this.ayK.hide();
        }
        this.ayK = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eu(int i) {
        if (ex(i)) {
            if (CT()) {
                this.ayL = true;
            } else {
                this.ayL = false;
            }
            boolean z = this.ayM;
            Iterator<y> it = this.ayJ.iterator();
            while (it.hasNext()) {
                y next = it.next();
                if (!z && TbadkCoreApplication.m9getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.m9getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.ayM = true;
                }
                if (next.getToolId() == i) {
                    this.ayK = next;
                    if (this.ayL) {
                        next.ml();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.ayL && (getContext() instanceof Activity)) {
                if (this.ayN != null) {
                    this.ayN.CV();
                } else {
                    com.baidu.adp.lib.util.k.b(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.h.fM().postDelayed(this.ayO, 250L);
            }
            ml();
        }
    }

    private boolean ex(int i) {
        Iterator<y> it = this.ayJ.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public p ew(int i) {
        Iterator<p> it = this.ayI.iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.ayz > 0) {
            aq.e(this, this.ayz, i);
        }
        Iterator<p> it = this.ayI.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<y> it2 = this.ayJ.iterator();
        while (it2.hasNext()) {
            y next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean CS() {
        return getVisibility() == 0 && CT();
    }

    private boolean CT() {
        Iterator<y> it = this.ayJ.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.ayz = i;
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
