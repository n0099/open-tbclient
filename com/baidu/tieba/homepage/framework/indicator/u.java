package com.baidu.tieba.homepage.framework.indicator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements com.baidu.tieba.homepage.framework.w {
    final /* synthetic */ SlidingTabLayout crV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(SlidingTabLayout slidingTabLayout) {
        this.crV = slidingTabLayout;
    }

    @Override // com.baidu.tieba.homepage.framework.w
    public void am(int i, int i2) {
        this.crV.ar(i, i2);
    }
}
