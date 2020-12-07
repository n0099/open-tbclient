package com.baidu.tbadk.editortools.noConflictPanel.a;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.editortools.noConflictPanel.b.d;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.editortools.noConflictPanel.a {
    private final View fvN;
    private boolean fvQ;
    private boolean cyY = false;
    private boolean fvR = false;

    public b(View view, AttributeSet attributeSet) {
        this.fvQ = false;
        this.fvN = view;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = view.getContext().obtainStyledAttributes(attributeSet, R.styleable.KPSwitchPanelLayout);
                this.fvQ = typedArray.getBoolean(R.styleable.KPSwitchPanelLayout_ignore_recommend_height, false);
            } finally {
                if (typedArray != null) {
                    typedArray.recycle();
                }
            }
        }
    }

    public boolean hI(int i) {
        if (i == 0) {
            this.cyY = false;
        }
        if (i == this.fvN.getVisibility()) {
            return true;
        }
        return bCM() && i == 0;
    }

    public int[] ad(int i, int i2) {
        if (this.cyY) {
            this.fvN.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        return new int[]{i, i2};
    }

    public void kz(boolean z) {
        this.fvR = z;
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public boolean bCM() {
        return this.fvR;
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public boolean isVisible() {
        return !this.cyY;
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public void ahQ() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public void ahR() {
        this.cyY = true;
    }

    public void sq(int i) {
        if (!this.fvQ) {
            d.o(this.fvN, i);
        }
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.fvQ = z;
    }
}
