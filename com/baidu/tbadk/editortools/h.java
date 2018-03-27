package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class h extends FrameLayout {
    private int bse;
    private LinkedList<l> bsn;
    private LinkedList<s> bso;
    private s bsp;
    private boolean bsq;
    private boolean bsr;
    private i bss;
    private Runnable bst;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, i iVar) {
        super(context);
        this.bse = d.C0141d.cp_bg_line_d;
        this.bsp = null;
        this.bsq = true;
        this.bsr = false;
        this.bst = new Runnable() { // from class: com.baidu.tbadk.editortools.h.1
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.bsp != null) {
                    h.this.bsp.th();
                }
            }
        };
        this.bsn = new LinkedList<>();
        this.bso = new LinkedList<>();
        this.bss = iVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.bsn.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar) {
        this.bso.add(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ld() {
        Iterator<s> it = this.bso.iterator();
        while (it.hasNext()) {
            s next = it.next();
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

    private void b(s sVar) {
        if (sVar instanceof m) {
            ((m) sVar).j(this.bsn);
            sVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.bsp = null;
        this.bsn.clear();
        this.bso.clear();
    }

    protected void th() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.bsp != null) {
            this.bsp.hide();
        }
        this.bsp = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hE(int i) {
        if (hH(i)) {
            if (Lg()) {
                this.bsq = true;
            } else {
                this.bsq = false;
            }
            boolean z = this.bsr;
            Iterator<s> it = this.bso.iterator();
            while (it.hasNext()) {
                s next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.bsr = true;
                }
                if (next.getToolId() == i) {
                    this.bsp = next;
                    if (this.bsq) {
                        next.th();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.bsq && (getContext() instanceof Activity)) {
                if (this.bss != null) {
                    this.bss.Lk();
                } else {
                    com.baidu.adp.lib.util.l.a(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.e.ns().postDelayed(this.bst, 250L);
            }
            th();
        }
    }

    private boolean hH(int i) {
        Iterator<s> it = this.bso.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public l hG(int i) {
        Iterator<l> it = this.bsn.iterator();
        while (it.hasNext()) {
            l next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.bse > 0) {
            aj.g(this, this.bse, i);
        }
        Iterator<l> it = this.bsn.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<s> it2 = this.bso.iterator();
        while (it2.hasNext()) {
            s next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean Lf() {
        return getVisibility() == 0 && Lg();
    }

    private boolean Lg() {
        Iterator<s> it = this.bso.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.bse = i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            bB(true);
        }
        super.requestDisallowInterceptTouchEvent(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        bB(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    private void bB(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
