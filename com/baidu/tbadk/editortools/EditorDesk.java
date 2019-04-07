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
    private boolean ciA;
    private boolean ciB;
    private EditorTools ciC;
    private Runnable ciD;
    private int cio;
    private LinkedList<g> cix;
    private LinkedList<l> ciy;
    private l ciz;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorDesk(Context context, EditorTools editorTools) {
        super(context);
        this.cio = d.C0277d.cp_bg_line_d;
        this.ciz = null;
        this.ciA = true;
        this.ciB = false;
        this.ciD = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorDesk.1
            @Override // java.lang.Runnable
            public void run() {
                if (EditorDesk.this.ciz != null) {
                    EditorDesk.this.ciz.qT();
                }
            }
        };
        this.cix = new LinkedList<>();
        this.ciy = new LinkedList<>();
        this.ciC = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.cix.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.ciy.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void alQ() {
        Iterator<l> it = this.ciy.iterator();
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
            ((MoreDeskView) lVar).k(this.cix);
            lVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.ciz = null;
        this.cix.clear();
        this.ciy.clear();
    }

    protected void qT() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.ciz != null) {
            this.ciz.hide();
        }
        this.ciz = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void jq(int i) {
        if (ju(i)) {
            if (alT()) {
                this.ciA = true;
            } else {
                this.ciA = false;
            }
            boolean z = this.ciB;
            Iterator<l> it = this.ciy.iterator();
            while (it.hasNext()) {
                l next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.ciB = true;
                }
                if (next.getToolId() == i) {
                    this.ciz = next;
                    if (this.ciA) {
                        next.qT();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.ciA && (getContext() instanceof Activity)) {
                if (this.ciC != null) {
                    this.ciC.alX();
                } else {
                    com.baidu.adp.lib.util.l.b(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.e.jH().postDelayed(this.ciD, 250L);
            }
            qT();
        }
    }

    private boolean ju(int i) {
        Iterator<l> it = this.ciy.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public g js(int i) {
        Iterator<g> it = this.cix.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.cio > 0) {
            al.f(this, this.cio, i);
        }
        Iterator<g> it = this.cix.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<l> it2 = this.ciy.iterator();
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
        Iterator<l> it = this.ciy.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.cio = i;
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
