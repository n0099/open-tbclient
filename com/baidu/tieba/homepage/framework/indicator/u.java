package com.baidu.tieba.homepage.framework.indicator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements com.baidu.tieba.homepage.framework.w {
    final /* synthetic */ SlidingTabLayout coq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(SlidingTabLayout slidingTabLayout) {
        this.coq = slidingTabLayout;
    }

    @Override // com.baidu.tieba.homepage.framework.w
    public void ao(int i, int i2) {
        this.coq.at(i, i2);
    }
}
