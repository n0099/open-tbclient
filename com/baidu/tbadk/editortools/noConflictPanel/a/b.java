package com.baidu.tbadk.editortools.noConflictPanel.a;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.editortools.noConflictPanel.b.d;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.editortools.noConflictPanel.a {
    private final View fjj;
    private boolean fjm;
    private boolean cnQ = false;
    private boolean fjn = false;

    public b(View view, AttributeSet attributeSet) {
        this.fjm = false;
        this.fjj = view;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = view.getContext().obtainStyledAttributes(attributeSet, R.styleable.KPSwitchPanelLayout);
                this.fjm = typedArray.getBoolean(R.styleable.KPSwitchPanelLayout_ignore_recommend_height, false);
            } finally {
                if (typedArray != null) {
                    typedArray.recycle();
                }
            }
        }
    }

    public boolean he(int i) {
        if (i == 0) {
            this.cnQ = false;
        }
        if (i == this.fjj.getVisibility()) {
            return true;
        }
        return bxx() && i == 0;
    }

    public int[] ab(int i, int i2) {
        if (this.cnQ) {
            this.fjj.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        return new int[]{i, i2};
    }

    public void jY(boolean z) {
        this.fjn = z;
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public boolean bxx() {
        return this.fjn;
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public boolean isVisible() {
        return !this.cnQ;
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public void acQ() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public void acR() {
        this.cnQ = true;
    }

    public void rh(int i) {
        if (!this.fjm) {
            d.l(this.fjj, i);
        }
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.fjm = z;
    }
}
