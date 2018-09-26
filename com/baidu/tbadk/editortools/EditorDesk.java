package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class EditorDesk extends FrameLayout {
    private EditorTools aPA;
    private Runnable aPB;
    private int aPm;
    private LinkedList<g> aPv;
    private LinkedList<l> aPw;
    private l aPx;
    private boolean aPy;
    private boolean aPz;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorDesk(Context context, EditorTools editorTools) {
        super(context);
        this.aPm = e.d.cp_bg_line_d;
        this.aPx = null;
        this.aPy = true;
        this.aPz = false;
        this.aPB = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorDesk.1
            @Override // java.lang.Runnable
            public void run() {
                if (EditorDesk.this.aPx != null) {
                    EditorDesk.this.aPx.pI();
                }
            }
        };
        this.aPv = new LinkedList<>();
        this.aPw = new LinkedList<>();
        this.aPA = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.aPv.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.aPw.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void IK() {
        Iterator<l> it = this.aPw.iterator();
        while (it.hasNext()) {
            l next = it.next();
            if (next.getToolId() == 2) {
                b(next);
            }
            if (next instanceof View) {
                View view = (View) next;
                view.setVisibility(8);
                addView(view, -1, getContext().getResources().getDimensionPixelSize(e.C0141e.ds460));
            }
            next.init();
        }
        invalidate();
    }

    private void b(l lVar) {
        if (lVar instanceof MoreDeskView) {
            ((MoreDeskView) lVar).j(this.aPv);
            lVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aPx = null;
        this.aPv.clear();
        this.aPw.clear();
    }

    protected void pI() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.aPx != null) {
            this.aPx.hide();
        }
        this.aPx = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eU(int i) {
        if (eY(i)) {
            if (IN()) {
                this.aPy = true;
            } else {
                this.aPy = false;
            }
            boolean z = this.aPz;
            Iterator<l> it = this.aPw.iterator();
            while (it.hasNext()) {
                l next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.aPz = true;
                }
                if (next.getToolId() == i) {
                    this.aPx = next;
                    if (this.aPy) {
                        next.pI();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.aPy && (getContext() instanceof Activity)) {
                if (this.aPA != null) {
                    this.aPA.IR();
                } else {
                    com.baidu.adp.lib.util.l.a(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.e.jt().postDelayed(this.aPB, 250L);
            }
            pI();
        }
    }

    private boolean eY(int i) {
        Iterator<l> it = this.aPw.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public g eW(int i) {
        Iterator<g> it = this.aPv.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.aPm > 0) {
            al.e(this, this.aPm, i);
        }
        Iterator<g> it = this.aPv.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<l> it2 = this.aPw.iterator();
        while (it2.hasNext()) {
            l next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean IM() {
        return getVisibility() == 0 && IN();
    }

    private boolean IN() {
        Iterator<l> it = this.aPw.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aPm = i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            bk(true);
        }
        super.requestDisallowInterceptTouchEvent(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        bk(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    private void bk(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
