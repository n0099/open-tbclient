package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class EditorDesk extends FrameLayout {
    private LinkedList<g> aCN;
    private LinkedList<l> aCO;
    private l aCP;
    private boolean aCQ;
    private boolean aCR;
    private EditorTools aCS;
    private Runnable aCT;
    private int mBgColor;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorDesk(Context context, EditorTools editorTools) {
        super(context);
        this.mBgColor = d.C0126d.cp_bg_line_d;
        this.aCP = null;
        this.aCQ = true;
        this.aCR = false;
        this.aCT = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorDesk.1
            @Override // java.lang.Runnable
            public void run() {
                if (EditorDesk.this.aCP != null) {
                    EditorDesk.this.aCP.lN();
                }
            }
        };
        this.aCN = new LinkedList<>();
        this.aCO = new LinkedList<>();
        this.aCS = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.aCN.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.aCO.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void DG() {
        Iterator<l> it = this.aCO.iterator();
        while (it.hasNext()) {
            l next = it.next();
            if (next.getToolId() == 2) {
                b(next);
            }
            if (next instanceof View) {
                View view2 = (View) next;
                view2.setVisibility(8);
                addView(view2, -1, getContext().getResources().getDimensionPixelSize(d.e.ds460));
            }
            next.init();
        }
        invalidate();
    }

    private void b(l lVar) {
        if (lVar instanceof MoreDeskView) {
            ((MoreDeskView) lVar).j(this.aCN);
            lVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aCP = null;
        this.aCN.clear();
        this.aCO.clear();
    }

    protected void lN() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.aCP != null) {
            this.aCP.hide();
        }
        this.aCP = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eC(int i) {
        if (eG(i)) {
            if (DJ()) {
                this.aCQ = true;
            } else {
                this.aCQ = false;
            }
            boolean z = this.aCR;
            Iterator<l> it = this.aCO.iterator();
            while (it.hasNext()) {
                l next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view2 = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view2.setLayoutParams(layoutParams);
                    this.aCR = true;
                }
                if (next.getToolId() == i) {
                    this.aCP = next;
                    if (this.aCQ) {
                        next.lN();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.aCQ && (getContext() instanceof Activity)) {
                if (this.aCS != null) {
                    this.aCS.DN();
                } else {
                    com.baidu.adp.lib.util.l.b(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.e.fw().postDelayed(this.aCT, 250L);
            }
            lN();
        }
    }

    private boolean eG(int i) {
        Iterator<l> it = this.aCO.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public g eE(int i) {
        Iterator<g> it = this.aCN.iterator();
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
            ak.e(this, this.mBgColor, i);
        }
        Iterator<g> it = this.aCN.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<l> it2 = this.aCO.iterator();
        while (it2.hasNext()) {
            l next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean DI() {
        return getVisibility() == 0 && DJ();
    }

    private boolean DJ() {
        Iterator<l> it = this.aCO.iterator();
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
