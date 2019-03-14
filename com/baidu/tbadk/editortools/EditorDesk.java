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
    private EditorTools ciA;
    private Runnable ciB;
    private int cim;
    private LinkedList<g> civ;
    private LinkedList<l> ciw;
    private l cix;
    private boolean ciy;
    private boolean ciz;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorDesk(Context context, EditorTools editorTools) {
        super(context);
        this.cim = d.C0277d.cp_bg_line_d;
        this.cix = null;
        this.ciy = true;
        this.ciz = false;
        this.ciB = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorDesk.1
            @Override // java.lang.Runnable
            public void run() {
                if (EditorDesk.this.cix != null) {
                    EditorDesk.this.cix.qT();
                }
            }
        };
        this.civ = new LinkedList<>();
        this.ciw = new LinkedList<>();
        this.ciA = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.civ.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.ciw.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void alT() {
        Iterator<l> it = this.ciw.iterator();
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
            ((MoreDeskView) lVar).k(this.civ);
            lVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.cix = null;
        this.civ.clear();
        this.ciw.clear();
    }

    protected void qT() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.cix != null) {
            this.cix.hide();
        }
        this.cix = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void jr(int i) {
        if (jv(i)) {
            if (alW()) {
                this.ciy = true;
            } else {
                this.ciy = false;
            }
            boolean z = this.ciz;
            Iterator<l> it = this.ciw.iterator();
            while (it.hasNext()) {
                l next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.ciz = true;
                }
                if (next.getToolId() == i) {
                    this.cix = next;
                    if (this.ciy) {
                        next.qT();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.ciy && (getContext() instanceof Activity)) {
                if (this.ciA != null) {
                    this.ciA.ama();
                } else {
                    com.baidu.adp.lib.util.l.b(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.e.jH().postDelayed(this.ciB, 250L);
            }
            qT();
        }
    }

    private boolean jv(int i) {
        Iterator<l> it = this.ciw.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public g jt(int i) {
        Iterator<g> it = this.civ.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.cim > 0) {
            al.f(this, this.cim, i);
        }
        Iterator<g> it = this.civ.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<l> it2 = this.ciw.iterator();
        while (it2.hasNext()) {
            l next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean alV() {
        return getVisibility() == 0 && alW();
    }

    private boolean alW() {
        Iterator<l> it = this.ciw.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.cim = i;
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
