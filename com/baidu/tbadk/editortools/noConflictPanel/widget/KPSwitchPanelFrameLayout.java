package com.baidu.tbadk.editortools.noConflictPanel.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tbadk.editortools.noConflictPanel.a;
import com.baidu.tbadk.editortools.noConflictPanel.b;
/* loaded from: classes.dex */
public class KPSwitchPanelFrameLayout extends FrameLayout implements a, b {
    private com.baidu.tbadk.editortools.noConflictPanel.a.b fFQ;

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
        this.fFQ = new com.baidu.tbadk.editortools.noConflictPanel.a.b(this, attributeSet);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.fFQ.hC(i)) {
            super.setVisibility(i);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int[] Y = this.fFQ.Y(i, i2);
        super.onMeasure(Y[0], Y[1]);
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public boolean bFi() {
        return this.fFQ.bFi();
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public boolean isVisible() {
        return this.fFQ.isVisible();
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public void aja() {
        super.setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public void ajb() {
        this.fFQ.ajb();
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.fFQ.setIgnoreRecommendHeight(z);
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.b
    public void sB(int i) {
        this.fFQ.sC(i);
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.b
    public void kU(boolean z) {
        this.fFQ.kV(z);
    }
}
