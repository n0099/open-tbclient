package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class h extends FrameLayout {
    private int asV;
    private LinkedList<r> atc;
    private LinkedList<z> atd;
    private z ate;
    private boolean atf;
    private boolean atg;
    private k ath;
    private Runnable ati;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, k kVar) {
        super(context);
        this.asV = t.d.editor_background;
        this.ate = null;
        this.atf = true;
        this.atg = false;
        this.ati = new i(this);
        this.atc = new LinkedList<>();
        this.atd = new LinkedList<>();
        this.ath = kVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(r rVar) {
        this.atc.add(rVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(z zVar) {
        this.atd.add(zVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CA() {
        Iterator<z> it = this.atd.iterator();
        while (it.hasNext()) {
            z next = it.next();
            if (next.getToolId() == 2) {
                b(next);
            }
            if (next instanceof View) {
                View view = (View) next;
                view.setVisibility(8);
                addView(view, -1, getContext().getResources().getDimensionPixelSize(t.e.editor_tool_desk_height));
            }
            next.init();
        }
        invalidate();
    }

    private void b(z zVar) {
        if (zVar instanceof s) {
            ((s) zVar).i(this.atc);
            zVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.ate = null;
        this.atc.clear();
        this.atd.clear();
    }

    protected void ow() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.ate != null) {
            this.ate.hide();
        }
        this.ate = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void et(int i) {
        if (ew(i)) {
            if (CD()) {
                this.atf = true;
            } else {
                this.atf = false;
            }
            boolean z = this.atg;
            Iterator<z> it = this.atd.iterator();
            while (it.hasNext()) {
                z next = it.next();
                if (!z && TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.atg = true;
                }
                if (next.getToolId() == i) {
                    this.ate = next;
                    if (this.atf) {
                        next.ow();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.atf && (getContext() instanceof Activity)) {
                if (this.ath != null) {
                    this.ath.CH();
                } else {
                    com.baidu.adp.lib.util.k.c(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.h.h.hr().postDelayed(this.ati, 250L);
            }
            ow();
        }
    }

    private boolean ew(int i) {
        Iterator<z> it = this.atd.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public r ev(int i) {
        Iterator<r> it = this.atc.iterator();
        while (it.hasNext()) {
            r next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.asV > 0) {
            ar.d(this, this.asV, i);
        }
        Iterator<r> it = this.atc.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<z> it2 = this.atd.iterator();
        while (it2.hasNext()) {
            z next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean CC() {
        return getVisibility() == 0 && CD();
    }

    private boolean CD() {
        Iterator<z> it = this.atd.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.asV = i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            aA(true);
        }
        super.requestDisallowInterceptTouchEvent(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        aA(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    private void aA(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
