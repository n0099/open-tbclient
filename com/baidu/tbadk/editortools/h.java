package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class h extends FrameLayout {
    private int atA;
    private LinkedList<s> atJ;
    private LinkedList<ab> atK;
    private ab atL;
    private boolean atM;
    private boolean atN;
    private l atO;
    private Runnable atP;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, l lVar) {
        super(context);
        this.atA = r.d.common_color_10255;
        this.atL = null;
        this.atM = true;
        this.atN = false;
        this.atP = new i(this);
        this.atJ = new LinkedList<>();
        this.atK = new LinkedList<>();
        this.atO = lVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar) {
        this.atJ.add(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ab abVar) {
        this.atK.add(abVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CH() {
        Iterator<ab> it = this.atK.iterator();
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
            ((t) abVar).h(this.atJ);
            abVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.atL = null;
        this.atJ.clear();
        this.atK.clear();
    }

    protected void lw() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.atL != null) {
            this.atL.hide();
        }
        this.atL = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eu(int i) {
        if (ex(i)) {
            if (CK()) {
                this.atM = true;
            } else {
                this.atM = false;
            }
            boolean z = this.atN;
            Iterator<ab> it = this.atK.iterator();
            while (it.hasNext()) {
                ab next = it.next();
                if (!z && TbadkCoreApplication.m9getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.m9getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.atN = true;
                }
                if (next.getToolId() == i) {
                    this.atL = next;
                    if (this.atM) {
                        next.lw();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.atM && (getContext() instanceof Activity)) {
                if (this.atO != null) {
                    this.atO.CO();
                } else {
                    com.baidu.adp.lib.util.k.b(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.h.h.eG().postDelayed(this.atP, 250L);
            }
            lw();
        }
    }

    private boolean ex(int i) {
        Iterator<ab> it = this.atK.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public s ew(int i) {
        Iterator<s> it = this.atJ.iterator();
        while (it.hasNext()) {
            s next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.atA > 0) {
            av.e(this, this.atA, i);
        }
        Iterator<s> it = this.atJ.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<ab> it2 = this.atK.iterator();
        while (it2.hasNext()) {
            ab next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean CJ() {
        return getVisibility() == 0 && CK();
    }

    private boolean CK() {
        Iterator<ab> it = this.atK.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.atA = i;
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
