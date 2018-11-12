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
    private LinkedList<g> aUM;
    private LinkedList<l> aUN;
    private l aUO;
    private boolean aUP;
    private boolean aUQ;
    private EditorTools aUR;
    private Runnable aUS;
    private int mBgColor;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorDesk(Context context, EditorTools editorTools) {
        super(context);
        this.mBgColor = e.d.cp_bg_line_d;
        this.aUO = null;
        this.aUP = true;
        this.aUQ = false;
        this.aUS = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorDesk.1
            @Override // java.lang.Runnable
            public void run() {
                if (EditorDesk.this.aUO != null) {
                    EditorDesk.this.aUO.pO();
                }
            }
        };
        this.aUM = new LinkedList<>();
        this.aUN = new LinkedList<>();
        this.aUR = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.aUM.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.aUN.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void KU() {
        Iterator<l> it = this.aUN.iterator();
        while (it.hasNext()) {
            l next = it.next();
            if (next.getToolId() == 2) {
                b(next);
            }
            if (next instanceof View) {
                View view = (View) next;
                view.setVisibility(8);
                addView(view, -1, getContext().getResources().getDimensionPixelSize(e.C0200e.ds460));
            }
            next.init();
        }
        invalidate();
    }

    private void b(l lVar) {
        if (lVar instanceof MoreDeskView) {
            ((MoreDeskView) lVar).j(this.aUM);
            lVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aUO = null;
        this.aUM.clear();
        this.aUN.clear();
    }

    protected void pO() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.aUO != null) {
            this.aUO.hide();
        }
        this.aUO = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fr(int i) {
        if (fv(i)) {
            if (KX()) {
                this.aUP = true;
            } else {
                this.aUP = false;
            }
            boolean z = this.aUQ;
            Iterator<l> it = this.aUN.iterator();
            while (it.hasNext()) {
                l next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.aUQ = true;
                }
                if (next.getToolId() == i) {
                    this.aUO = next;
                    if (this.aUP) {
                        next.pO();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.aUP && (getContext() instanceof Activity)) {
                if (this.aUR != null) {
                    this.aUR.Lb();
                } else {
                    com.baidu.adp.lib.util.l.b(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.e.jG().postDelayed(this.aUS, 250L);
            }
            pO();
        }
    }

    private boolean fv(int i) {
        Iterator<l> it = this.aUN.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public g ft(int i) {
        Iterator<g> it = this.aUM.iterator();
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
        Iterator<g> it = this.aUM.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<l> it2 = this.aUN.iterator();
        while (it2.hasNext()) {
            l next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean KW() {
        return getVisibility() == 0 && KX();
    }

    private boolean KX() {
        Iterator<l> it = this.aUN.iterator();
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
            bL(true);
        }
        super.requestDisallowInterceptTouchEvent(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        bL(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    private void bL(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
