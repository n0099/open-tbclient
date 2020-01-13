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
    private Runnable dsA;
    private LinkedList<g> dsu;
    private LinkedList<m> dsv;
    private m dsw;
    private boolean dsx;
    private boolean dsy;
    private EditorTools dsz;
    private int mBgColor;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorDesk(Context context, EditorTools editorTools) {
        super(context);
        this.mBgColor = R.color.cp_bg_line_h;
        this.dsw = null;
        this.dsx = true;
        this.dsy = false;
        this.dsA = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorDesk.1
            @Override // java.lang.Runnable
            public void run() {
                if (EditorDesk.this.dsw != null) {
                    EditorDesk.this.dsw.display();
                }
            }
        };
        this.dsu = new LinkedList<>();
        this.dsv = new LinkedList<>();
        this.dsz = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.dsu.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(m mVar) {
        this.dsv.add(mVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void build() {
        Iterator<m> it = this.dsv.iterator();
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
            ((MoreDeskView) mVar).g(this.dsu);
            mVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.dsw = null;
        this.dsu.clear();
        this.dsv.clear();
    }

    protected void display() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.dsw != null) {
            this.dsw.hide();
        }
        this.dsw = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lS(int i) {
        if (lW(i)) {
            if (aLY()) {
                this.dsx = true;
            } else {
                this.dsx = false;
            }
            boolean z = this.dsy;
            Iterator<m> it = this.dsv.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.dsy = true;
                }
                if (next.getToolId() == i) {
                    this.dsw = next;
                    if (this.dsx) {
                        next.display();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.dsx && (getContext() instanceof Activity)) {
                if (this.dsz != null) {
                    this.dsz.aMc();
                } else {
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(this.dsA, 250L);
            }
            display();
        }
    }

    private boolean lW(int i) {
        Iterator<m> it = this.dsv.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public g lU(int i) {
        Iterator<g> it = this.dsu.iterator();
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
            am.setBackgroundColor(this, this.mBgColor, i);
        }
        Iterator<g> it = this.dsu.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<m> it2 = this.dsv.iterator();
        while (it2.hasNext()) {
            m next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean aLX() {
        return getVisibility() == 0 && aLY();
    }

    private boolean aLY() {
        Iterator<m> it = this.dsv.iterator();
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
