package com.baidu.tieba.homepage.framework.indicator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements com.baidu.tieba.homepage.framework.w {
    final /* synthetic */ SlidingTabLayout cxI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(SlidingTabLayout slidingTabLayout) {
        this.cxI = slidingTabLayout;
    }

    @Override // com.baidu.tieba.homepage.framework.w
    public void ap(int i, int i2) {
        this.cxI.au(i, i2);
    }
}
