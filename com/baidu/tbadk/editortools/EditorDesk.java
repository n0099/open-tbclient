package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class EditorDesk extends FrameLayout {
    private LinkedList<g> eAa;
    private LinkedList<m> eAb;
    private m eAc;
    private boolean eAd;
    private boolean eAe;
    private EditorTools eAf;
    private Runnable eAg;
    private int mBgColor;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorDesk(Context context, EditorTools editorTools) {
        super(context);
        this.mBgColor = R.color.cp_bg_line_h;
        this.eAc = null;
        this.eAd = true;
        this.eAe = false;
        this.eAg = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorDesk.1
            @Override // java.lang.Runnable
            public void run() {
                if (EditorDesk.this.eAc != null) {
                    EditorDesk.this.eAc.display();
                }
            }
        };
        this.eAa = new LinkedList<>();
        this.eAb = new LinkedList<>();
        this.eAf = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.eAa.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(m mVar) {
        this.eAb.add(mVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void build() {
        Iterator<m> it = this.eAb.iterator();
        while (it.hasNext()) {
            m next = it.next();
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

    private void b(m mVar) {
        if (mVar instanceof MoreDeskView) {
            ((MoreDeskView) mVar).g(this.eAa);
            mVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.eAc = null;
        this.eAa.clear();
        this.eAb.clear();
    }

    protected void display() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.eAc != null) {
            this.eAc.hide();
        }
        this.eAc = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nO(int i) {
        if (nS(i)) {
            if (biM()) {
                this.eAd = true;
            } else {
                this.eAd = false;
            }
            boolean z = this.eAe;
            Iterator<m> it = this.eAb.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.eAe = true;
                }
                if (next.getToolId() == i) {
                    this.eAc = next;
                    if (this.eAd) {
                        next.display();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.eAd && (getContext() instanceof Activity)) {
                if (this.eAf != null) {
                    this.eAf.biQ();
                } else {
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.f.e.lt().postDelayed(this.eAg, 250L);
            }
            display();
        }
    }

    private boolean nS(int i) {
        Iterator<m> it = this.eAb.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public void setDeskLauncherEnabled(boolean z) {
        Iterator<g> it = this.eAa.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next != null && (next instanceof View)) {
                ((View) next).setEnabled(z);
            }
        }
    }

    public boolean u(boolean z, int i) {
        Iterator<g> it = this.eAa.iterator();
        while (it.hasNext()) {
            g next = it.next();
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

    public g nQ(int i) {
        Iterator<g> it = this.eAa.iterator();
        while (it.hasNext()) {
            g next = it.next();
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
        Iterator<g> it = this.eAa.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<m> it2 = this.eAb.iterator();
        while (it2.hasNext()) {
            m next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean biL() {
        return getVisibility() == 0 && biM();
    }

    private boolean biM() {
        Iterator<m> it = this.eAb.iterator();
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
