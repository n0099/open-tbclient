package com.baidu.tbadk.editortools.noConflictPanel.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tbadk.editortools.noConflictPanel.a.a;
import com.baidu.tbadk.editortools.noConflictPanel.b;
import com.baidu.tbadk.editortools.noConflictPanel.b.d;
/* loaded from: classes.dex */
public class KPSwitchFSPanelFrameLayout extends FrameLayout implements b {
    private a fDw;

    public KPSwitchFSPanelFrameLayout(Context context) {
        super(context);
        init();
    }

    public KPSwitchFSPanelFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public KPSwitchFSPanelFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.fDw = new a(this);
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.b
    public void ra(int i) {
        d.r(this, i);
    }

    @Override // com.baidu.tbadk.editortools.noConflictPanel.b
    public void kT(boolean z) {
        this.fDw.kT(z);
    }
}
