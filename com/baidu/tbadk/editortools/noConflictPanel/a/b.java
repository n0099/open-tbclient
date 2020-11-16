package com.baidu.tbadk.editortools.noConflictPanel.a;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.editortools.noConflictPanel.b.d;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.editortools.noConflictPanel.a {
    private final View foi;
    private boolean fol;
    private boolean csc = false;
    private boolean fom = false;

    public b(View view, AttributeSet attributeSet) {
        this.fol = false;
        this.foi = view;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = view.getContext().obtainStyledAttributes(attributeSet, R.styleable.KPSwitchPanelLayout);
                this.fol = typedArray.getBoolean(R.styleable.KPSwitchPanelLayout_ignore_recommend_height, false);
            } finally {
                if (typedArray != null) {
                    typedArray.recycle();
                }
            }
        }
    }

    public boolean hk(int i) {
        if (i == 0) {
            this.csc = false;
        }
        if (i == this.foi.getVisibility()) {
            return true;
        }
        return bzm() && i == 0;
    }

    public int[] ab(int i, int i2) {
        if (this.csc) {
            this.foi.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        return new int[]{i, i2};
    }

    public void ki(boolean z) {
        this.fom = z;
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public boolean bzm() {
        return this.fom;
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public boolean isVisible() {
        return !this.csc;
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public void aeI() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public void aeJ() {
        this.csc = true;
    }

    public void rP(int i) {
        if (!this.fol) {
            d.o(this.foi, i);
        }
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.fol = z;
    }
}
