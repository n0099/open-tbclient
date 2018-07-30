package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class EditorDesk extends FrameLayout {
    private int aLX;
    private LinkedList<g> aMg;
    private LinkedList<l> aMh;
    private l aMi;
    private boolean aMj;
    private boolean aMk;
    private EditorTools aMl;
    private Runnable aMm;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorDesk(Context context, EditorTools editorTools) {
        super(context);
        this.aLX = d.C0140d.cp_bg_line_d;
        this.aMi = null;
        this.aMj = true;
        this.aMk = false;
        this.aMm = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorDesk.1
            @Override // java.lang.Runnable
            public void run() {
                if (EditorDesk.this.aMi != null) {
                    EditorDesk.this.aMi.oF();
                }
            }
        };
        this.aMg = new LinkedList<>();
        this.aMh = new LinkedList<>();
        this.aMl = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.aMg.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.aMh.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Hu() {
        Iterator<l> it = this.aMh.iterator();
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
            ((MoreDeskView) lVar).j(this.aMg);
            lVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aMi = null;
        this.aMg.clear();
        this.aMh.clear();
    }

    protected void oF() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.aMi != null) {
            this.aMi.hide();
        }
        this.aMi = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eJ(int i) {
        if (eN(i)) {
            if (Hx()) {
                this.aMj = true;
            } else {
                this.aMj = false;
            }
            boolean z = this.aMk;
            Iterator<l> it = this.aMh.iterator();
            while (it.hasNext()) {
                l next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.aMk = true;
                }
                if (next.getToolId() == i) {
                    this.aMi = next;
                    if (this.aMj) {
                        next.oF();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.aMj && (getContext() instanceof Activity)) {
                if (this.aMl != null) {
                    this.aMl.HB();
                } else {
                    com.baidu.adp.lib.util.l.a(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.e.in().postDelayed(this.aMm, 250L);
            }
            oF();
        }
    }

    private boolean eN(int i) {
        Iterator<l> it = this.aMh.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public g eL(int i) {
        Iterator<g> it = this.aMg.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.aLX > 0) {
            am.e(this, this.aLX, i);
        }
        Iterator<g> it = this.aMg.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<l> it2 = this.aMh.iterator();
        while (it2.hasNext()) {
            l next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean Hw() {
        return getVisibility() == 0 && Hx();
    }

    private boolean Hx() {
        Iterator<l> it = this.aMh.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aLX = i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            aX(true);
        }
        super.requestDisallowInterceptTouchEvent(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        aX(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    private void aX(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
