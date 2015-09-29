package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class h extends FrameLayout {
    private int aoB;
    private LinkedList<p> aoJ;
    private LinkedList<w> aoK;
    private w aoL;
    private boolean aoM;
    private boolean aoN;
    private Runnable aoO;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, j jVar) {
        super(context);
        this.aoB = i.c.editor_background;
        this.aoL = null;
        this.aoM = true;
        this.aoN = false;
        this.aoO = new i(this);
        this.aoJ = new LinkedList<>();
        this.aoK = new LinkedList<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(p pVar) {
        this.aoJ.add(pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(w wVar) {
        this.aoK.add(wVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ay() {
        Iterator<w> it = this.aoK.iterator();
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
            ((q) wVar).i(this.aoJ);
            wVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aoL = null;
        this.aoJ.clear();
        this.aoK.clear();
    }

    protected void ow() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.aoL != null) {
            this.aoL.hide();
        }
        this.aoL = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dQ(int i) {
        if (dT(i)) {
            if (AB()) {
                this.aoM = true;
            } else {
                this.aoM = false;
            }
            boolean z = this.aoN;
            Iterator<w> it = this.aoK.iterator();
            while (it.hasNext()) {
                w next = it.next();
                if (!z && TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.aoN = true;
                }
                if (next.getToolId() == i) {
                    this.aoL = next;
                    if (this.aoM) {
                        next.ow();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.aoM && (getContext() instanceof Activity)) {
                com.baidu.adp.lib.util.k.c(getContext(), ((Activity) getContext()).getCurrentFocus());
                com.baidu.adp.lib.g.h.hg().postDelayed(this.aoO, 250L);
            }
            ow();
        }
    }

    private boolean dT(int i) {
        Iterator<w> it = this.aoK.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public p dS(int i) {
        Iterator<p> it = this.aoJ.iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.aoB > 0) {
            am.d(this, this.aoB, i);
        }
        Iterator<p> it = this.aoJ.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<w> it2 = this.aoK.iterator();
        while (it2.hasNext()) {
            w next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean AA() {
        return getVisibility() == 0 && AB();
    }

    private boolean AB() {
        Iterator<w> it = this.aoK.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aoB = i;
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
