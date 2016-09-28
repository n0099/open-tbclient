package com.baidu.tieba.homepage.framework.indicator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements com.baidu.tieba.homepage.framework.w {
    final /* synthetic */ SlidingTabLayout cDI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(SlidingTabLayout slidingTabLayout) {
        this.cDI = slidingTabLayout;
    }

    @Override // com.baidu.tieba.homepage.framework.w
    public void as(int i, int i2) {
        this.cDI.ax(i, i2);
    }
}
