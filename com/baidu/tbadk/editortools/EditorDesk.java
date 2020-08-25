package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class EditorDesk extends FrameLayout {
    private n eKA;
    private boolean eKB;
    private boolean eKC;
    private EditorTools eKD;
    private Runnable eKE;
    private LinkedList<h> eKy;
    private LinkedList<n> eKz;
    private int mBgColor;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorDesk(Context context, EditorTools editorTools) {
        super(context);
        this.mBgColor = R.color.cp_bg_line_h;
        this.eKA = null;
        this.eKB = true;
        this.eKC = false;
        this.eKE = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorDesk.1
            @Override // java.lang.Runnable
            public void run() {
                if (EditorDesk.this.eKA != null) {
                    EditorDesk.this.eKA.display();
                }
            }
        };
        this.eKy = new LinkedList<>();
        this.eKz = new LinkedList<>();
        this.eKD = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(h hVar) {
        this.eKy.add(hVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(n nVar) {
        this.eKz.add(nVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void build() {
        Iterator<n> it = this.eKz.iterator();
        while (it.hasNext()) {
            n next = it.next();
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

    private void b(n nVar) {
        if (nVar instanceof MoreDeskView) {
            ((MoreDeskView) nVar).g(this.eKy);
            nVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.eKA = null;
        this.eKy.clear();
        this.eKz.clear();
    }

    protected void display() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.eKA != null) {
            this.eKA.hide();
        }
        this.eKA = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pZ(int i) {
        if (qd(i)) {
            if (bry()) {
                this.eKB = true;
            } else {
                this.eKB = false;
            }
            boolean z = this.eKC;
            Iterator<n> it = this.eKz.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.eKC = true;
                }
                if (next.getToolId() == i) {
                    this.eKA = next;
                    if (this.eKB) {
                        next.display();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.eKB && (getContext() instanceof Activity)) {
                if (this.eKD != null) {
                    this.eKD.brC();
                } else {
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.f.e.mS().postDelayed(this.eKE, 250L);
            }
            display();
        }
    }

    private boolean qd(int i) {
        Iterator<n> it = this.eKz.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public void setDeskLauncherEnabled(boolean z) {
        Iterator<h> it = this.eKy.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (next != null && (next instanceof View)) {
                ((View) next).setEnabled(z);
            }
        }
    }

    public boolean u(boolean z, int i) {
        Iterator<h> it = this.eKy.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (next instanceof View) {
                View view = (View) next;
                if (next.getToolId() == i) {
                    view.setEnabled(z);
                    return true;
                }
            }
        }
        return false;
    }

    public h qb(int i) {
        Iterator<h> it = this.eKy.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.mBgColor > 0) {
            ap.setBackgroundColor(this, this.mBgColor, i);
        }
        Iterator<h> it = this.eKy.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<n> it2 = this.eKz.iterator();
        while (it2.hasNext()) {
            n next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean brx() {
        return getVisibility() == 0 && bry();
    }

    private boolean bry() {
        Iterator<n> it = this.eKz.iterator();
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
