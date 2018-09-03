package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class EditorDesk extends FrameLayout {
    private int aLU;
    private LinkedList<g> aMd;
    private LinkedList<l> aMe;
    private l aMf;
    private boolean aMg;
    private boolean aMh;
    private EditorTools aMi;
    private Runnable aMj;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorDesk(Context context, EditorTools editorTools) {
        super(context);
        this.aLU = f.d.cp_bg_line_d;
        this.aMf = null;
        this.aMg = true;
        this.aMh = false;
        this.aMj = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorDesk.1
            @Override // java.lang.Runnable
            public void run() {
                if (EditorDesk.this.aMf != null) {
                    EditorDesk.this.aMf.oC();
                }
            }
        };
        this.aMd = new LinkedList<>();
        this.aMe = new LinkedList<>();
        this.aMi = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.aMd.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.aMe.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Hu() {
        Iterator<l> it = this.aMe.iterator();
        while (it.hasNext()) {
            l next = it.next();
            if (next.getToolId() == 2) {
                b(next);
            }
            if (next instanceof View) {
                View view = (View) next;
                view.setVisibility(8);
                addView(view, -1, getContext().getResources().getDimensionPixelSize(f.e.ds460));
            }
            next.init();
        }
        invalidate();
    }

    private void b(l lVar) {
        if (lVar instanceof MoreDeskView) {
            ((MoreDeskView) lVar).j(this.aMd);
            lVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aMf = null;
        this.aMd.clear();
        this.aMe.clear();
    }

    protected void oC() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.aMf != null) {
            this.aMf.hide();
        }
        this.aMf = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eI(int i) {
        if (eM(i)) {
            if (Hx()) {
                this.aMg = true;
            } else {
                this.aMg = false;
            }
            boolean z = this.aMh;
            Iterator<l> it = this.aMe.iterator();
            while (it.hasNext()) {
                l next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.aMh = true;
                }
                if (next.getToolId() == i) {
                    this.aMf = next;
                    if (this.aMg) {
                        next.oC();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.aMg && (getContext() instanceof Activity)) {
                if (this.aMi != null) {
                    this.aMi.HB();
                } else {
                    com.baidu.adp.lib.util.l.a(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.e.in().postDelayed(this.aMj, 250L);
            }
            oC();
        }
    }

    private boolean eM(int i) {
        Iterator<l> it = this.aMe.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public g eK(int i) {
        Iterator<g> it = this.aMd.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.aLU > 0) {
            am.e(this, this.aLU, i);
        }
        Iterator<g> it = this.aMd.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<l> it2 = this.aMe.iterator();
        while (it2.hasNext()) {
            l next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean Hw() {
        return getVisibility() == 0 && Hx();
    }

    private boolean Hx() {
        Iterator<l> it = this.aMe.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.aLU = i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            aY(true);
        }
        super.requestDisallowInterceptTouchEvent(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        aY(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    private void aY(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
