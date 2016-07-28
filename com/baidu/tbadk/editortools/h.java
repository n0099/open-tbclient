package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class h extends FrameLayout {
    private int aqP;
    private LinkedList<s> aqY;
    private LinkedList<ab> aqZ;
    private ab ara;
    private boolean arb;
    private boolean arc;
    private l ard;
    private Runnable are;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, l lVar) {
        super(context);
        this.aqP = u.d.common_color_10255;
        this.ara = null;
        this.arb = true;
        this.arc = false;
        this.are = new i(this);
        this.aqY = new LinkedList<>();
        this.aqZ = new LinkedList<>();
        this.ard = lVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar) {
        this.aqY.add(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ab abVar) {
        this.aqZ.add(abVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bm() {
        Iterator<ab> it = this.aqZ.iterator();
        while (it.hasNext()) {
            ab next = it.next();
            if (next.getToolId() == 2) {
                b(next);
            }
            if (next instanceof View) {
                View view = (View) next;
                view.setVisibility(8);
                addView(view, -1, getContext().getResources().getDimensionPixelSize(u.e.ds460));
            }
            next.init();
        }
        invalidate();
    }

    private void b(ab abVar) {
        if (abVar instanceof t) {
            ((t) abVar).h(this.aqY);
            abVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.ara = null;
        this.aqY.clear();
        this.aqZ.clear();
    }

    protected void kB() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.ara != null) {
            this.ara.hide();
        }
        this.ara = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eh(int i) {
        if (ek(i)) {
            if (Bp()) {
                this.arb = true;
            } else {
                this.arb = false;
            }
            boolean z = this.arc;
            Iterator<ab> it = this.aqZ.iterator();
            while (it.hasNext()) {
                ab next = it.next();
                if (!z && TbadkCoreApplication.m10getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.m10getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.arc = true;
                }
                if (next.getToolId() == i) {
                    this.ara = next;
                    if (this.arb) {
                        next.kB();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.arb && (getContext() instanceof Activity)) {
                if (this.ard != null) {
                    this.ard.Bt();
                } else {
                    com.baidu.adp.lib.util.k.b(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.h.h.dL().postDelayed(this.are, 250L);
            }
            kB();
        }
    }

    private boolean ek(int i) {
        Iterator<ab> it = this.aqZ.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public s ej(int i) {
        Iterator<s> it = this.aqY.iterator();
        while (it.hasNext()) {
            s next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.aqP > 0) {
            av.e(this, this.aqP, i);
        }
        Iterator<s> it = this.aqY.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<ab> it2 = this.aqZ.iterator();
        while (it2.hasNext()) {
            ab next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean Bo() {
        return getVisibility() == 0 && Bp();
    }

    private boolean Bp() {
        Iterator<ab> it = this.aqZ.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aqP = i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            aM(true);
        }
        super.requestDisallowInterceptTouchEvent(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        aM(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    private void aM(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
