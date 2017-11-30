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
    private int aBG;
    private LinkedList<l> aBP;
    private LinkedList<s> aBQ;
    private s aBR;
    private boolean aBS;
    private boolean aBT;
    private i aBU;
    private Runnable aBV;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, i iVar) {
        super(context);
        this.aBG = d.C0082d.cp_bg_line_d;
        this.aBR = null;
        this.aBS = true;
        this.aBT = false;
        this.aBV = new Runnable() { // from class: com.baidu.tbadk.editortools.h.1
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.aBR != null) {
                    h.this.aBR.lE();
                }
            }
        };
        this.aBP = new LinkedList<>();
        this.aBQ = new LinkedList<>();
        this.aBU = iVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.aBP.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar) {
        this.aBQ.add(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void De() {
        Iterator<s> it = this.aBQ.iterator();
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
            ((m) sVar).i(this.aBP);
            sVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aBR = null;
        this.aBP.clear();
        this.aBQ.clear();
    }

    protected void lE() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.aBR != null) {
            this.aBR.hide();
        }
        this.aBR = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eL(int i) {
        if (eO(i)) {
            if (Dh()) {
                this.aBS = true;
            } else {
                this.aBS = false;
            }
            boolean z = this.aBT;
            Iterator<s> it = this.aBQ.iterator();
            while (it.hasNext()) {
                s next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.aBT = true;
                }
                if (next.getToolId() == i) {
                    this.aBR = next;
                    if (this.aBS) {
                        next.lE();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.aBS && (getContext() instanceof Activity)) {
                if (this.aBU != null) {
                    this.aBU.Dl();
                } else {
                    com.baidu.adp.lib.util.l.a(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.e.fP().postDelayed(this.aBV, 250L);
            }
            lE();
        }
    }

    private boolean eO(int i) {
        Iterator<s> it = this.aBQ.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public l eN(int i) {
        Iterator<l> it = this.aBP.iterator();
        while (it.hasNext()) {
            l next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.aBG > 0) {
            aj.e(this, this.aBG, i);
        }
        Iterator<l> it = this.aBP.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<s> it2 = this.aBQ.iterator();
        while (it2.hasNext()) {
            s next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean Dg() {
        return getVisibility() == 0 && Dh();
    }

    private boolean Dh() {
        Iterator<s> it = this.aBQ.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aBG = i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            aO(true);
        }
        super.requestDisallowInterceptTouchEvent(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        aO(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    private void aO(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
