package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class h extends FrameLayout {
    private int atW;
    private LinkedList<s> auf;
    private LinkedList<ab> aug;
    private ab auh;
    private boolean aui;
    private boolean auj;
    private l auk;
    private Runnable aul;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, l lVar) {
        super(context);
        this.atW = t.d.common_color_10255;
        this.auh = null;
        this.aui = true;
        this.auj = false;
        this.aul = new i(this);
        this.auf = new LinkedList<>();
        this.aug = new LinkedList<>();
        this.auk = lVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar) {
        this.auf.add(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ab abVar) {
        this.aug.add(abVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CH() {
        Iterator<ab> it = this.aug.iterator();
        while (it.hasNext()) {
            ab next = it.next();
            if (next.getToolId() == 2) {
                b(next);
            }
            if (next instanceof View) {
                View view = (View) next;
                view.setVisibility(8);
                addView(view, -1, getContext().getResources().getDimensionPixelSize(t.e.ds460));
            }
            next.init();
        }
        invalidate();
    }

    private void b(ab abVar) {
        if (abVar instanceof t) {
            ((t) abVar).h(this.auf);
            abVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.auh = null;
        this.auf.clear();
        this.aug.clear();
    }

    protected void lw() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.auh != null) {
            this.auh.hide();
        }
        this.auh = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ev(int i) {
        if (ey(i)) {
            if (CK()) {
                this.aui = true;
            } else {
                this.aui = false;
            }
            boolean z = this.auj;
            Iterator<ab> it = this.aug.iterator();
            while (it.hasNext()) {
                ab next = it.next();
                if (!z && TbadkCoreApplication.m9getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.m9getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.auj = true;
                }
                if (next.getToolId() == i) {
                    this.auh = next;
                    if (this.aui) {
                        next.lw();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.aui && (getContext() instanceof Activity)) {
                if (this.auk != null) {
                    this.auk.CO();
                } else {
                    com.baidu.adp.lib.util.k.b(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.h.h.eG().postDelayed(this.aul, 250L);
            }
            lw();
        }
    }

    private boolean ey(int i) {
        Iterator<ab> it = this.aug.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public s ex(int i) {
        Iterator<s> it = this.auf.iterator();
        while (it.hasNext()) {
            s next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.atW > 0) {
            av.e(this, this.atW, i);
        }
        Iterator<s> it = this.auf.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<ab> it2 = this.aug.iterator();
        while (it2.hasNext()) {
            ab next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean CJ() {
        return getVisibility() == 0 && CK();
    }

    private boolean CK() {
        Iterator<ab> it = this.aug.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.atW = i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            aN(true);
        }
        super.requestDisallowInterceptTouchEvent(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        aN(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    private void aN(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
