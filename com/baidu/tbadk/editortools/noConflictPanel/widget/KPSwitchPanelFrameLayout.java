package com.baidu.tbadk.editortools.noConflictPanel.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tbadk.editortools.noConflictPanel.a;
import com.baidu.tbadk.editortools.noConflictPanel.b;
/* loaded from: classes.dex */
public class KPSwitchPanelFrameLayout extends FrameLayout implements a, b {
    private com.baidu.tbadk.editortools.noConflictPanel.a.b foF;

    public KPSwitchPanelFrameLayout(Context context) {
        super(context);
        init(null);
    }

    public KPSwitchPanelFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public KPSwitchPanelFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        this.foF = new com.baidu.tbadk.editortools.noConflictPanel.a.b(this, attributeSet);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.foF.hk(i)) {
            super.setVisibility(i);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int[] ab = this.foF.ab(i, i2);
        super.onMeasure(ab[0], ab[1]);
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public boolean bzm() {
        return this.foF.bzm();
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public boolean isVisible() {
        return this.foF.isVisible();
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public void aeI() {
        super.setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public void aeJ() {
        this.foF.aeJ();
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.foF.setIgnoreRecommendHeight(z);
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.b
    public void rO(int i) {
        this.foF.rP(i);
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.b
    public void kh(boolean z) {
        this.foF.ki(z);
    }
}
