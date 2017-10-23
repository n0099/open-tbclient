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
    private boolean aAA;
    private i aAB;
    private Runnable aAC;
    private int aAm;
    private LinkedList<l> aAw;
    private LinkedList<s> aAx;
    private s aAy;
    private boolean aAz;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, i iVar) {
        super(context);
        this.aAm = d.e.common_color_10255;
        this.aAy = null;
        this.aAz = true;
        this.aAA = false;
        this.aAC = new Runnable() { // from class: com.baidu.tbadk.editortools.h.1
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.aAy != null) {
                    h.this.aAy.lM();
                }
            }
        };
        this.aAw = new LinkedList<>();
        this.aAx = new LinkedList<>();
        this.aAB = iVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.aAw.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar) {
        this.aAx.add(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Cu() {
        Iterator<s> it = this.aAx.iterator();
        while (it.hasNext()) {
            s next = it.next();
            if (next.getToolId() == 2) {
                b(next);
            }
            if (next instanceof View) {
                View view = (View) next;
                view.setVisibility(8);
                addView(view, -1, getContext().getResources().getDimensionPixelSize(d.f.ds460));
            }
            next.init();
        }
        invalidate();
    }

    private void b(s sVar) {
        if (sVar instanceof m) {
            ((m) sVar).i(this.aAw);
            sVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aAy = null;
        this.aAw.clear();
        this.aAx.clear();
    }

    protected void lM() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.aAy != null) {
            this.aAy.hide();
        }
        this.aAy = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eK(int i) {
        if (eN(i)) {
            if (Cx()) {
                this.aAz = true;
            } else {
                this.aAz = false;
            }
            boolean z = this.aAA;
            Iterator<s> it = this.aAx.iterator();
            while (it.hasNext()) {
                s next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.aAA = true;
                }
                if (next.getToolId() == i) {
                    this.aAy = next;
                    if (this.aAz) {
                        next.lM();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.aAz && (getContext() instanceof Activity)) {
                if (this.aAB != null) {
                    this.aAB.CA();
                } else {
                    com.baidu.adp.lib.util.l.a(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.e.fP().postDelayed(this.aAC, 250L);
            }
            lM();
        }
    }

    private boolean eN(int i) {
        Iterator<s> it = this.aAx.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public l eM(int i) {
        Iterator<l> it = this.aAw.iterator();
        while (it.hasNext()) {
            l next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.aAm > 0) {
            aj.e(this, this.aAm, i);
        }
        Iterator<l> it = this.aAw.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<s> it2 = this.aAx.iterator();
        while (it2.hasNext()) {
            s next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean Cw() {
        return getVisibility() == 0 && Cx();
    }

    private boolean Cx() {
        Iterator<s> it = this.aAx.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aAm = i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            aQ(true);
        }
        super.requestDisallowInterceptTouchEvent(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        aQ(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    private void aQ(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
