package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class h extends FrameLayout {
    private LinkedList<s> atB;
    private LinkedList<ab> atC;
    private ab atD;
    private boolean atE;
    private boolean atF;
    private l atG;
    private Runnable atH;
    private int atu;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, l lVar) {
        super(context);
        this.atu = t.d.editor_background;
        this.atD = null;
        this.atE = true;
        this.atF = false;
        this.atH = new i(this);
        this.atB = new LinkedList<>();
        this.atC = new LinkedList<>();
        this.atG = lVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar) {
        this.atB.add(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ab abVar) {
        this.atC.add(abVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Di() {
        Iterator<ab> it = this.atC.iterator();
        while (it.hasNext()) {
            ab next = it.next();
            if (next.getToolId() == 2) {
                b(next);
            }
            if (next instanceof View) {
                View view = (View) next;
                view.setVisibility(8);
                addView(view, -1, getContext().getResources().getDimensionPixelSize(t.e.editor_tool_desk_height));
            }
            next.init();
        }
        invalidate();
    }

    private void b(ab abVar) {
        if (abVar instanceof t) {
            ((t) abVar).i(this.atB);
            abVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.atD = null;
        this.atB.clear();
        this.atC.clear();
    }

    protected void op() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.atD != null) {
            this.atD.hide();
        }
        this.atD = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ey(int i) {
        if (eB(i)) {
            if (Dl()) {
                this.atE = true;
            } else {
                this.atE = false;
            }
            boolean z = this.atF;
            Iterator<ab> it = this.atC.iterator();
            while (it.hasNext()) {
                ab next = it.next();
                if (!z && TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.atF = true;
                }
                if (next.getToolId() == i) {
                    this.atD = next;
                    if (this.atE) {
                        next.op();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.atE && (getContext() instanceof Activity)) {
                if (this.atG != null) {
                    this.atG.Dp();
                } else {
                    com.baidu.adp.lib.util.k.c(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.h.h.hx().postDelayed(this.atH, 250L);
            }
            op();
        }
    }

    private boolean eB(int i) {
        Iterator<ab> it = this.atC.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public s eA(int i) {
        Iterator<s> it = this.atB.iterator();
        while (it.hasNext()) {
            s next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.atu > 0) {
            at.d(this, this.atu, i);
        }
        Iterator<s> it = this.atB.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<ab> it2 = this.atC.iterator();
        while (it2.hasNext()) {
            ab next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean Dk() {
        return getVisibility() == 0 && Dl();
    }

    private boolean Dl() {
        Iterator<ab> it = this.atC.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.atu = i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            aF(true);
        }
        super.requestDisallowInterceptTouchEvent(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        aF(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    private void aF(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
