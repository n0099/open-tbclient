package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class h extends FrameLayout {
    private int apk;
    private LinkedList<s> apt;
    private LinkedList<ab> apu;
    private ab apv;
    private boolean apw;
    private boolean apx;
    private l apy;
    private Runnable apz;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, l lVar) {
        super(context);
        this.apk = t.d.editor_background;
        this.apv = null;
        this.apw = true;
        this.apx = false;
        this.apz = new i(this);
        this.apt = new LinkedList<>();
        this.apu = new LinkedList<>();
        this.apy = lVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar) {
        this.apt.add(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ab abVar) {
        this.apu.add(abVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bd() {
        Iterator<ab> it = this.apu.iterator();
        while (it.hasNext()) {
            ab next = it.next();
            if (next.getToolId() == 2) {
                b(next);
            }
            if (next instanceof View) {
                View view = (View) next;
                view.setVisibility(8);
                addView(view, -1, getContext().getResources().getDimensionPixelSize(t.e.editor_tool_desk_height));
            }
            next.init();
        }
        invalidate();
    }

    private void b(ab abVar) {
        if (abVar instanceof t) {
            ((t) abVar).h(this.apt);
            abVar.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.apv = null;
        this.apt.clear();
        this.apu.clear();
    }

    protected void kC() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.apv != null) {
            this.apv.hide();
        }
        this.apv = null;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ed(int i) {
        if (eg(i)) {
            if (Bg()) {
                this.apw = true;
            } else {
                this.apw = false;
            }
            boolean z = this.apx;
            Iterator<ab> it = this.apu.iterator();
            while (it.hasNext()) {
                ab next = it.next();
                if (!z && TbadkCoreApplication.m11getInst().isKeyboardHeightCanUsed() && (next instanceof View)) {
                    View view = (View) next;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.m11getInst().getKeyboardHeight();
                    view.setLayoutParams(layoutParams);
                    this.apx = true;
                }
                if (next.getToolId() == i) {
                    this.apv = next;
                    if (this.apw) {
                        next.kC();
                    }
                } else {
                    next.hide();
                }
            }
            if (!this.apw && (getContext() instanceof Activity)) {
                if (this.apy != null) {
                    this.apy.Bk();
                } else {
                    com.baidu.adp.lib.util.k.a(getContext(), ((Activity) getContext()).getCurrentFocus());
                }
                com.baidu.adp.lib.h.h.dL().postDelayed(this.apz, 250L);
            }
            kC();
        }
    }

    private boolean eg(int i) {
        Iterator<ab> it = this.apu.iterator();
        while (it.hasNext()) {
            if (it.next().getToolId() == i) {
                return true;
            }
        }
        return false;
    }

    public s ef(int i) {
        Iterator<s> it = this.apt.iterator();
        while (it.hasNext()) {
            s next = it.next();
            if (next.getToolId() == i) {
                return next;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.apk > 0) {
            at.e(this, this.apk, i);
        }
        Iterator<s> it = this.apt.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i);
        }
        Iterator<ab> it2 = this.apu.iterator();
        while (it2.hasNext()) {
            ab next = it2.next();
            if (next != null) {
                next.onChangeSkinType(i);
            }
        }
    }

    public boolean Bf() {
        return getVisibility() == 0 && Bg();
    }

    private boolean Bg() {
        Iterator<ab> it = this.apu.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.apk = i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            aL(true);
        }
        super.requestDisallowInterceptTouchEvent(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        aL(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    private void aL(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
