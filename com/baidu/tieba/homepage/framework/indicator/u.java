package com.baidu.tieba.homepage.framework.indicator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements com.baidu.tieba.homepage.framework.w {
    final /* synthetic */ SlidingTabLayout cvr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(SlidingTabLayout slidingTabLayout) {
        this.cvr = slidingTabLayout;
    }

    @Override // com.baidu.tieba.homepage.framework.w
    public void ap(int i, int i2) {
        this.cvr.au(i, i2);
    }
}
