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
    private LinkedList<h> fnq;
    private LinkedList<n> fnr;
    private n fns;
    private boolean fnt;
    private boolean fnu;
    private EditorTools fnv;
    private Runnable fnw;
    private int mBgColor;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorDesk(Context context, EditorTools editorTools) {
        super(context);
        this.mBgColor = R.color.cp_bg_line_h;
        this.fns = null;
        this.fnt = true;
        this.fnu = false;
        this.fnw = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorDesk.1
            @Override // java.lang.Runnable
            public void run() {
                if (EditorDesk.this.fns != null) {
                    EditorDesk.this.fns.display();
                }
            }
        };
        this.fnq = new LinkedList<>();
        this.fnr = new LinkedList<>();
        this.fnv = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(h hVar) {
        this.fnq.add(hVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(n nVar) {
        this.fnr.add(nVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void build() {
        Iterator<n> it = this.fnr.iterator();
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
            ((MoreDeskView) nVar).g(this.fnq);
            nVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.fns = null;
        this.fnq.clear();
        this.fnr.clear();
    }

    protected void display() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.fns != null) {
            this.fns.hide();
        }
        this.fns = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bzz() {
        if (this.fns != null) {
            this.fns.hide();
        }
        this.fns = null;
    }

    public void bzA() {
        if (this.fns == null) {
            setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rf(int i) {
        if (rj(i)) {
            if (bzC()) {
                this.fnt = true;
            } else {
                this.fnt = false;
            }
            boolean z = this.fnu;
            Iterator<n> it = this.fnr.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.fnu = true;
                }
                if (next.getToolId() == i) {
                    this.fns = next;
                    if (this.fnt) {
                        next.display();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.fnt && (getContext() instanceof Activity)) {
                if (this.fnv != null) {
                    this.fnv.bzG();
                } else {
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(this.fnw, 250L);
            }
            display();
        }
    }

    private boolean rj(int i) {
        Iterator<n> it = this.fnr.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public void setDeskLauncherEnabled(boolean z) {
        Iterator<h> it = this.fnq.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (next != null && (next instanceof View)) {
                ((View) next).setEnabled(z);
            }
        }
    }

    public boolean v(boolean z, int i) {
        Iterator<h> it = this.fnq.iterator();
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

    public h rh(int i) {
        Iterator<h> it = this.fnq.iterator();
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
        Iterator<h> it = this.fnq.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<n> it2 = this.fnr.iterator();
        while (it2.hasNext()) {
            n next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean bzB() {
        return getVisibility() == 0 && bzC();
    }

    private boolean bzC() {
        Iterator<n> it = this.fnr.iterator();
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
