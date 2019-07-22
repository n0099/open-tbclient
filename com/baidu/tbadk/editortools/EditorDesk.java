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
    private int crL;
    private LinkedList<g> crU;
    private LinkedList<l> crV;
    private l crW;
    private boolean crX;
    private boolean crY;
    private EditorTools crZ;
    private Runnable csa;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorDesk(Context context, EditorTools editorTools) {
        super(context);
        this.crL = R.color.cp_bg_line_d;
        this.crW = null;
        this.crX = true;
        this.crY = false;
        this.csa = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorDesk.1
            @Override // java.lang.Runnable
            public void run() {
                if (EditorDesk.this.crW != null) {
                    EditorDesk.this.crW.qk();
                }
            }
        };
        this.crU = new LinkedList<>();
        this.crV = new LinkedList<>();
        this.crZ = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.crU.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.crV.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void arZ() {
        Iterator<l> it = this.crV.iterator();
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
            ((MoreDeskView) lVar).k(this.crU);
            lVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.crW = null;
        this.crU.clear();
        this.crV.clear();
    }

    protected void qk() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.crW != null) {
            this.crW.hide();
        }
        this.crW = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kk(int i) {
        if (ko(i)) {
            if (asc()) {
                this.crX = true;
            } else {
                this.crX = false;
            }
            boolean z = this.crY;
            Iterator<l> it = this.crV.iterator();
            while (it.hasNext()) {
                l next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.crY = true;
                }
                if (next.getToolId() == i) {
                    this.crW = next;
                    if (this.crX) {
                        next.qk();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.crX && (getContext() instanceof Activity)) {
                if (this.crZ != null) {
                    this.crZ.asg();
                } else {
                    com.baidu.adp.lib.util.l.b(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.e.iK().postDelayed(this.csa, 250L);
            }
            qk();
        }
    }

    private boolean ko(int i) {
        Iterator<l> it = this.crV.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public g km(int i) {
        Iterator<g> it = this.crU.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.crL > 0) {
            am.h(this, this.crL, i);
        }
        Iterator<g> it = this.crU.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<l> it2 = this.crV.iterator();
        while (it2.hasNext()) {
            l next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean asb() {
        return getVisibility() == 0 && asc();
    }

    private boolean asc() {
        Iterator<l> it = this.crV.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.crL = i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            ex(true);
        }
        super.requestDisallowInterceptTouchEvent(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ex(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    private void ex(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
