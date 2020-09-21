package com.baidu.tbadk.editortools.noConflictPanel.a;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.editortools.noConflictPanel.b.d;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.editortools.noConflictPanel.a {
    private final View eOD;
    private boolean eOG;
    private boolean bTd = false;
    private boolean eOH = false;

    public b(View view, AttributeSet attributeSet) {
        this.eOG = false;
        this.eOD = view;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = view.getContext().obtainStyledAttributes(attributeSet, R.styleable.KPSwitchPanelLayout);
                this.eOG = typedArray.getBoolean(R.styleable.KPSwitchPanelLayout_ignore_recommend_height, false);
            } finally {
                if (typedArray != null) {
                    typedArray.recycle();
                }
            }
        }
    }

    public boolean gw(int i) {
        if (i == 0) {
            this.bTd = false;
        }
        if (i == this.eOD.getVisibility()) {
            return true;
        }
        return bsU() && i == 0;
    }

    public int[] ab(int i, int i2) {
        if (this.bTd) {
            this.eOD.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        return new int[]{i, i2};
    }

    public void jn(boolean z) {
        this.eOH = z;
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public boolean bsU() {
        return this.eOH;
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public boolean isVisible() {
        return !this.bTd;
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public void Yk() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public void Yl() {
        this.bTd = true;
    }

    public void qy(int i) {
        if (!this.eOG) {
            d.k(this.eOD, i);
        }
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.eOG = z;
    }
}
