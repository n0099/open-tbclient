package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class EditorDesk extends FrameLayout {
    private LinkedList<g> aLk;
    private LinkedList<l> aLl;
    private l aLm;
    private boolean aLn;
    private boolean aLo;
    private EditorTools aLp;
    private Runnable aLq;
    private int mBgColor;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorDesk(Context context, EditorTools editorTools) {
        super(context);
        this.mBgColor = d.C0141d.cp_bg_line_d;
        this.aLm = null;
        this.aLn = true;
        this.aLo = false;
        this.aLq = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorDesk.1
            @Override // java.lang.Runnable
            public void run() {
                if (EditorDesk.this.aLm != null) {
                    EditorDesk.this.aLm.oD();
                }
            }
        };
        this.aLk = new LinkedList<>();
        this.aLl = new LinkedList<>();
        this.aLp = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.aLk.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.aLl.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Hh() {
        Iterator<l> it = this.aLl.iterator();
        while (it.hasNext()) {
            l next = it.next();
            if (next.getToolId() == 2) {
                b(next);
            }
            if (next instanceof View) {
                View view = (View) next;
                view.setVisibility(8);
                addView(view, -1, getContext().getResources().getDimensionPixelSize(d.e.ds460));
            }
            next.init();
        }
        invalidate();
    }

    private void b(l lVar) {
        if (lVar instanceof MoreDeskView) {
            ((MoreDeskView) lVar).j(this.aLk);
            lVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aLm = null;
        this.aLk.clear();
        this.aLl.clear();
    }

    protected void oD() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.aLm != null) {
            this.aLm.hide();
        }
        this.aLm = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eH(int i) {
        if (eL(i)) {
            if (Hk()) {
                this.aLn = true;
            } else {
                this.aLn = false;
            }
            boolean z = this.aLo;
            Iterator<l> it = this.aLl.iterator();
            while (it.hasNext()) {
                l next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.aLo = true;
                }
                if (next.getToolId() == i) {
                    this.aLm = next;
                    if (this.aLn) {
                        next.oD();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.aLn && (getContext() instanceof Activity)) {
                if (this.aLp != null) {
                    this.aLp.Ho();
                } else {
                    com.baidu.adp.lib.util.l.b(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.e.im().postDelayed(this.aLq, 250L);
            }
            oD();
        }
    }

    private boolean eL(int i) {
        Iterator<l> it = this.aLl.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public g eJ(int i) {
        Iterator<g> it = this.aLk.iterator();
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
        Iterator<g> it = this.aLk.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<l> it2 = this.aLl.iterator();
        while (it2.hasNext()) {
            l next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean Hj() {
        return getVisibility() == 0 && Hk();
    }

    private boolean Hk() {
        Iterator<l> it = this.aLl.iterator();
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
            aW(true);
        }
        super.requestDisallowInterceptTouchEvent(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        aW(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    private void aW(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
