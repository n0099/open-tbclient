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
    private LinkedList<h> fuc;
    private LinkedList<n> fud;
    private n fue;
    private boolean fuf;
    private boolean fug;
    private EditorTools fuh;
    private Runnable fui;
    private int mBgColor;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorDesk(Context context, EditorTools editorTools) {
        super(context);
        this.mBgColor = R.color.CAM_X0206;
        this.fue = null;
        this.fuf = true;
        this.fug = false;
        this.fui = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorDesk.1
            @Override // java.lang.Runnable
            public void run() {
                if (EditorDesk.this.fue != null) {
                    EditorDesk.this.fue.su();
                }
            }
        };
        this.fuc = new LinkedList<>();
        this.fud = new LinkedList<>();
        this.fuh = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(h hVar) {
        this.fuc.add(hVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(n nVar) {
        this.fud.add(nVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void build() {
        Iterator<n> it = this.fud.iterator();
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
            ((MoreDeskView) nVar).g(this.fuc);
            nVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.fue = null;
        this.fuc.clear();
        this.fud.clear();
    }

    protected void su() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.fue != null) {
            this.fue.hide();
        }
        this.fue = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bCp() {
        if (this.fue != null) {
            this.fue.hide();
        }
        this.fue = null;
    }

    public void bCq() {
        if (this.fue == null) {
            setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void se(int i) {
        if (si(i)) {
            if (bCs()) {
                this.fuf = true;
            } else {
                this.fuf = false;
            }
            boolean z = this.fug;
            Iterator<n> it = this.fud.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.fug = true;
                }
                if (next.getToolId() == i) {
                    this.fue = next;
                    if (this.fuf) {
                        next.su();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.fuf && (getContext() instanceof Activity)) {
                if (this.fuh != null) {
                    this.fuh.bCw();
                } else {
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(this.fui, 250L);
            }
            su();
        }
    }

    private boolean si(int i) {
        Iterator<n> it = this.fud.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public void setDeskLauncherEnabled(boolean z) {
        Iterator<h> it = this.fuc.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (next != null && (next instanceof View)) {
                ((View) next).setEnabled(z);
            }
        }
    }

    public boolean v(boolean z, int i) {
        Iterator<h> it = this.fuc.iterator();
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

    public h sg(int i) {
        Iterator<h> it = this.fuc.iterator();
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
        Iterator<h> it = this.fuc.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<n> it2 = this.fud.iterator();
        while (it2.hasNext()) {
            n next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean bCr() {
        return getVisibility() == 0 && bCs();
    }

    private boolean bCs() {
        Iterator<n> it = this.fud.iterator();
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
