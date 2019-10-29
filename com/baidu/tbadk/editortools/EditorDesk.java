package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class EditorDesk extends FrameLayout {
    private int cEW;
    private LinkedList<g> cFf;
    private LinkedList<l> cFg;
    private l cFh;
    private boolean cFi;
    private boolean cFj;
    private EditorTools cFk;
    private Runnable cFl;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorDesk(Context context, EditorTools editorTools) {
        super(context);
        this.cEW = R.color.cp_bg_line_h;
        this.cFh = null;
        this.cFi = true;
        this.cFj = false;
        this.cFl = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorDesk.1
            @Override // java.lang.Runnable
            public void run() {
                if (EditorDesk.this.cFh != null) {
                    EditorDesk.this.cFh.le();
                }
            }
        };
        this.cFf = new LinkedList<>();
        this.cFg = new LinkedList<>();
        this.cFk = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.cFf.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.cFg.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void build() {
        Iterator<l> it = this.cFg.iterator();
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
            ((MoreDeskView) lVar).g(this.cFf);
            lVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.cFh = null;
        this.cFf.clear();
        this.cFg.clear();
    }

    protected void le() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.cFh != null) {
            this.cFh.hide();
        }
        this.cFh = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void jG(int i) {
        if (jK(i)) {
            if (auc()) {
                this.cFi = true;
            } else {
                this.cFi = false;
            }
            boolean z = this.cFj;
            Iterator<l> it = this.cFg.iterator();
            while (it.hasNext()) {
                l next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.cFj = true;
                }
                if (next.getToolId() == i) {
                    this.cFh = next;
                    if (this.cFi) {
                        next.le();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.cFi && (getContext() instanceof Activity)) {
                if (this.cFk != null) {
                    this.cFk.aug();
                } else {
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.e.fZ().postDelayed(this.cFl, 250L);
            }
            le();
        }
    }

    private boolean jK(int i) {
        Iterator<l> it = this.cFg.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public g jI(int i) {
        Iterator<g> it = this.cFf.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.cEW > 0) {
            am.setBackgroundColor(this, this.cEW, i);
        }
        Iterator<g> it = this.cFf.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<l> it2 = this.cFg.iterator();
        while (it2.hasNext()) {
            l next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean aub() {
        return getVisibility() == 0 && auc();
    }

    private boolean auc() {
        Iterator<l> it = this.cFg.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.cEW = i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            requestParentInterceptTouchEvent(true);
        }
        super.requestDisallowInterceptTouchEvent(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestParentInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    private void requestParentInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
