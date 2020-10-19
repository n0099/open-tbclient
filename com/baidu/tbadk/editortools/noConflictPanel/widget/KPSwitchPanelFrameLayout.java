package com.baidu.tbadk.editortools.noConflictPanel.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tbadk.editortools.noConflictPanel.a;
import com.baidu.tbadk.editortools.noConflictPanel.b;
/* loaded from: classes.dex */
public class KPSwitchPanelFrameLayout extends FrameLayout implements a, b {
    private com.baidu.tbadk.editortools.noConflictPanel.a.b fbh;

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
        this.fbh = new com.baidu.tbadk.editortools.noConflictPanel.a.b(this, attributeSet);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.fbh.gT(i)) {
            super.setVisibility(i);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int[] aa = this.fbh.aa(i, i2);
        super.onMeasure(aa[0], aa[1]);
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public boolean bvE() {
        return this.fbh.bvE();
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public boolean isVisible() {
        return this.fbh.isVisible();
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public void aaW() {
        super.setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public void aaX() {
        this.fbh.aaX();
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.fbh.setIgnoreRecommendHeight(z);
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.b
    public void qV(int i) {
        this.fbh.qW(i);
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.b
    public void jK(boolean z) {
        this.fbh.jL(z);
    }
}
