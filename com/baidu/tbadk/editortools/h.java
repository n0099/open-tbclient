package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class h extends FrameLayout {
    private int aBV;
    private LinkedList<l> aCf;
    private LinkedList<s> aCg;
    private s aCh;
    private boolean aCi;
    private boolean aCj;
    private i aCk;
    private Runnable aCl;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, i iVar) {
        super(context);
        this.aBV = d.e.common_color_10255;
        this.aCh = null;
        this.aCi = true;
        this.aCj = false;
        this.aCl = new Runnable() { // from class: com.baidu.tbadk.editortools.h.1
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.aCh != null) {
                    h.this.aCh.lS();
                }
            }
        };
        this.aCf = new LinkedList<>();
        this.aCg = new LinkedList<>();
        this.aCk = iVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.aCf.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar) {
        this.aCg.add(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Db() {
        Iterator<s> it = this.aCg.iterator();
        while (it.hasNext()) {
            s next = it.next();
            if (next.getToolId() == 2) {
                b(next);
            }
            if (next instanceof View) {
                View view = (View) next;
                view.setVisibility(8);
                addView(view, -1, getContext().getResources().getDimensionPixelSize(d.f.ds460));
            }
            next.init();
        }
        invalidate();
    }

    private void b(s sVar) {
        if (sVar instanceof m) {
            ((m) sVar).i(this.aCf);
            sVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aCh = null;
        this.aCf.clear();
        this.aCg.clear();
    }

    protected void lS() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.aCh != null) {
            this.aCh.hide();
        }
        this.aCh = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eA(int i) {
        if (eD(i)) {
            if (De()) {
                this.aCi = true;
            } else {
                this.aCi = false;
            }
            boolean z = this.aCj;
            Iterator<s> it = this.aCg.iterator();
            while (it.hasNext()) {
                s next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.aCj = true;
                }
                if (next.getToolId() == i) {
                    this.aCh = next;
                    if (this.aCi) {
                        next.lS();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.aCi && (getContext() instanceof Activity)) {
                if (this.aCk != null) {
                    this.aCk.Dh();
                } else {
                    com.baidu.adp.lib.util.k.b(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.e.ga().postDelayed(this.aCl, 250L);
            }
            lS();
        }
    }

    private boolean eD(int i) {
        Iterator<s> it = this.aCg.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public l eC(int i) {
        Iterator<l> it = this.aCf.iterator();
        while (it.hasNext()) {
            l next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.aBV > 0) {
            ai.e(this, this.aBV, i);
        }
        Iterator<l> it = this.aCf.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<s> it2 = this.aCg.iterator();
        while (it2.hasNext()) {
            s next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean Dd() {
        return getVisibility() == 0 && De();
    }

    private boolean De() {
        Iterator<s> it = this.aCg.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aBV = i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            aS(true);
        }
        super.requestDisallowInterceptTouchEvent(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        aS(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    private void aS(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
