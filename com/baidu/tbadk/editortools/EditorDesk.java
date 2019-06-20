package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class EditorDesk extends FrameLayout {
    private LinkedList<g> cqG;
    private LinkedList<l> cqH;
    private l cqI;
    private boolean cqJ;
    private boolean cqK;
    private EditorTools cqL;
    private Runnable cqM;
    private int cqx;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorDesk(Context context, EditorTools editorTools) {
        super(context);
        this.cqx = R.color.cp_bg_line_d;
        this.cqI = null;
        this.cqJ = true;
        this.cqK = false;
        this.cqM = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorDesk.1
            @Override // java.lang.Runnable
            public void run() {
                if (EditorDesk.this.cqI != null) {
                    EditorDesk.this.cqI.pO();
                }
            }
        };
        this.cqG = new LinkedList<>();
        this.cqH = new LinkedList<>();
        this.cqL = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.cqG.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.cqH.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aqT() {
        Iterator<l> it = this.cqH.iterator();
        while (it.hasNext()) {
            l next = it.next();
            if (next.getToolId() == 2) {
                b(next);
            }
            if (next instanceof View) {
                View view = (View) next;
                view.setVisibility(8);
                addView(view, -1, getContext().getResources().getDimensionPixelSize(R.dimen.ds460));
            }
            next.init();
        }
        invalidate();
    }

    private void b(l lVar) {
        if (lVar instanceof MoreDeskView) {
            ((MoreDeskView) lVar).k(this.cqG);
            lVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.cqI = null;
        this.cqG.clear();
        this.cqH.clear();
    }

    protected void pO() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.cqI != null) {
            this.cqI.hide();
        }
        this.cqI = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ke(int i) {
        if (ki(i)) {
            if (aqW()) {
                this.cqJ = true;
            } else {
                this.cqJ = false;
            }
            boolean z = this.cqK;
            Iterator<l> it = this.cqH.iterator();
            while (it.hasNext()) {
                l next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.cqK = true;
                }
                if (next.getToolId() == i) {
                    this.cqI = next;
                    if (this.cqJ) {
                        next.pO();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.cqJ && (getContext() instanceof Activity)) {
                if (this.cqL != null) {
                    this.cqL.ara();
                } else {
                    com.baidu.adp.lib.util.l.b(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.e.iB().postDelayed(this.cqM, 250L);
            }
            pO();
        }
    }

    private boolean ki(int i) {
        Iterator<l> it = this.cqH.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public g kg(int i) {
        Iterator<g> it = this.cqG.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.cqx > 0) {
            al.h(this, this.cqx, i);
        }
        Iterator<g> it = this.cqG.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<l> it2 = this.cqH.iterator();
        while (it2.hasNext()) {
            l next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean aqV() {
        return getVisibility() == 0 && aqW();
    }

    private boolean aqW() {
        Iterator<l> it = this.cqH.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.cqx = i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            et(true);
        }
        super.requestDisallowInterceptTouchEvent(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        et(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    private void et(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
