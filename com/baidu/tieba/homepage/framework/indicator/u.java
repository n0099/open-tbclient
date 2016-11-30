package com.baidu.tieba.homepage.framework.indicator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements com.baidu.tieba.homepage.framework.w {
    final /* synthetic */ SlidingTabLayout cIV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(SlidingTabLayout slidingTabLayout) {
        this.cIV = slidingTabLayout;
    }

    @Override // com.baidu.tieba.homepage.framework.w
    public void at(int i, int i2) {
        this.cIV.ay(i, i2);
    }
}
