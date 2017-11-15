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
    private int aBf;
    private LinkedList<l> aBo;
    private LinkedList<s> aBp;
    private s aBq;
    private boolean aBr;
    private boolean aBs;
    private i aBt;
    private Runnable aBu;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, i iVar) {
        super(context);
        this.aBf = d.C0080d.common_color_10255;
        this.aBq = null;
        this.aBr = true;
        this.aBs = false;
        this.aBu = new Runnable() { // from class: com.baidu.tbadk.editortools.h.1
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.aBq != null) {
                    h.this.aBq.lG();
                }
            }
        };
        this.aBo = new LinkedList<>();
        this.aBp = new LinkedList<>();
        this.aBt = iVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.aBo.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar) {
        this.aBp.add(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CV() {
        Iterator<s> it = this.aBp.iterator();
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
            ((m) sVar).i(this.aBo);
            sVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aBq = null;
        this.aBo.clear();
        this.aBp.clear();
    }

    protected void lG() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.aBq != null) {
            this.aBq.hide();
        }
        this.aBq = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eK(int i) {
        if (eN(i)) {
            if (CY()) {
                this.aBr = true;
            } else {
                this.aBr = false;
            }
            boolean z = this.aBs;
            Iterator<s> it = this.aBp.iterator();
            while (it.hasNext()) {
                s next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.aBs = true;
                }
                if (next.getToolId() == i) {
                    this.aBq = next;
                    if (this.aBr) {
                        next.lG();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.aBr && (getContext() instanceof Activity)) {
                if (this.aBt != null) {
                    this.aBt.Db();
                } else {
                    com.baidu.adp.lib.util.l.a(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.e.fP().postDelayed(this.aBu, 250L);
            }
            lG();
        }
    }

    private boolean eN(int i) {
        Iterator<s> it = this.aBp.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public l eM(int i) {
        Iterator<l> it = this.aBo.iterator();
        while (it.hasNext()) {
            l next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.aBf > 0) {
            aj.e(this, this.aBf, i);
        }
        Iterator<l> it = this.aBo.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<s> it2 = this.aBp.iterator();
        while (it2.hasNext()) {
            s next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean CX() {
        return getVisibility() == 0 && CY();
    }

    private boolean CY() {
        Iterator<s> it = this.aBp.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aBf = i;
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
