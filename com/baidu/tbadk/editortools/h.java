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
    private int aBh;
    private LinkedList<l> aBr;
    private LinkedList<s> aBs;
    private s aBt;
    private boolean aBu;
    private boolean aBv;
    private i aBw;
    private Runnable aBx;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, i iVar) {
        super(context);
        this.aBh = d.e.common_color_10255;
        this.aBt = null;
        this.aBu = true;
        this.aBv = false;
        this.aBx = new Runnable() { // from class: com.baidu.tbadk.editortools.h.1
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.aBt != null) {
                    h.this.aBt.lK();
                }
            }
        };
        this.aBr = new LinkedList<>();
        this.aBs = new LinkedList<>();
        this.aBw = iVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.aBr.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar) {
        this.aBs.add(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CW() {
        Iterator<s> it = this.aBs.iterator();
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
            ((m) sVar).i(this.aBr);
            sVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aBt = null;
        this.aBr.clear();
        this.aBs.clear();
    }

    protected void lK() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.aBt != null) {
            this.aBt.hide();
        }
        this.aBt = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eA(int i) {
        if (eD(i)) {
            if (CZ()) {
                this.aBu = true;
            } else {
                this.aBu = false;
            }
            boolean z = this.aBv;
            Iterator<s> it = this.aBs.iterator();
            while (it.hasNext()) {
                s next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.aBv = true;
                }
                if (next.getToolId() == i) {
                    this.aBt = next;
                    if (this.aBu) {
                        next.lK();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.aBu && (getContext() instanceof Activity)) {
                if (this.aBw != null) {
                    this.aBw.Dc();
                } else {
                    com.baidu.adp.lib.util.k.a(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.e.fQ().postDelayed(this.aBx, 250L);
            }
            lK();
        }
    }

    private boolean eD(int i) {
        Iterator<s> it = this.aBs.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public l eC(int i) {
        Iterator<l> it = this.aBr.iterator();
        while (it.hasNext()) {
            l next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.aBh > 0) {
            aj.e(this, this.aBh, i);
        }
        Iterator<l> it = this.aBr.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<s> it2 = this.aBs.iterator();
        while (it2.hasNext()) {
            s next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean CY() {
        return getVisibility() == 0 && CZ();
    }

    private boolean CZ() {
        Iterator<s> it = this.aBs.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aBh = i;
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
