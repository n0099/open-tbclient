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
    private LinkedList<g> dwA;
    private LinkedList<m> dwB;
    private m dwC;
    private boolean dwD;
    private boolean dwE;
    private EditorTools dwF;
    private Runnable dwG;
    private int mBgColor;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorDesk(Context context, EditorTools editorTools) {
        super(context);
        this.mBgColor = R.color.cp_bg_line_h;
        this.dwC = null;
        this.dwD = true;
        this.dwE = false;
        this.dwG = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorDesk.1
            @Override // java.lang.Runnable
            public void run() {
                if (EditorDesk.this.dwC != null) {
                    EditorDesk.this.dwC.display();
                }
            }
        };
        this.dwA = new LinkedList<>();
        this.dwB = new LinkedList<>();
        this.dwF = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.dwA.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(m mVar) {
        this.dwB.add(mVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void build() {
        Iterator<m> it = this.dwB.iterator();
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
            ((MoreDeskView) mVar).g(this.dwA);
            mVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.dwC = null;
        this.dwA.clear();
        this.dwB.clear();
    }

    protected void display() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.dwC != null) {
            this.dwC.hide();
        }
        this.dwC = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mk(int i) {
        if (mo(i)) {
            if (aOu()) {
                this.dwD = true;
            } else {
                this.dwD = false;
            }
            boolean z = this.dwE;
            Iterator<m> it = this.dwB.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.dwE = true;
                }
                if (next.getToolId() == i) {
                    this.dwC = next;
                    if (this.dwD) {
                        next.display();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.dwD && (getContext() instanceof Activity)) {
                if (this.dwF != null) {
                    this.dwF.aOy();
                } else {
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(this.dwG, 250L);
            }
            display();
        }
    }

    private boolean mo(int i) {
        Iterator<m> it = this.dwB.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public g mm(int i) {
        Iterator<g> it = this.dwA.iterator();
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
        Iterator<g> it = this.dwA.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<m> it2 = this.dwB.iterator();
        while (it2.hasNext()) {
            m next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean aOt() {
        return getVisibility() == 0 && aOu();
    }

    private boolean aOu() {
        Iterator<m> it = this.dwB.iterator();
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
