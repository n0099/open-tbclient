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
    private LinkedList<g> cqF;
    private LinkedList<l> cqG;
    private l cqH;
    private boolean cqI;
    private boolean cqJ;
    private EditorTools cqK;
    private Runnable cqL;
    private int cqw;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorDesk(Context context, EditorTools editorTools) {
        super(context);
        this.cqw = R.color.cp_bg_line_d;
        this.cqH = null;
        this.cqI = true;
        this.cqJ = false;
        this.cqL = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorDesk.1
            @Override // java.lang.Runnable
            public void run() {
                if (EditorDesk.this.cqH != null) {
                    EditorDesk.this.cqH.pO();
                }
            }
        };
        this.cqF = new LinkedList<>();
        this.cqG = new LinkedList<>();
        this.cqK = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.cqF.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.cqG.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aqT() {
        Iterator<l> it = this.cqG.iterator();
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
            ((MoreDeskView) lVar).k(this.cqF);
            lVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.cqH = null;
        this.cqF.clear();
        this.cqG.clear();
    }

    protected void pO() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.cqH != null) {
            this.cqH.hide();
        }
        this.cqH = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ke(int i) {
        if (ki(i)) {
            if (aqW()) {
                this.cqI = true;
            } else {
                this.cqI = false;
            }
            boolean z = this.cqJ;
            Iterator<l> it = this.cqG.iterator();
            while (it.hasNext()) {
                l next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.cqJ = true;
                }
                if (next.getToolId() == i) {
                    this.cqH = next;
                    if (this.cqI) {
                        next.pO();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.cqI && (getContext() instanceof Activity)) {
                if (this.cqK != null) {
                    this.cqK.ara();
                } else {
                    com.baidu.adp.lib.util.l.b(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.e.iB().postDelayed(this.cqL, 250L);
            }
            pO();
        }
    }

    private boolean ki(int i) {
        Iterator<l> it = this.cqG.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public g kg(int i) {
        Iterator<g> it = this.cqF.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.cqw > 0) {
            al.h(this, this.cqw, i);
        }
        Iterator<g> it = this.cqF.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<l> it2 = this.cqG.iterator();
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
        Iterator<l> it = this.cqG.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.cqw = i;
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
