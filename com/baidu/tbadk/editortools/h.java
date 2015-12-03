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
    private LinkedList<r> aqF;
    private LinkedList<z> aqG;
    private z aqH;
    private boolean aqI;
    private boolean aqJ;
    private k aqK;
    private Runnable aqL;
    private int aqy;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, k kVar) {
        super(context);
        this.aqy = n.c.editor_background;
        this.aqH = null;
        this.aqI = true;
        this.aqJ = false;
        this.aqL = new i(this);
        this.aqF = new LinkedList<>();
        this.aqG = new LinkedList<>();
        this.aqK = kVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(r rVar) {
        this.aqF.add(rVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(z zVar) {
        this.aqG.add(zVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bv() {
        Iterator<z> it = this.aqG.iterator();
        while (it.hasNext()) {
            z next = it.next();
            if (next.getToolId() == 2) {
                b(next);
            }
            if (next instanceof View) {
                View view = (View) next;
                view.setVisibility(8);
                addView(view, -1, getContext().getResources().getDimensionPixelSize(n.d.editor_tool_desk_height));
            }
            next.init();
        }
        invalidate();
    }

    private void b(z zVar) {
        if (zVar instanceof s) {
            ((s) zVar).i(this.aqF);
            zVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aqH = null;
        this.aqF.clear();
        this.aqG.clear();
    }

    protected void oD() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.aqH != null) {
            this.aqH.hide();
        }
        this.aqH = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ee(int i) {
        if (eh(i)) {
            if (By()) {
                this.aqI = true;
            } else {
                this.aqI = false;
            }
            boolean z = this.aqJ;
            Iterator<z> it = this.aqG.iterator();
            while (it.hasNext()) {
                z next = it.next();
                if (!z && TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.aqJ = true;
                }
                if (next.getToolId() == i) {
                    this.aqH = next;
                    if (this.aqI) {
                        next.oD();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.aqI && (getContext() instanceof Activity)) {
                if (this.aqK != null) {
                    this.aqK.BC();
                } else {
                    com.baidu.adp.lib.util.k.c(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.h.h.hj().postDelayed(this.aqL, 250L);
            }
            oD();
        }
    }

    private boolean eh(int i) {
        Iterator<z> it = this.aqG.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public r eg(int i) {
        Iterator<r> it = this.aqF.iterator();
        while (it.hasNext()) {
            r next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.aqy > 0) {
            as.d(this, this.aqy, i);
        }
        Iterator<r> it = this.aqF.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<z> it2 = this.aqG.iterator();
        while (it2.hasNext()) {
            z next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean Bx() {
        return getVisibility() == 0 && By();
    }

    private boolean By() {
        Iterator<z> it = this.aqG.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aqy = i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            aB(true);
        }
        super.requestDisallowInterceptTouchEvent(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        aB(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    private void aB(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
