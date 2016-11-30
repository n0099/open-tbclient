package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class h extends FrameLayout {
    private LinkedList<s> auD;
    private LinkedList<ab> auE;
    private ab auF;
    private boolean auG;
    private boolean auH;
    private l auI;
    private Runnable auJ;
    private int auu;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, l lVar) {
        super(context);
        this.auu = r.d.common_color_10255;
        this.auF = null;
        this.auG = true;
        this.auH = false;
        this.auJ = new i(this);
        this.auD = new LinkedList<>();
        this.auE = new LinkedList<>();
        this.auI = lVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar) {
        this.auD.add(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ab abVar) {
        this.auE.add(abVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CP() {
        Iterator<ab> it = this.auE.iterator();
        while (it.hasNext()) {
            ab next = it.next();
            if (next.getToolId() == 2) {
                b(next);
            }
            if (next instanceof View) {
                View view = (View) next;
                view.setVisibility(8);
                addView(view, -1, getContext().getResources().getDimensionPixelSize(r.e.ds460));
            }
            next.init();
        }
        invalidate();
    }

    private void b(ab abVar) {
        if (abVar instanceof t) {
            ((t) abVar).h(this.auD);
            abVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.auF = null;
        this.auD.clear();
        this.auE.clear();
    }

    protected void lz() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.auF != null) {
            this.auF.hide();
        }
        this.auF = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ex(int i) {
        if (eA(i)) {
            if (CS()) {
                this.auG = true;
            } else {
                this.auG = false;
            }
            boolean z = this.auH;
            Iterator<ab> it = this.auE.iterator();
            while (it.hasNext()) {
                ab next = it.next();
                if (!z && TbadkCoreApplication.m9getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.m9getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.auH = true;
                }
                if (next.getToolId() == i) {
                    this.auF = next;
                    if (this.auG) {
                        next.lz();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.auG && (getContext() instanceof Activity)) {
                if (this.auI != null) {
                    this.auI.CW();
                } else {
                    com.baidu.adp.lib.util.k.b(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.h.h.eG().postDelayed(this.auJ, 250L);
            }
            lz();
        }
    }

    private boolean eA(int i) {
        Iterator<ab> it = this.auE.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public s ez(int i) {
        Iterator<s> it = this.auD.iterator();
        while (it.hasNext()) {
            s next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.auu > 0) {
            at.e(this, this.auu, i);
        }
        Iterator<s> it = this.auD.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<ab> it2 = this.auE.iterator();
        while (it2.hasNext()) {
            ab next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean CR() {
        return getVisibility() == 0 && CS();
    }

    private boolean CS() {
        Iterator<ab> it = this.auE.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.auu = i;
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
