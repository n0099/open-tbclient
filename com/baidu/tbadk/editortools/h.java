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
    private int bpJ;
    private LinkedList<l> bpS;
    private LinkedList<s> bpT;
    private s bpU;
    private boolean bpV;
    private boolean bpW;
    private i bpX;
    private Runnable bpY;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, i iVar) {
        super(context);
        this.bpJ = d.C0108d.cp_bg_line_d;
        this.bpU = null;
        this.bpV = true;
        this.bpW = false;
        this.bpY = new Runnable() { // from class: com.baidu.tbadk.editortools.h.1
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.bpU != null) {
                    h.this.bpU.th();
                }
            }
        };
        this.bpS = new LinkedList<>();
        this.bpT = new LinkedList<>();
        this.bpX = iVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.bpS.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar) {
        this.bpT.add(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void KG() {
        Iterator<s> it = this.bpT.iterator();
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
            ((m) sVar).j(this.bpS);
            sVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.bpU = null;
        this.bpS.clear();
        this.bpT.clear();
    }

    protected void th() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.bpU != null) {
            this.bpU.hide();
        }
        this.bpU = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hJ(int i) {
        if (hM(i)) {
            if (KJ()) {
                this.bpV = true;
            } else {
                this.bpV = false;
            }
            boolean z = this.bpW;
            Iterator<s> it = this.bpT.iterator();
            while (it.hasNext()) {
                s next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.bpW = true;
                }
                if (next.getToolId() == i) {
                    this.bpU = next;
                    if (this.bpV) {
                        next.th();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.bpV && (getContext() instanceof Activity)) {
                if (this.bpX != null) {
                    this.bpX.KN();
                } else {
                    com.baidu.adp.lib.util.l.a(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.e.nr().postDelayed(this.bpY, 250L);
            }
            th();
        }
    }

    private boolean hM(int i) {
        Iterator<s> it = this.bpT.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public l hL(int i) {
        Iterator<l> it = this.bpS.iterator();
        while (it.hasNext()) {
            l next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.bpJ > 0) {
            aj.g(this, this.bpJ, i);
        }
        Iterator<l> it = this.bpS.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<s> it2 = this.bpT.iterator();
        while (it2.hasNext()) {
            s next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean KI() {
        return getVisibility() == 0 && KJ();
    }

    private boolean KJ() {
        Iterator<s> it = this.bpT.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.bpJ = i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            bv(true);
        }
        super.requestDisallowInterceptTouchEvent(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        bv(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    private void bv(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
