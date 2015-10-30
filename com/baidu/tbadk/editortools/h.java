package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class h extends FrameLayout {
    private int aoC;
    private LinkedList<p> aoK;
    private LinkedList<w> aoL;
    private w aoM;
    private boolean aoN;
    private boolean aoO;
    private Runnable aoP;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, j jVar) {
        super(context);
        this.aoC = i.c.editor_background;
        this.aoM = null;
        this.aoN = true;
        this.aoO = false;
        this.aoP = new i(this);
        this.aoK = new LinkedList<>();
        this.aoL = new LinkedList<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(p pVar) {
        this.aoK.add(pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(w wVar) {
        this.aoL.add(wVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Av() {
        Iterator<w> it = this.aoL.iterator();
        while (it.hasNext()) {
            w next = it.next();
            if (next.getToolId() == 2) {
                b(next);
            }
            if (next instanceof View) {
                View view = (View) next;
                view.setVisibility(8);
                addView(view, -1, getContext().getResources().getDimensionPixelSize(i.d.editor_tool_desk_height));
            }
            next.init();
        }
        invalidate();
    }

    private void b(w wVar) {
        if (wVar instanceof q) {
            ((q) wVar).i(this.aoK);
            wVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aoM = null;
        this.aoK.clear();
        this.aoL.clear();
    }

    protected void ow() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.aoM != null) {
            this.aoM.hide();
        }
        this.aoM = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dQ(int i) {
        if (dT(i)) {
            if (Ay()) {
                this.aoN = true;
            } else {
                this.aoN = false;
            }
            boolean z = this.aoO;
            Iterator<w> it = this.aoL.iterator();
            while (it.hasNext()) {
                w next = it.next();
                if (!z && TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.aoO = true;
                }
                if (next.getToolId() == i) {
                    this.aoM = next;
                    if (this.aoN) {
                        next.ow();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.aoN && (getContext() instanceof Activity)) {
                com.baidu.adp.lib.util.k.c(getContext(), ((Activity) getContext()).getCurrentFocus());
                com.baidu.adp.lib.g.h.hg().postDelayed(this.aoP, 250L);
            }
            ow();
        }
    }

    private boolean dT(int i) {
        Iterator<w> it = this.aoL.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public p dS(int i) {
        Iterator<p> it = this.aoK.iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.aoC > 0) {
            an.d(this, this.aoC, i);
        }
        Iterator<p> it = this.aoK.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<w> it2 = this.aoL.iterator();
        while (it2.hasNext()) {
            w next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean Ax() {
        return getVisibility() == 0 && Ay();
    }

    private boolean Ay() {
        Iterator<w> it = this.aoL.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aoC = i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            be(true);
        }
        super.requestDisallowInterceptTouchEvent(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        be(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    private void be(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
