package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class EditorDesk extends FrameLayout {
    private LinkedList<g> aYW;
    private LinkedList<l> aYX;
    private l aYY;
    private boolean aYZ;
    private boolean aZa;
    private EditorTools aZb;
    private Runnable aZc;
    private int mBgColor;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorDesk(Context context, EditorTools editorTools) {
        super(context);
        this.mBgColor = e.d.cp_bg_line_d;
        this.aYY = null;
        this.aYZ = true;
        this.aZa = false;
        this.aZc = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorDesk.1
            @Override // java.lang.Runnable
            public void run() {
                if (EditorDesk.this.aYY != null) {
                    EditorDesk.this.aYY.pR();
                }
            }
        };
        this.aYW = new LinkedList<>();
        this.aYX = new LinkedList<>();
        this.aZb = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.aYW.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.aYX.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Mq() {
        Iterator<l> it = this.aYX.iterator();
        while (it.hasNext()) {
            l next = it.next();
            if (next.getToolId() == 2) {
                b(next);
            }
            if (next instanceof View) {
                View view = (View) next;
                view.setVisibility(8);
                addView(view, -1, getContext().getResources().getDimensionPixelSize(e.C0210e.ds460));
            }
            next.init();
        }
        invalidate();
    }

    private void b(l lVar) {
        if (lVar instanceof MoreDeskView) {
            ((MoreDeskView) lVar).k(this.aYW);
            lVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aYY = null;
        this.aYW.clear();
        this.aYX.clear();
    }

    protected void pR() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.aYY != null) {
            this.aYY.hide();
        }
        this.aYY = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fG(int i) {
        if (fK(i)) {
            if (Mt()) {
                this.aYZ = true;
            } else {
                this.aYZ = false;
            }
            boolean z = this.aZa;
            Iterator<l> it = this.aYX.iterator();
            while (it.hasNext()) {
                l next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.aZa = true;
                }
                if (next.getToolId() == i) {
                    this.aYY = next;
                    if (this.aYZ) {
                        next.pR();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.aYZ && (getContext() instanceof Activity)) {
                if (this.aZb != null) {
                    this.aZb.Mx();
                } else {
                    com.baidu.adp.lib.util.l.b(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.e.jG().postDelayed(this.aZc, 250L);
            }
            pR();
        }
    }

    private boolean fK(int i) {
        Iterator<l> it = this.aYX.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public g fI(int i) {
        Iterator<g> it = this.aYW.iterator();
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
            al.e(this, this.mBgColor, i);
        }
        Iterator<g> it = this.aYW.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<l> it2 = this.aYX.iterator();
        while (it2.hasNext()) {
            l next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean Ms() {
        return getVisibility() == 0 && Mt();
    }

    private boolean Mt() {
        Iterator<l> it = this.aYX.iterator();
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
            bN(true);
        }
        super.requestDisallowInterceptTouchEvent(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        bN(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    private void bN(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
