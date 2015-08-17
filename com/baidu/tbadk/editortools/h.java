package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class h extends FrameLayout {
    private w aoA;
    private boolean aoB;
    private boolean aoC;
    private Runnable aoD;
    private int aoq;
    private LinkedList<p> aoy;
    private LinkedList<w> aoz;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, j jVar) {
        super(context);
        this.aoq = i.c.editor_background;
        this.aoA = null;
        this.aoB = true;
        this.aoC = false;
        this.aoD = new i(this);
        this.aoy = new LinkedList<>();
        this.aoz = new LinkedList<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(p pVar) {
        this.aoy.add(pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(w wVar) {
        this.aoz.add(wVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Az() {
        Iterator<w> it = this.aoz.iterator();
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
            ((q) wVar).i(this.aoy);
            wVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aoA = null;
        this.aoy.clear();
        this.aoz.clear();
    }

    protected void oy() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.aoA != null) {
            this.aoA.hide();
        }
        this.aoA = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dH(int i) {
        if (dK(i)) {
            if (AC()) {
                this.aoB = true;
            } else {
                this.aoB = false;
            }
            boolean z = this.aoC;
            Iterator<w> it = this.aoz.iterator();
            while (it.hasNext()) {
                w next = it.next();
                if (!z && TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.aoC = true;
                }
                if (next.getToolId() == i) {
                    this.aoA = next;
                    if (this.aoB) {
                        next.oy();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.aoB && (getContext() instanceof Activity)) {
                com.baidu.adp.lib.util.k.c(getContext(), ((Activity) getContext()).getCurrentFocus());
                com.baidu.adp.lib.g.h.hi().postDelayed(this.aoD, 250L);
            }
            oy();
        }
    }

    private boolean dK(int i) {
        Iterator<w> it = this.aoz.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public p dJ(int i) {
        Iterator<p> it = this.aoy.iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.aoq > 0) {
            al.d(this, this.aoq, i);
        }
        Iterator<p> it = this.aoy.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<w> it2 = this.aoz.iterator();
        while (it2.hasNext()) {
            w next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean AB() {
        return getVisibility() == 0 && AC();
    }

    private boolean AC() {
        Iterator<w> it = this.aoz.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aoq = i;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }
}
