package com.baidu.tbadk.editortools.noConflictPanel.a;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.editortools.noConflictPanel.b.d;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.editortools.noConflictPanel.a {
    private final View fDa;
    private boolean fDd;
    private boolean cBB = false;
    private boolean fDe = false;

    public b(View view, AttributeSet attributeSet) {
        this.fDd = false;
        this.fDa = view;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = view.getContext().obtainStyledAttributes(attributeSet, R.styleable.KPSwitchPanelLayout);
                this.fDd = typedArray.getBoolean(R.styleable.KPSwitchPanelLayout_ignore_recommend_height, false);
            } finally {
                if (typedArray != null) {
                    typedArray.recycle();
                }
            }
        }
    }

    public boolean fY(int i) {
        if (i == 0) {
            this.cBB = false;
        }
        if (i == this.fDa.getVisibility()) {
            return true;
        }
        return bBG() && i == 0;
    }

    public int[] V(int i, int i2) {
        if (this.cBB) {
            this.fDa.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        return new int[]{i, i2};
    }

    public void kU(boolean z) {
        this.fDe = z;
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public boolean bBG() {
        return this.fDe;
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public boolean isVisible() {
        return !this.cBB;
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public void afF() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public void afG() {
        this.cBB = true;
    }

    public void rb(int i) {
        if (!this.fDd) {
            d.r(this.fDa, i);
        }
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.fDd = z;
    }
}
