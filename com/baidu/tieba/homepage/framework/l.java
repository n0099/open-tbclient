package com.baidu.tieba.homepage.framework;

import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements b {
    final /* synthetic */ RecommendFrsControlFragment cqJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.cqJ = recommendFrsControlFragment;
    }

    @Override // com.baidu.tieba.homepage.framework.b
    public void a(int i, long j, long j2, String str) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        q qVar;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        ScrollFragmentTabHost scrollFragmentTabHost4;
        scrollFragmentTabHost = this.cqJ.cqw;
        if (scrollFragmentTabHost != null) {
            qVar = this.cqJ.cqx;
            scrollFragmentTabHost2 = this.cqJ.cqw;
            int bh = scrollFragmentTabHost2.bh(j);
            scrollFragmentTabHost3 = this.cqJ.cqw;
            long bi = scrollFragmentTabHost3.bi(j);
            scrollFragmentTabHost4 = this.cqJ.cqw;
            qVar.a(i, j, bh, j2, bi, scrollFragmentTabHost4.bj(j), str);
        }
    }

    @Override // com.baidu.tieba.homepage.framework.b
    public void be(long j) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        q qVar;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        ScrollFragmentTabHost scrollFragmentTabHost4;
        scrollFragmentTabHost = this.cqJ.cqw;
        if (scrollFragmentTabHost != null) {
            qVar = this.cqJ.cqx;
            scrollFragmentTabHost2 = this.cqJ.cqw;
            int bh = scrollFragmentTabHost2.bh(j);
            scrollFragmentTabHost3 = this.cqJ.cqw;
            long bi = scrollFragmentTabHost3.bi(j);
            scrollFragmentTabHost4 = this.cqJ.cqw;
            qVar.a(j, bh, bi, scrollFragmentTabHost4.bj(j));
        }
    }
}
