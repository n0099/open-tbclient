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
    private int aAX;
    private LinkedList<l> aBg;
    private LinkedList<s> aBh;
    private s aBi;
    private boolean aBj;
    private boolean aBk;
    private i aBl;
    private Runnable aBm;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, i iVar) {
        super(context);
        this.aAX = d.C0080d.common_color_10255;
        this.aBi = null;
        this.aBj = true;
        this.aBk = false;
        this.aBm = new Runnable() { // from class: com.baidu.tbadk.editortools.h.1
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.aBi != null) {
                    h.this.aBi.lG();
                }
            }
        };
        this.aBg = new LinkedList<>();
        this.aBh = new LinkedList<>();
        this.aBl = iVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.aBg.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar) {
        this.aBh.add(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CJ() {
        Iterator<s> it = this.aBh.iterator();
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
            ((m) sVar).i(this.aBg);
            sVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aBi = null;
        this.aBg.clear();
        this.aBh.clear();
    }

    protected void lG() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.aBi != null) {
            this.aBi.hide();
        }
        this.aBi = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eL(int i) {
        if (eO(i)) {
            if (CM()) {
                this.aBj = true;
            } else {
                this.aBj = false;
            }
            boolean z = this.aBk;
            Iterator<s> it = this.aBh.iterator();
            while (it.hasNext()) {
                s next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.aBk = true;
                }
                if (next.getToolId() == i) {
                    this.aBi = next;
                    if (this.aBj) {
                        next.lG();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.aBj && (getContext() instanceof Activity)) {
                if (this.aBl != null) {
                    this.aBl.CP();
                } else {
                    com.baidu.adp.lib.util.l.a(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.e.fP().postDelayed(this.aBm, 250L);
            }
            lG();
        }
    }

    private boolean eO(int i) {
        Iterator<s> it = this.aBh.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public l eN(int i) {
        Iterator<l> it = this.aBg.iterator();
        while (it.hasNext()) {
            l next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.aAX > 0) {
            aj.e(this, this.aAX, i);
        }
        Iterator<l> it = this.aBg.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<s> it2 = this.aBh.iterator();
        while (it2.hasNext()) {
            s next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean CL() {
        return getVisibility() == 0 && CM();
    }

    private boolean CM() {
        Iterator<s> it = this.aBh.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aAX = i;
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
