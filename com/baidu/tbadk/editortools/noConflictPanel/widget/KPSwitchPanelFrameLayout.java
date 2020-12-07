package com.baidu.tbadk.editortools.noConflictPanel.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tbadk.editortools.noConflictPanel.a;
import com.baidu.tbadk.editortools.noConflictPanel.b;
/* loaded from: classes.dex */
public class KPSwitchPanelFrameLayout extends FrameLayout implements a, b {
    private com.baidu.tbadk.editortools.noConflictPanel.a.b fwk;

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
        this.fwk = new com.baidu.tbadk.editortools.noConflictPanel.a.b(this, attributeSet);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.fwk.hI(i)) {
            super.setVisibility(i);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int[] ad = this.fwk.ad(i, i2);
        super.onMeasure(ad[0], ad[1]);
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public boolean bCM() {
        return this.fwk.bCM();
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public boolean isVisible() {
        return this.fwk.isVisible();
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public void ahQ() {
        super.setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public void ahR() {
        this.fwk.ahR();
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.fwk.setIgnoreRecommendHeight(z);
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.b
    public void sp(int i) {
        this.fwk.sq(i);
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.b
    public void ky(boolean z) {
        this.fwk.kz(z);
    }
}
