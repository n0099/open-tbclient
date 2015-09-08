package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class h extends FrameLayout {
    private int aqb;
    private LinkedList<p> aqj;
    private LinkedList<w> aqk;
    private w aql;
    private boolean aqm;
    private boolean aqn;
    private Runnable aqo;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, j jVar) {
        super(context);
        this.aqb = i.c.editor_background;
        this.aql = null;
        this.aqm = true;
        this.aqn = false;
        this.aqo = new i(this);
        this.aqj = new LinkedList<>();
        this.aqk = new LinkedList<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(p pVar) {
        this.aqj.add(pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(w wVar) {
        this.aqk.add(wVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void AM() {
        Iterator<w> it = this.aqk.iterator();
        while (it.hasNext()) {
            w next = it.next();
            if (next.getToolId() == 2) {
                b(next);
            }
            if (next instanceof View) {
                View view = (View) next;
                view.setVisibility(8);
                addView(view, -1, getContext().getResources().getDimensionPixelSize(i.d.editor_tool_desk_height));
            }
            next.init();
        }
        invalidate();
    }

    private void b(w wVar) {
        if (wVar instanceof q) {
            ((q) wVar).i(this.aqj);
            wVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aql = null;
        this.aqj.clear();
        this.aqk.clear();
    }

    protected void ov() {
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
    public void dP(int i) {
        if (dS(i)) {
            if (AP()) {
                this.aqm = true;
            } else {
                this.aqm = false;
            }
            boolean z = this.aqn;
            Iterator<w> it = this.aqk.iterator();
            while (it.hasNext()) {
                w next = it.next();
                if (!z && TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.aqn = true;
                }
                if (next.getToolId() == i) {
                    this.aql = next;
                    if (this.aqm) {
                        next.ov();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.aqm && (getContext() instanceof Activity)) {
                com.baidu.adp.lib.util.k.c(getContext(), ((Activity) getContext()).getCurrentFocus());
                com.baidu.adp.lib.g.h.hf().postDelayed(this.aqo, 250L);
            }
            ov();
        }
    }

    private boolean dS(int i) {
        Iterator<w> it = this.aqk.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public p dR(int i) {
        Iterator<p> it = this.aqj.iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.aqb > 0) {
            al.d(this, this.aqb, i);
        }
        Iterator<p> it = this.aqj.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<w> it2 = this.aqk.iterator();
        while (it2.hasNext()) {
            w next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean AO() {
        return getVisibility() == 0 && AP();
    }

    private boolean AP() {
        Iterator<w> it = this.aqk.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aqb = i;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }
}
