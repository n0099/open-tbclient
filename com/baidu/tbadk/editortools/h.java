package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class h extends FrameLayout {
    private int azC;
    private LinkedList<p> azM;
    private LinkedList<y> azN;
    private y azO;
    private boolean azP;
    private boolean azQ;
    private j azR;
    private Runnable azS;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, j jVar) {
        super(context);
        this.azC = w.e.common_color_10255;
        this.azO = null;
        this.azP = true;
        this.azQ = false;
        this.azS = new i(this);
        this.azM = new LinkedList<>();
        this.azN = new LinkedList<>();
        this.azR = jVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(p pVar) {
        this.azM.add(pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(y yVar) {
        this.azN.add(yVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CH() {
        Iterator<y> it = this.azN.iterator();
        while (it.hasNext()) {
            y next = it.next();
            if (next.getToolId() == 2) {
                b(next);
            }
            if (next instanceof View) {
                View view = (View) next;
                view.setVisibility(8);
                addView(view, -1, getContext().getResources().getDimensionPixelSize(w.f.ds460));
            }
            next.init();
        }
        invalidate();
    }

    private void b(y yVar) {
        if (yVar instanceof q) {
            ((q) yVar).i(this.azM);
            yVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.azO = null;
        this.azM.clear();
        this.azN.clear();
    }

    protected void lM() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.azO != null) {
            this.azO.hide();
        }
        this.azO = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ew(int i) {
        if (ez(i)) {
            if (CK()) {
                this.azP = true;
            } else {
                this.azP = false;
            }
            boolean z = this.azQ;
            Iterator<y> it = this.azN.iterator();
            while (it.hasNext()) {
                y next = it.next();
                if (!z && TbadkCoreApplication.m9getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.m9getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.azQ = true;
                }
                if (next.getToolId() == i) {
                    this.azO = next;
                    if (this.azP) {
                        next.lM();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.azP && (getContext() instanceof Activity)) {
                if (this.azR != null) {
                    this.azR.CN();
                } else {
                    com.baidu.adp.lib.util.k.b(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.h.fR().postDelayed(this.azS, 250L);
            }
            lM();
        }
    }

    private boolean ez(int i) {
        Iterator<y> it = this.azN.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public p ey(int i) {
        Iterator<p> it = this.azM.iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.azC > 0) {
            as.e(this, this.azC, i);
        }
        Iterator<p> it = this.azM.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<y> it2 = this.azN.iterator();
        while (it2.hasNext()) {
            y next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean CJ() {
        return getVisibility() == 0 && CK();
    }

    private boolean CK() {
        Iterator<y> it = this.azN.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.azC = i;
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
