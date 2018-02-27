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
    private int bsb;
    private LinkedList<l> bsk;
    private LinkedList<s> bsl;
    private s bsm;
    private boolean bsn;
    private boolean bso;
    private i bsp;
    private Runnable bsq;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, i iVar) {
        super(context);
        this.bsb = d.C0141d.cp_bg_line_d;
        this.bsm = null;
        this.bsn = true;
        this.bso = false;
        this.bsq = new Runnable() { // from class: com.baidu.tbadk.editortools.h.1
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.bsm != null) {
                    h.this.bsm.th();
                }
            }
        };
        this.bsk = new LinkedList<>();
        this.bsl = new LinkedList<>();
        this.bsp = iVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.bsk.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar) {
        this.bsl.add(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Lc() {
        Iterator<s> it = this.bsl.iterator();
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
            ((m) sVar).j(this.bsk);
            sVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.bsm = null;
        this.bsk.clear();
        this.bsl.clear();
    }

    protected void th() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.bsm != null) {
            this.bsm.hide();
        }
        this.bsm = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hE(int i) {
        if (hH(i)) {
            if (Lf()) {
                this.bsn = true;
            } else {
                this.bsn = false;
            }
            boolean z = this.bso;
            Iterator<s> it = this.bsl.iterator();
            while (it.hasNext()) {
                s next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.bso = true;
                }
                if (next.getToolId() == i) {
                    this.bsm = next;
                    if (this.bsn) {
                        next.th();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.bsn && (getContext() instanceof Activity)) {
                if (this.bsp != null) {
                    this.bsp.Lj();
                } else {
                    com.baidu.adp.lib.util.l.a(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.e.ns().postDelayed(this.bsq, 250L);
            }
            th();
        }
    }

    private boolean hH(int i) {
        Iterator<s> it = this.bsl.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public l hG(int i) {
        Iterator<l> it = this.bsk.iterator();
        while (it.hasNext()) {
            l next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.bsb > 0) {
            aj.g(this, this.bsb, i);
        }
        Iterator<l> it = this.bsk.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<s> it2 = this.bsl.iterator();
        while (it2.hasNext()) {
            s next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean Le() {
        return getVisibility() == 0 && Lf();
    }

    private boolean Lf() {
        Iterator<s> it = this.bsl.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.bsb = i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            bB(true);
        }
        super.requestDisallowInterceptTouchEvent(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        bB(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    private void bB(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
