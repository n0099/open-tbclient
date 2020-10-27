package com.baidu.tbadk.editortools.noConflictPanel.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tbadk.editortools.noConflictPanel.a;
import com.baidu.tbadk.editortools.noConflictPanel.b;
/* loaded from: classes.dex */
public class KPSwitchPanelFrameLayout extends FrameLayout implements a, b {
    private com.baidu.tbadk.editortools.noConflictPanel.a.b fjG;

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
        this.fjG = new com.baidu.tbadk.editortools.noConflictPanel.a.b(this, attributeSet);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.fjG.he(i)) {
            super.setVisibility(i);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int[] ab = this.fjG.ab(i, i2);
        super.onMeasure(ab[0], ab[1]);
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public boolean bxx() {
        return this.fjG.bxx();
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public boolean isVisible() {
        return this.fjG.isVisible();
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public void acQ() {
        super.setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.a
    public void acR() {
        this.fjG.acR();
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.fjG.setIgnoreRecommendHeight(z);
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.b
    public void rg(int i) {
        this.fjG.rh(i);
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.b
    public void jX(boolean z) {
        this.fjG.jY(z);
    }
}
