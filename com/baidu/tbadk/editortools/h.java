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
    private int bqb;
    private LinkedList<l> bqk;
    private LinkedList<s> bql;
    private s bqm;
    private boolean bqn;
    private boolean bqo;
    private i bqp;
    private Runnable bqq;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, i iVar) {
        super(context);
        this.bqb = d.C0108d.cp_bg_line_d;
        this.bqm = null;
        this.bqn = true;
        this.bqo = false;
        this.bqq = new Runnable() { // from class: com.baidu.tbadk.editortools.h.1
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.bqm != null) {
                    h.this.bqm.ti();
                }
            }
        };
        this.bqk = new LinkedList<>();
        this.bql = new LinkedList<>();
        this.bqp = iVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.bqk.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar) {
        this.bql.add(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Kx() {
        Iterator<s> it = this.bql.iterator();
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
            ((m) sVar).j(this.bqk);
            sVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.bqm = null;
        this.bqk.clear();
        this.bql.clear();
    }

    protected void ti() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.bqm != null) {
            this.bqm.hide();
        }
        this.bqm = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hF(int i) {
        if (hI(i)) {
            if (KA()) {
                this.bqn = true;
            } else {
                this.bqn = false;
            }
            boolean z = this.bqo;
            Iterator<s> it = this.bql.iterator();
            while (it.hasNext()) {
                s next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.bqo = true;
                }
                if (next.getToolId() == i) {
                    this.bqm = next;
                    if (this.bqn) {
                        next.ti();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.bqn && (getContext() instanceof Activity)) {
                if (this.bqp != null) {
                    this.bqp.KE();
                } else {
                    com.baidu.adp.lib.util.l.a(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.e.ns().postDelayed(this.bqq, 250L);
            }
            ti();
        }
    }

    private boolean hI(int i) {
        Iterator<s> it = this.bql.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public l hH(int i) {
        Iterator<l> it = this.bqk.iterator();
        while (it.hasNext()) {
            l next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.bqb > 0) {
            aj.g(this, this.bqb, i);
        }
        Iterator<l> it = this.bqk.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<s> it2 = this.bql.iterator();
        while (it2.hasNext()) {
            s next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean Kz() {
        return getVisibility() == 0 && KA();
    }

    private boolean KA() {
        Iterator<s> it = this.bql.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.bqb = i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            bw(true);
        }
        super.requestDisallowInterceptTouchEvent(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        bw(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    private void bw(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
