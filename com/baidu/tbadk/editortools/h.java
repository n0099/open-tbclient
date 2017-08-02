package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class h extends FrameLayout {
    private int aAC;
    private LinkedList<l> aAM;
    private LinkedList<s> aAN;
    private s aAO;
    private boolean aAP;
    private boolean aAQ;
    private i aAR;
    private Runnable aAS;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, i iVar) {
        super(context);
        this.aAC = d.e.common_color_10255;
        this.aAO = null;
        this.aAP = true;
        this.aAQ = false;
        this.aAS = new Runnable() { // from class: com.baidu.tbadk.editortools.h.1
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.aAO != null) {
                    h.this.aAO.lJ();
                }
            }
        };
        this.aAM = new LinkedList<>();
        this.aAN = new LinkedList<>();
        this.aAR = iVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.aAM.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar) {
        this.aAN.add(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CT() {
        Iterator<s> it = this.aAN.iterator();
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
            ((m) sVar).i(this.aAM);
            sVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aAO = null;
        this.aAM.clear();
        this.aAN.clear();
    }

    protected void lJ() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.aAO != null) {
            this.aAO.hide();
        }
        this.aAO = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ey(int i) {
        if (eB(i)) {
            if (CW()) {
                this.aAP = true;
            } else {
                this.aAP = false;
            }
            boolean z = this.aAQ;
            Iterator<s> it = this.aAN.iterator();
            while (it.hasNext()) {
                s next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.aAQ = true;
                }
                if (next.getToolId() == i) {
                    this.aAO = next;
                    if (this.aAP) {
                        next.lJ();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.aAP && (getContext() instanceof Activity)) {
                if (this.aAR != null) {
                    this.aAR.CZ();
                } else {
                    com.baidu.adp.lib.util.k.b(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.e.fP().postDelayed(this.aAS, 250L);
            }
            lJ();
        }
    }

    private boolean eB(int i) {
        Iterator<s> it = this.aAN.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public l eA(int i) {
        Iterator<l> it = this.aAM.iterator();
        while (it.hasNext()) {
            l next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.aAC > 0) {
            ai.e(this, this.aAC, i);
        }
        Iterator<l> it = this.aAM.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<s> it2 = this.aAN.iterator();
        while (it2.hasNext()) {
            s next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean CV() {
        return getVisibility() == 0 && CW();
    }

    private boolean CW() {
        Iterator<s> it = this.aAN.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aAC = i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            aS(true);
        }
        super.requestDisallowInterceptTouchEvent(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        aS(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    private void aS(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
