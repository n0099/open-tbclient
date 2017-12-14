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
    private int aBL;
    private LinkedList<l> aBU;
    private LinkedList<s> aBV;
    private s aBW;
    private boolean aBX;
    private boolean aBY;
    private i aBZ;
    private Runnable aCa;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, i iVar) {
        super(context);
        this.aBL = d.C0096d.cp_bg_line_d;
        this.aBW = null;
        this.aBX = true;
        this.aBY = false;
        this.aCa = new Runnable() { // from class: com.baidu.tbadk.editortools.h.1
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.aBW != null) {
                    h.this.aBW.lE();
                }
            }
        };
        this.aBU = new LinkedList<>();
        this.aBV = new LinkedList<>();
        this.aBZ = iVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.aBU.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar) {
        this.aBV.add(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Df() {
        Iterator<s> it = this.aBV.iterator();
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
            ((m) sVar).i(this.aBU);
            sVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aBW = null;
        this.aBU.clear();
        this.aBV.clear();
    }

    protected void lE() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.aBW != null) {
            this.aBW.hide();
        }
        this.aBW = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eL(int i) {
        if (eO(i)) {
            if (Di()) {
                this.aBX = true;
            } else {
                this.aBX = false;
            }
            boolean z = this.aBY;
            Iterator<s> it = this.aBV.iterator();
            while (it.hasNext()) {
                s next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.aBY = true;
                }
                if (next.getToolId() == i) {
                    this.aBW = next;
                    if (this.aBX) {
                        next.lE();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.aBX && (getContext() instanceof Activity)) {
                if (this.aBZ != null) {
                    this.aBZ.Dm();
                } else {
                    com.baidu.adp.lib.util.l.a(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.e.fP().postDelayed(this.aCa, 250L);
            }
            lE();
        }
    }

    private boolean eO(int i) {
        Iterator<s> it = this.aBV.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public l eN(int i) {
        Iterator<l> it = this.aBU.iterator();
        while (it.hasNext()) {
            l next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.aBL > 0) {
            aj.e(this, this.aBL, i);
        }
        Iterator<l> it = this.aBU.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<s> it2 = this.aBV.iterator();
        while (it2.hasNext()) {
            s next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean Dh() {
        return getVisibility() == 0 && Di();
    }

    private boolean Di() {
        Iterator<s> it = this.aBV.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aBL = i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            aP(true);
        }
        super.requestDisallowInterceptTouchEvent(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        aP(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    private void aP(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
