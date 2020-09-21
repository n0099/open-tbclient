package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.editortools.noConflictPanel.widget.KPSwitchFSPanelFrameLayout;
import com.baidu.tieba.R;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class EditorDesk extends KPSwitchFSPanelFrameLayout {
    private LinkedList<h> eMT;
    private LinkedList<n> eMU;
    private n eMV;
    private boolean eMW;
    private boolean eMX;
    private EditorTools eMY;
    private Runnable eMZ;
    private int mBgColor;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorDesk(Context context, EditorTools editorTools) {
        super(context);
        this.mBgColor = R.color.cp_bg_line_h;
        this.eMV = null;
        this.eMW = true;
        this.eMX = false;
        this.eMZ = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorDesk.1
            @Override // java.lang.Runnable
            public void run() {
                if (EditorDesk.this.eMV != null) {
                    EditorDesk.this.eMV.display();
                }
            }
        };
        this.eMT = new LinkedList<>();
        this.eMU = new LinkedList<>();
        this.eMY = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(h hVar) {
        this.eMT.add(hVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(n nVar) {
        this.eMU.add(nVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void build() {
        Iterator<n> it = this.eMU.iterator();
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
            ((MoreDeskView) nVar).g(this.eMT);
            nVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.eMV = null;
        this.eMT.clear();
        this.eMU.clear();
    }

    protected void display() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.eMV != null) {
            this.eMV.hide();
        }
        this.eMV = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bsx() {
        if (this.eMV != null) {
            this.eMV.hide();
        }
        this.eMV = null;
    }

    public void bsy() {
        if (this.eMV == null) {
            setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qm(int i) {
        if (qq(i)) {
            if (bsA()) {
                this.eMW = true;
            } else {
                this.eMW = false;
            }
            boolean z = this.eMX;
            Iterator<n> it = this.eMU.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.eMX = true;
                }
                if (next.getToolId() == i) {
                    this.eMV = next;
                    if (this.eMW) {
                        next.display();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.eMW && (getContext() instanceof Activity)) {
                if (this.eMY != null) {
                    this.eMY.bsE();
                } else {
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.f.e.mX().postDelayed(this.eMZ, 250L);
            }
            display();
        }
    }

    private boolean qq(int i) {
        Iterator<n> it = this.eMU.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public void setDeskLauncherEnabled(boolean z) {
        Iterator<h> it = this.eMT.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (next != null && (next instanceof View)) {
                ((View) next).setEnabled(z);
            }
        }
    }

    public boolean u(boolean z, int i) {
        Iterator<h> it = this.eMT.iterator();
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

    public h qo(int i) {
        Iterator<h> it = this.eMT.iterator();
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
        Iterator<h> it = this.eMT.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<n> it2 = this.eMU.iterator();
        while (it2.hasNext()) {
            n next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean bsz() {
        return getVisibility() == 0 && bsA();
    }

    private boolean bsA() {
        Iterator<n> it = this.eMU.iterator();
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
