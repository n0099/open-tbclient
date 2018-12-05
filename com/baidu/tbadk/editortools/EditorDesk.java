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
    private LinkedList<g> aYj;
    private LinkedList<l> aYk;
    private l aYl;
    private boolean aYm;
    private boolean aYn;
    private EditorTools aYo;
    private Runnable aYp;
    private int mBgColor;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorDesk(Context context, EditorTools editorTools) {
        super(context);
        this.mBgColor = e.d.cp_bg_line_d;
        this.aYl = null;
        this.aYm = true;
        this.aYn = false;
        this.aYp = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorDesk.1
            @Override // java.lang.Runnable
            public void run() {
                if (EditorDesk.this.aYl != null) {
                    EditorDesk.this.aYl.pN();
                }
            }
        };
        this.aYj = new LinkedList<>();
        this.aYk = new LinkedList<>();
        this.aYo = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.aYj.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.aYk.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void LY() {
        Iterator<l> it = this.aYk.iterator();
        while (it.hasNext()) {
            l next = it.next();
            if (next.getToolId() == 2) {
                b(next);
            }
            if (next instanceof View) {
                View view = (View) next;
                view.setVisibility(8);
                addView(view, -1, getContext().getResources().getDimensionPixelSize(e.C0210e.ds460));
            }
            next.init();
        }
        invalidate();
    }

    private void b(l lVar) {
        if (lVar instanceof MoreDeskView) {
            ((MoreDeskView) lVar).k(this.aYj);
            lVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aYl = null;
        this.aYj.clear();
        this.aYk.clear();
    }

    protected void pN() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.aYl != null) {
            this.aYl.hide();
        }
        this.aYl = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fF(int i) {
        if (fJ(i)) {
            if (Mb()) {
                this.aYm = true;
            } else {
                this.aYm = false;
            }
            boolean z = this.aYn;
            Iterator<l> it = this.aYk.iterator();
            while (it.hasNext()) {
                l next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.aYn = true;
                }
                if (next.getToolId() == i) {
                    this.aYl = next;
                    if (this.aYm) {
                        next.pN();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.aYm && (getContext() instanceof Activity)) {
                if (this.aYo != null) {
                    this.aYo.Mf();
                } else {
                    com.baidu.adp.lib.util.l.b(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.e.jG().postDelayed(this.aYp, 250L);
            }
            pN();
        }
    }

    private boolean fJ(int i) {
        Iterator<l> it = this.aYk.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public g fH(int i) {
        Iterator<g> it = this.aYj.iterator();
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
        Iterator<g> it = this.aYj.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<l> it2 = this.aYk.iterator();
        while (it2.hasNext()) {
            l next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean Ma() {
        return getVisibility() == 0 && Mb();
    }

    private boolean Mb() {
        Iterator<l> it = this.aYk.iterator();
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
            bM(true);
        }
        super.requestDisallowInterceptTouchEvent(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        bM(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    private void bM(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
