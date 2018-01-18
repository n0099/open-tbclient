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
    private int bpS;
    private LinkedList<l> bqb;
    private LinkedList<s> bqc;
    private s bqd;
    private boolean bqe;
    private boolean bqf;
    private i bqg;
    private Runnable bqh;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, i iVar) {
        super(context);
        this.bpS = d.C0107d.cp_bg_line_d;
        this.bqd = null;
        this.bqe = true;
        this.bqf = false;
        this.bqh = new Runnable() { // from class: com.baidu.tbadk.editortools.h.1
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.bqd != null) {
                    h.this.bqd.th();
                }
            }
        };
        this.bqb = new LinkedList<>();
        this.bqc = new LinkedList<>();
        this.bqg = iVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.bqb.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar) {
        this.bqc.add(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Kv() {
        Iterator<s> it = this.bqc.iterator();
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
            ((m) sVar).j(this.bqb);
            sVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.bqd = null;
        this.bqb.clear();
        this.bqc.clear();
    }

    protected void th() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.bqd != null) {
            this.bqd.hide();
        }
        this.bqd = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hF(int i) {
        if (hI(i)) {
            if (Ky()) {
                this.bqe = true;
            } else {
                this.bqe = false;
            }
            boolean z = this.bqf;
            Iterator<s> it = this.bqc.iterator();
            while (it.hasNext()) {
                s next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.bqf = true;
                }
                if (next.getToolId() == i) {
                    this.bqd = next;
                    if (this.bqe) {
                        next.th();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.bqe && (getContext() instanceof Activity)) {
                if (this.bqg != null) {
                    this.bqg.KC();
                } else {
                    com.baidu.adp.lib.util.l.a(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.e.nr().postDelayed(this.bqh, 250L);
            }
            th();
        }
    }

    private boolean hI(int i) {
        Iterator<s> it = this.bqc.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public l hH(int i) {
        Iterator<l> it = this.bqb.iterator();
        while (it.hasNext()) {
            l next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.bpS > 0) {
            aj.g(this, this.bpS, i);
        }
        Iterator<l> it = this.bqb.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<s> it2 = this.bqc.iterator();
        while (it2.hasNext()) {
            s next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean Kx() {
        return getVisibility() == 0 && Ky();
    }

    private boolean Ky() {
        Iterator<s> it = this.bqc.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.bpS = i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            bv(true);
        }
        super.requestDisallowInterceptTouchEvent(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        bv(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    private void bv(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
