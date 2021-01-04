package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.editortools.noConflictPanel.widget.KPSwitchFSPanelFrameLayout;
import com.baidu.tieba.R;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class EditorDesk extends KPSwitchFSPanelFrameLayout {
    private LinkedList<h> fDI;
    private LinkedList<n> fDJ;
    private n fDK;
    private boolean fDL;
    private boolean fDM;
    private EditorTools fDN;
    private Runnable fDO;
    private int mBgColor;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorDesk(Context context, EditorTools editorTools) {
        super(context);
        this.mBgColor = R.color.CAM_X0206;
        this.fDK = null;
        this.fDL = true;
        this.fDM = false;
        this.fDO = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorDesk.1
            @Override // java.lang.Runnable
            public void run() {
                if (EditorDesk.this.fDK != null) {
                    EditorDesk.this.fDK.rV();
                }
            }
        };
        this.fDI = new LinkedList<>();
        this.fDJ = new LinkedList<>();
        this.fDN = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(h hVar) {
        this.fDI.add(hVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(n nVar) {
        this.fDJ.add(nVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void build() {
        Iterator<n> it = this.fDJ.iterator();
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
            ((MoreDeskView) nVar).g(this.fDI);
            nVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.fDK = null;
        this.fDI.clear();
        this.fDJ.clear();
    }

    protected void rV() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.fDK != null) {
            this.fDK.hide();
        }
        this.fDK = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bEK() {
        if (this.fDK != null) {
            this.fDK.hide();
        }
        this.fDK = null;
    }

    public void bEL() {
        if (this.fDK == null) {
            setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sq(int i) {
        if (su(i)) {
            if (bEN()) {
                this.fDL = true;
            } else {
                this.fDL = false;
            }
            boolean z = this.fDM;
            Iterator<n> it = this.fDJ.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.fDM = true;
                }
                if (next.getToolId() == i) {
                    this.fDK = next;
                    if (this.fDL) {
                        next.rV();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.fDL && (getContext() instanceof Activity)) {
                if (this.fDN != null) {
                    this.fDN.bER();
                } else {
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.f.e.mB().postDelayed(this.fDO, 250L);
            }
            rV();
        }
    }

    private boolean su(int i) {
        Iterator<n> it = this.fDJ.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public void setDeskLauncherEnabled(boolean z) {
        Iterator<h> it = this.fDI.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (next != null && (next instanceof View)) {
                ((View) next).setEnabled(z);
            }
        }
    }

    public boolean u(boolean z, int i) {
        Iterator<h> it = this.fDI.iterator();
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

    public h ss(int i) {
        Iterator<h> it = this.fDI.iterator();
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
            ao.setBackgroundColor(this, this.mBgColor, i);
        }
        Iterator<h> it = this.fDI.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<n> it2 = this.fDJ.iterator();
        while (it2.hasNext()) {
            n next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean bEM() {
        return getVisibility() == 0 && bEN();
    }

    private boolean bEN() {
        Iterator<n> it = this.fDJ.iterator();
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
