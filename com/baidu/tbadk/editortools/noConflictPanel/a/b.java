package com.baidu.tbadk.editortools.noConflictPanel.a;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.editortools.noConflictPanel.b.d;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.editortools.noConflictPanel.a {
    private boolean fEC;
    private final View fEz;
    private boolean cDb = false;
    private boolean fED = false;

    public b(View view, AttributeSet attributeSet) {
        this.fEC = false;
        this.fEz = view;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = view.getContext().obtainStyledAttributes(attributeSet, R.styleable.KPSwitchPanelLayout);
                this.fEC = typedArray.getBoolean(R.styleable.KPSwitchPanelLayout_ignore_recommend_height, false);
            } finally {
                if (typedArray != null) {
                    typedArray.recycle();
                }
            }
        }
    }

    public boolean fZ(int i) {
        if (i == 0) {
            this.cDb = false;
        }
        if (i == this.fEz.getVisibility()) {
            return true;
        }
        return bBJ() && i == 0;
    }

    public int[] V(int i, int i2) {
        if (this.cDb) {
            this.fEz.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        return new int[]{i, i2};
    }

    public void kU(boolean z) {
        this.fED = z;
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public boolean bBJ() {
        return this.fED;
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public boolean isVisible() {
        return !this.cDb;
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public void afI() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public void afJ() {
        this.cDb = true;
    }

    public void rc(int i) {
        if (!this.fEC) {
            d.r(this.fEz, i);
        }
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.fEC = z;
    }
}
