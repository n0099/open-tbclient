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
    private int crS;
    private LinkedList<g> csb;
    private LinkedList<l> csc;
    private l csd;
    private boolean cse;
    private boolean csf;
    private EditorTools csg;
    private Runnable csh;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorDesk(Context context, EditorTools editorTools) {
        super(context);
        this.crS = R.color.cp_bg_line_d;
        this.csd = null;
        this.cse = true;
        this.csf = false;
        this.csh = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorDesk.1
            @Override // java.lang.Runnable
            public void run() {
                if (EditorDesk.this.csd != null) {
                    EditorDesk.this.csd.qk();
                }
            }
        };
        this.csb = new LinkedList<>();
        this.csc = new LinkedList<>();
        this.csg = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.csb.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.csc.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void asb() {
        Iterator<l> it = this.csc.iterator();
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
            ((MoreDeskView) lVar).k(this.csb);
            lVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.csd = null;
        this.csb.clear();
        this.csc.clear();
    }

    protected void qk() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.csd != null) {
            this.csd.hide();
        }
        this.csd = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kl(int i) {
        if (kp(i)) {
            if (ase()) {
                this.cse = true;
            } else {
                this.cse = false;
            }
            boolean z = this.csf;
            Iterator<l> it = this.csc.iterator();
            while (it.hasNext()) {
                l next = it.next();
                if (!z && TbadkCoreApplication.getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.csf = true;
                }
                if (next.getToolId() == i) {
                    this.csd = next;
                    if (this.cse) {
                        next.qk();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.cse && (getContext() instanceof Activity)) {
                if (this.csg != null) {
                    this.csg.asi();
                } else {
                    com.baidu.adp.lib.util.l.b(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.g.e.iK().postDelayed(this.csh, 250L);
            }
            qk();
        }
    }

    private boolean kp(int i) {
        Iterator<l> it = this.csc.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public g kn(int i) {
        Iterator<g> it = this.csb.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.crS > 0) {
            am.h(this, this.crS, i);
        }
        Iterator<g> it = this.csb.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<l> it2 = this.csc.iterator();
        while (it2.hasNext()) {
            l next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean asd() {
        return getVisibility() == 0 && ase();
    }

    private boolean ase() {
        Iterator<l> it = this.csc.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.crS = i;
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
