package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class h extends FrameLayout {
    private int ate;
    private LinkedList<p> atn;
    private LinkedList<y> ato;
    private y atp;
    private boolean atq;
    private boolean atr;
    private j ats;
    private Runnable att;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, j jVar) {
        super(context);
        this.ate = r.e.common_color_10255;
        this.atp = null;
        this.atq = true;
        this.atr = false;
        this.att = new i(this);
        this.atn = new LinkedList<>();
        this.ato = new LinkedList<>();
        this.ats = jVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(p pVar) {
        this.atn.add(pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(y yVar) {
        this.ato.add(yVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Cx() {
        Iterator<y> it = this.ato.iterator();
        while (it.hasNext()) {
            y next = it.next();
            if (next.getToolId() == 2) {
                b(next);
            }
            if (next instanceof View) {
                View view = (View) next;
                view.setVisibility(8);
                addView(view, -1, getContext().getResources().getDimensionPixelSize(r.f.ds460));
            }
            next.init();
        }
        invalidate();
    }

    private void b(y yVar) {
        if (yVar instanceof q) {
            ((q) yVar).h(this.atn);
            yVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.atp = null;
        this.atn.clear();
        this.ato.clear();
    }

    protected void lr() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.atp != null) {
            this.atp.hide();
        }
        this.atp = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ez(int i) {
        if (eC(i)) {
            if (CA()) {
                this.atq = true;
            } else {
                this.atq = false;
            }
            boolean z = this.atr;
            Iterator<y> it = this.ato.iterator();
            while (it.hasNext()) {
                y next = it.next();
                if (!z && TbadkCoreApplication.m9getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.m9getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.atr = true;
                }
                if (next.getToolId() == i) {
                    this.atp = next;
                    if (this.atq) {
                        next.lr();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.atq && (getContext() instanceof Activity)) {
                if (this.ats != null) {
                    this.ats.CC();
                } else {
                    com.baidu.adp.lib.util.k.b(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.h.eE().postDelayed(this.att, 250L);
            }
            lr();
        }
    }

    private boolean eC(int i) {
        Iterator<y> it = this.ato.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public p eB(int i) {
        Iterator<p> it = this.atn.iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.ate > 0) {
            ap.e(this, this.ate, i);
        }
        Iterator<p> it = this.atn.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<y> it2 = this.ato.iterator();
        while (it2.hasNext()) {
            y next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean Cz() {
        return getVisibility() == 0 && CA();
    }

    private boolean CA() {
        Iterator<y> it = this.ato.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.ate = i;
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
