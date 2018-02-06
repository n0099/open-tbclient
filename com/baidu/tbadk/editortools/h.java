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
    private boolean bsA;
    private boolean bsB;
    private i bsC;
    private Runnable bsD;
    private int bso;
    private LinkedList<l> bsx;
    private LinkedList<s> bsy;
    private s bsz;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, i iVar) {
        super(context);
        this.bso = d.C0140d.cp_bg_line_d;
        this.bsz = null;
        this.bsA = true;
        this.bsB = false;
        this.bsD = new Runnable() { // from class: com.baidu.tbadk.editortools.h.1
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.bsz != null) {
                    h.this.bsz.th();
                }
            }
        };
        this.bsx = new LinkedList<>();
        this.bsy = new LinkedList<>();
        this.bsC = iVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.bsx.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar) {
        this.bsy.add(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ld() {
        Iterator<s> it = this.bsy.iterator();
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
            ((m) sVar).j(this.bsx);
            sVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.bsz = null;
        this.bsx.clear();
        this.bsy.clear();
    }

    protected void th() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.bsz != null) {
            this.bsz.hide();
        }
        this.bsz = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hE(int i) {
        if (hH(i)) {
            if (Lg()) {
                this.bsA = true;
            } else {
                this.bsA = false;
            }
            boolean z = this.bsB;
            Iterator<s> it = this.bsy.iterator();
            while (it.hasNext()) {
                s next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.bsB = true;
                }
                if (next.getToolId() == i) {
                    this.bsz = next;
                    if (this.bsA) {
                        next.th();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.bsA && (getContext() instanceof Activity)) {
                if (this.bsC != null) {
                    this.bsC.Lk();
                } else {
                    com.baidu.adp.lib.util.l.a(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.e.ns().postDelayed(this.bsD, 250L);
            }
            th();
        }
    }

    private boolean hH(int i) {
        Iterator<s> it = this.bsy.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public l hG(int i) {
        Iterator<l> it = this.bsx.iterator();
        while (it.hasNext()) {
            l next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.bso > 0) {
            aj.g(this, this.bso, i);
        }
        Iterator<l> it = this.bsx.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<s> it2 = this.bsy.iterator();
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
        Iterator<s> it = this.bsy.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.bso = i;
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
