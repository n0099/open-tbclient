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
    private int aoI;
    private LinkedList<p> aoP;
    private LinkedList<x> aoQ;
    private x aoR;
    private boolean aoS;
    private boolean aoT;
    private Runnable aoU;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, j jVar) {
        super(context);
        this.aoI = i.c.editor_background;
        this.aoR = null;
        this.aoS = true;
        this.aoT = false;
        this.aoU = new i(this);
        this.aoP = new LinkedList<>();
        this.aoQ = new LinkedList<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(p pVar) {
        this.aoP.add(pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(x xVar) {
        this.aoQ.add(xVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void AA() {
        Iterator<x> it = this.aoQ.iterator();
        while (it.hasNext()) {
            x next = it.next();
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

    private void b(x xVar) {
        if (xVar instanceof q) {
            ((q) xVar).i(this.aoP);
            xVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aoR = null;
        this.aoP.clear();
        this.aoQ.clear();
    }

    protected void ox() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.aoR != null) {
            this.aoR.hide();
        }
        this.aoR = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dQ(int i) {
        if (dT(i)) {
            if (AD()) {
                this.aoS = true;
            } else {
                this.aoS = false;
            }
            boolean z = this.aoT;
            Iterator<x> it = this.aoQ.iterator();
            while (it.hasNext()) {
                x next = it.next();
                if (!z && TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.aoT = true;
                }
                if (next.getToolId() == i) {
                    this.aoR = next;
                    if (this.aoS) {
                        next.ox();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.aoS && (getContext() instanceof Activity)) {
                com.baidu.adp.lib.util.k.c(getContext(), ((Activity) getContext()).getCurrentFocus());
                com.baidu.adp.lib.g.h.hh().postDelayed(this.aoU, 250L);
            }
            ox();
        }
    }

    private boolean dT(int i) {
        Iterator<x> it = this.aoQ.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public p dS(int i) {
        Iterator<p> it = this.aoP.iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.aoI > 0) {
            an.d(this, this.aoI, i);
        }
        Iterator<p> it = this.aoP.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<x> it2 = this.aoQ.iterator();
        while (it2.hasNext()) {
            x next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean AC() {
        return getVisibility() == 0 && AD();
    }

    private boolean AD() {
        Iterator<x> it = this.aoQ.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aoI = i;
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
