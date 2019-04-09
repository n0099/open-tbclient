package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class EditorDesk extends FrameLayout {
    private l ciA;
    private boolean ciB;
    private boolean ciC;
    private EditorTools ciD;
    private Runnable ciE;
    private int cip;
    private LinkedList<g> ciy;
    private LinkedList<l> ciz;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorDesk(Context context, EditorTools editorTools) {
        super(context);
        this.cip = d.C0277d.cp_bg_line_d;
        this.ciA = null;
        this.ciB = true;
        this.ciC = false;
        this.ciE = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorDesk.1
            @Override // java.lang.Runnable
            public void run() {
                if (EditorDesk.this.ciA != null) {
                    EditorDesk.this.ciA.qT();
                }
            }
        };
        this.ciy = new LinkedList<>();
        this.ciz = new LinkedList<>();
        this.ciD = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.ciy.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.ciz.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void alQ() {
        Iterator<l> it = this.ciz.iterator();
        while (it.hasNext()) {
            l next = it.next();
            if (next.getToolId() == 2) {
                b(next);
            }
            if (next instanceof View) {
                View view = (View) next;
                view.setVisibility(8);
                addView(view, -1, getContext().getResources().getDimensionPixelSize(d.e.ds460));
            }
            next.init();
        }
        invalidate();
    }

    private void b(l lVar) {
        if (lVar instanceof MoreDeskView) {
            ((MoreDeskView) lVar).k(this.ciy);
            lVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.ciA = null;
        this.ciy.clear();
        this.ciz.clear();
    }

    protected void qT() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.ciA != null) {
            this.ciA.hide();
        }
        this.ciA = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void jq(int i) {
        if (ju(i)) {
            if (alT()) {
                this.ciB = true;
            } else {
                this.ciB = false;
            }
            boolean z = this.ciC;
            Iterator<l> it = this.ciz.iterator();
            while (it.hasNext()) {
                l next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.ciC = true;
                }
                if (next.getToolId() == i) {
                    this.ciA = next;
                    if (this.ciB) {
                        next.qT();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.ciB && (getContext() instanceof Activity)) {
                if (this.ciD != null) {
                    this.ciD.alX();
                } else {
                    com.baidu.adp.lib.util.l.b(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.e.jH().postDelayed(this.ciE, 250L);
            }
            qT();
        }
    }

    private boolean ju(int i) {
        Iterator<l> it = this.ciz.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public g js(int i) {
        Iterator<g> it = this.ciy.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.cip > 0) {
            al.f(this, this.cip, i);
        }
        Iterator<g> it = this.ciy.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<l> it2 = this.ciz.iterator();
        while (it2.hasNext()) {
            l next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean alS() {
        return getVisibility() == 0 && alT();
    }

    private boolean alT() {
        Iterator<l> it = this.ciz.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.cip = i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            dW(true);
        }
        super.requestDisallowInterceptTouchEvent(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        dW(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    private void dW(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
