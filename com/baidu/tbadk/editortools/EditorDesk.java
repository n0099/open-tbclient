package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class EditorDesk extends FrameLayout {
    private LinkedList<g> aTW;
    private LinkedList<l> aTX;
    private l aTY;
    private boolean aTZ;
    private boolean aUa;
    private EditorTools aUb;
    private Runnable aUc;
    private int mBgColor;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorDesk(Context context, EditorTools editorTools) {
        super(context);
        this.mBgColor = e.d.cp_bg_line_d;
        this.aTY = null;
        this.aTZ = true;
        this.aUa = false;
        this.aUc = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorDesk.1
            @Override // java.lang.Runnable
            public void run() {
                if (EditorDesk.this.aTY != null) {
                    EditorDesk.this.aTY.pQ();
                }
            }
        };
        this.aTW = new LinkedList<>();
        this.aTX = new LinkedList<>();
        this.aUb = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.aTW.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.aTX.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void KI() {
        Iterator<l> it = this.aTX.iterator();
        while (it.hasNext()) {
            l next = it.next();
            if (next.getToolId() == 2) {
                b(next);
            }
            if (next instanceof View) {
                View view = (View) next;
                view.setVisibility(8);
                addView(view, -1, getContext().getResources().getDimensionPixelSize(e.C0175e.ds460));
            }
            next.init();
        }
        invalidate();
    }

    private void b(l lVar) {
        if (lVar instanceof MoreDeskView) {
            ((MoreDeskView) lVar).j(this.aTW);
            lVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aTY = null;
        this.aTW.clear();
        this.aTX.clear();
    }

    protected void pQ() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.aTY != null) {
            this.aTY.hide();
        }
        this.aTY = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fd(int i) {
        if (fh(i)) {
            if (KL()) {
                this.aTZ = true;
            } else {
                this.aTZ = false;
            }
            boolean z = this.aUa;
            Iterator<l> it = this.aTX.iterator();
            while (it.hasNext()) {
                l next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.aUa = true;
                }
                if (next.getToolId() == i) {
                    this.aTY = next;
                    if (this.aTZ) {
                        next.pQ();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.aTZ && (getContext() instanceof Activity)) {
                if (this.aUb != null) {
                    this.aUb.KP();
                } else {
                    com.baidu.adp.lib.util.l.a(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.e.jI().postDelayed(this.aUc, 250L);
            }
            pQ();
        }
    }

    private boolean fh(int i) {
        Iterator<l> it = this.aTX.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public g ff(int i) {
        Iterator<g> it = this.aTW.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.mBgColor > 0) {
            al.e(this, this.mBgColor, i);
        }
        Iterator<g> it = this.aTW.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<l> it2 = this.aTX.iterator();
        while (it2.hasNext()) {
            l next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean KK() {
        return getVisibility() == 0 && KL();
    }

    private boolean KL() {
        Iterator<l> it = this.aTX.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.mBgColor = i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            bu(true);
        }
        super.requestDisallowInterceptTouchEvent(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        bu(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    private void bu(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
