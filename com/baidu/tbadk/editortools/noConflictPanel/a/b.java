package com.baidu.tbadk.editortools.noConflictPanel.a;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.editortools.noConflictPanel.b.d;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.editortools.noConflictPanel.a {
    private final View faK;
    private boolean faN;
    private boolean cfr = false;
    private boolean faO = false;

    public b(View view, AttributeSet attributeSet) {
        this.faN = false;
        this.faK = view;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = view.getContext().obtainStyledAttributes(attributeSet, R.styleable.KPSwitchPanelLayout);
                this.faN = typedArray.getBoolean(R.styleable.KPSwitchPanelLayout_ignore_recommend_height, false);
            } finally {
                if (typedArray != null) {
                    typedArray.recycle();
                }
            }
        }
    }

    public boolean gT(int i) {
        if (i == 0) {
            this.cfr = false;
        }
        if (i == this.faK.getVisibility()) {
            return true;
        }
        return bvE() && i == 0;
    }

    public int[] aa(int i, int i2) {
        if (this.cfr) {
            this.faK.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        return new int[]{i, i2};
    }

    public void jL(boolean z) {
        this.faO = z;
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public boolean bvE() {
        return this.faO;
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public boolean isVisible() {
        return !this.cfr;
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public void aaW() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public void aaX() {
        this.cfr = true;
    }

    public void qW(int i) {
        if (!this.faN) {
            d.l(this.faK, i);
        }
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.faN = z;
    }
}
