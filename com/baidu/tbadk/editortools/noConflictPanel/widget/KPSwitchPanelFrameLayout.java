package com.baidu.tbadk.editortools.noConflictPanel.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tbadk.editortools.noConflictPanel.a;
import com.baidu.tbadk.editortools.noConflictPanel.b;
/* loaded from: classes.dex */
public class KPSwitchPanelFrameLayout extends FrameLayout implements a, b {
    private com.baidu.tbadk.editortools.noConflictPanel.a.b fBi;

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
        this.fBi = new com.baidu.tbadk.editortools.noConflictPanel.a.b(this, attributeSet);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.fBi.fV(i)) {
            super.setVisibility(i);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int[] Y = this.fBi.Y(i, i2);
        super.onMeasure(Y[0], Y[1]);
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public boolean bBo() {
        return this.fBi.bBo();
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public boolean isVisible() {
        return this.fBi.isVisible();
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public void afg() {
        super.setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public void afh() {
        this.fBi.afh();
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.fBi.setIgnoreRecommendHeight(z);
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.b
    public void qV(int i) {
        this.fBi.qW(i);
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.b
    public void kQ(boolean z) {
        this.fBi.kR(z);
    }
}
