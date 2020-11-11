package com.baidu.tbadk.editortools.noConflictPanel.a;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.editortools.noConflictPanel.b.d;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.editortools.noConflictPanel.a {
    private final View fpa;
    private boolean fpd;
    private boolean ctO = false;
    private boolean fpe = false;

    public b(View view, AttributeSet attributeSet) {
        this.fpd = false;
        this.fpa = view;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = view.getContext().obtainStyledAttributes(attributeSet, R.styleable.KPSwitchPanelLayout);
                this.fpd = typedArray.getBoolean(R.styleable.KPSwitchPanelLayout_ignore_recommend_height, false);
            } finally {
                if (typedArray != null) {
                    typedArray.recycle();
                }
            }
        }
    }

    public boolean ho(int i) {
        if (i == 0) {
            this.ctO = false;
        }
        if (i == this.fpa.getVisibility()) {
            return true;
        }
        return bzW() && i == 0;
    }

    public int[] ab(int i, int i2) {
        if (this.ctO) {
            this.fpa.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        return new int[]{i, i2};
    }

    public void kh(boolean z) {
        this.fpe = z;
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public boolean bzW() {
        return this.fpe;
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public boolean isVisible() {
        return !this.ctO;
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public void afq() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public void afr() {
        this.ctO = true;
    }

    public void rr(int i) {
        if (!this.fpd) {
            d.l(this.fpa, i);
        }
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.fpd = z;
    }
}
