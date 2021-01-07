package com.baidu.tbadk.editortools.noConflictPanel.a;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.editortools.noConflictPanel.b.d;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.editortools.noConflictPanel.a {
    private final View fFt;
    private boolean fFw;
    private boolean cDR = false;
    private boolean fFx = false;

    public b(View view, AttributeSet attributeSet) {
        this.fFw = false;
        this.fFt = view;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = view.getContext().obtainStyledAttributes(attributeSet, R.styleable.KPSwitchPanelLayout);
                this.fFw = typedArray.getBoolean(R.styleable.KPSwitchPanelLayout_ignore_recommend_height, false);
            } finally {
                if (typedArray != null) {
                    typedArray.recycle();
                }
            }
        }
    }

    public boolean hC(int i) {
        if (i == 0) {
            this.cDR = false;
        }
        if (i == this.fFt.getVisibility()) {
            return true;
        }
        return bFi() && i == 0;
    }

    public int[] Y(int i, int i2) {
        if (this.cDR) {
            this.fFt.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        return new int[]{i, i2};
    }

    public void kV(boolean z) {
        this.fFx = z;
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public boolean bFi() {
        return this.fFx;
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public boolean isVisible() {
        return !this.cDR;
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public void aja() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public void ajb() {
        this.cDR = true;
    }

    public void sC(int i) {
        if (!this.fFw) {
            d.r(this.fFt, i);
        }
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.fFw = z;
    }
}
