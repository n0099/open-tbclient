package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class h extends FrameLayout {
    private int asc;
    private LinkedList<r> asj;
    private LinkedList<z> ask;
    private z asl;
    private boolean asm;
    private boolean asn;
    private k aso;
    private Runnable asp;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, k kVar) {
        super(context);
        this.asc = n.d.editor_background;
        this.asl = null;
        this.asm = true;
        this.asn = false;
        this.asp = new i(this);
        this.asj = new LinkedList<>();
        this.ask = new LinkedList<>();
        this.aso = kVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(r rVar) {
        this.asj.add(rVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(z zVar) {
        this.ask.add(zVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bk() {
        Iterator<z> it = this.ask.iterator();
        while (it.hasNext()) {
            z next = it.next();
            if (next.getToolId() == 2) {
                b(next);
            }
            if (next instanceof View) {
                View view = (View) next;
                view.setVisibility(8);
                addView(view, -1, getContext().getResources().getDimensionPixelSize(n.e.editor_tool_desk_height));
            }
            next.init();
        }
        invalidate();
    }

    private void b(z zVar) {
        if (zVar instanceof s) {
            ((s) zVar).i(this.asj);
            zVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.asl = null;
        this.asj.clear();
        this.ask.clear();
    }

    protected void ob() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.asl != null) {
            this.asl.hide();
        }
        this.asl = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dY(int i) {
        if (eb(i)) {
            if (Bn()) {
                this.asm = true;
            } else {
                this.asm = false;
            }
            boolean z = this.asn;
            Iterator<z> it = this.ask.iterator();
            while (it.hasNext()) {
                z next = it.next();
                if (!z && TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.asn = true;
                }
                if (next.getToolId() == i) {
                    this.asl = next;
                    if (this.asm) {
                        next.ob();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.asm && (getContext() instanceof Activity)) {
                if (this.aso != null) {
                    this.aso.Br();
                } else {
                    com.baidu.adp.lib.util.k.c(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.h.h.hj().postDelayed(this.asp, 250L);
            }
            ob();
        }
    }

    private boolean eb(int i) {
        Iterator<z> it = this.ask.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public r ea(int i) {
        Iterator<r> it = this.asj.iterator();
        while (it.hasNext()) {
            r next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.asc > 0) {
            as.d(this, this.asc, i);
        }
        Iterator<r> it = this.asj.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<z> it2 = this.ask.iterator();
        while (it2.hasNext()) {
            z next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean Bm() {
        return getVisibility() == 0 && Bn();
    }

    private boolean Bn() {
        Iterator<z> it = this.ask.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.asc = i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            ay(true);
        }
        super.requestDisallowInterceptTouchEvent(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ay(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    private void ay(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
