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
    private int aqa;
    private LinkedList<s> aqj;
    private LinkedList<ab> aqk;
    private ab aql;
    private boolean aqm;
    private boolean aqn;
    private l aqo;
    private Runnable aqp;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, l lVar) {
        super(context);
        this.aqa = u.d.common_color_10255;
        this.aql = null;
        this.aqm = true;
        this.aqn = false;
        this.aqp = new i(this);
        this.aqj = new LinkedList<>();
        this.aqk = new LinkedList<>();
        this.aqo = lVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar) {
        this.aqj.add(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ab abVar) {
        this.aqk.add(abVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bm() {
        Iterator<ab> it = this.aqk.iterator();
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
            ((t) abVar).h(this.aqj);
            abVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aql = null;
        this.aqj.clear();
        this.aqk.clear();
    }

    protected void kF() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.aql != null) {
            this.aql.hide();
        }
        this.aql = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eh(int i) {
        if (ek(i)) {
            if (Bp()) {
                this.aqm = true;
            } else {
                this.aqm = false;
            }
            boolean z = this.aqn;
            Iterator<ab> it = this.aqk.iterator();
            while (it.hasNext()) {
                ab next = it.next();
                if (!z && TbadkCoreApplication.m9getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.m9getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.aqn = true;
                }
                if (next.getToolId() == i) {
                    this.aql = next;
                    if (this.aqm) {
                        next.kF();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.aqm && (getContext() instanceof Activity)) {
                if (this.aqo != null) {
                    this.aqo.Bt();
                } else {
                    com.baidu.adp.lib.util.k.a(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.h.h.dM().postDelayed(this.aqp, 250L);
            }
            kF();
        }
    }

    private boolean ek(int i) {
        Iterator<ab> it = this.aqk.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public s ej(int i) {
        Iterator<s> it = this.aqj.iterator();
        while (it.hasNext()) {
            s next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.aqa > 0) {
            av.e(this, this.aqa, i);
        }
        Iterator<s> it = this.aqj.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<ab> it2 = this.aqk.iterator();
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
        Iterator<ab> it = this.aqk.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aqa = i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            aJ(true);
        }
        super.requestDisallowInterceptTouchEvent(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        aJ(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    private void aJ(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
