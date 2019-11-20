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
    private int cEf;
    private LinkedList<g> cEo;
    private LinkedList<l> cEp;
    private l cEq;
    private boolean cEr;
    private boolean cEs;
    private EditorTools cEt;
    private Runnable cEu;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorDesk(Context context, EditorTools editorTools) {
        super(context);
        this.cEf = R.color.cp_bg_line_h;
        this.cEq = null;
        this.cEr = true;
        this.cEs = false;
        this.cEu = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorDesk.1
            @Override // java.lang.Runnable
            public void run() {
                if (EditorDesk.this.cEq != null) {
                    EditorDesk.this.cEq.le();
                }
            }
        };
        this.cEo = new LinkedList<>();
        this.cEp = new LinkedList<>();
        this.cEt = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.cEo.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.cEp.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void build() {
        Iterator<l> it = this.cEp.iterator();
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
            ((MoreDeskView) lVar).g(this.cEo);
            lVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.cEq = null;
        this.cEo.clear();
        this.cEp.clear();
    }

    protected void le() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.cEq != null) {
            this.cEq.hide();
        }
        this.cEq = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void jF(int i) {
        if (jJ(i)) {
            if (aua()) {
                this.cEr = true;
            } else {
                this.cEr = false;
            }
            boolean z = this.cEs;
            Iterator<l> it = this.cEp.iterator();
            while (it.hasNext()) {
                l next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.cEs = true;
                }
                if (next.getToolId() == i) {
                    this.cEq = next;
                    if (this.cEr) {
                        next.le();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.cEr && (getContext() instanceof Activity)) {
                if (this.cEt != null) {
                    this.cEt.aue();
                } else {
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.e.fZ().postDelayed(this.cEu, 250L);
            }
            le();
        }
    }

    private boolean jJ(int i) {
        Iterator<l> it = this.cEp.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public g jH(int i) {
        Iterator<g> it = this.cEo.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.cEf > 0) {
            am.setBackgroundColor(this, this.cEf, i);
        }
        Iterator<g> it = this.cEo.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<l> it2 = this.cEp.iterator();
        while (it2.hasNext()) {
            l next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean atZ() {
        return getVisibility() == 0 && aua();
    }

    private boolean aua() {
        Iterator<l> it = this.cEp.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.cEf = i;
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
