package com.baidu.tieba.homepage.framework;

import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements b {
    final /* synthetic */ RecommendFrsControlFragment cHJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.cHJ = recommendFrsControlFragment;
    }

    @Override // com.baidu.tieba.homepage.framework.b
    public void a(int i, long j, long j2, String str) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        q qVar;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        ScrollFragmentTabHost scrollFragmentTabHost4;
        scrollFragmentTabHost = this.cHJ.cHv;
        if (scrollFragmentTabHost != null) {
            qVar = this.cHJ.cHw;
            scrollFragmentTabHost2 = this.cHJ.cHv;
            int bC = scrollFragmentTabHost2.bC(j);
            scrollFragmentTabHost3 = this.cHJ.cHv;
            long bD = scrollFragmentTabHost3.bD(j);
            scrollFragmentTabHost4 = this.cHJ.cHv;
            qVar.a(i, j, bC, j2, bD, scrollFragmentTabHost4.bE(j), str);
        }
    }

    @Override // com.baidu.tieba.homepage.framework.b
    public void bz(long j) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        q qVar;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        ScrollFragmentTabHost scrollFragmentTabHost4;
        scrollFragmentTabHost = this.cHJ.cHv;
        if (scrollFragmentTabHost != null) {
            qVar = this.cHJ.cHw;
            scrollFragmentTabHost2 = this.cHJ.cHv;
            int bC = scrollFragmentTabHost2.bC(j);
            scrollFragmentTabHost3 = this.cHJ.cHv;
            long bD = scrollFragmentTabHost3.bD(j);
            scrollFragmentTabHost4 = this.cHJ.cHv;
            qVar.a(j, bC, bD, scrollFragmentTabHost4.bE(j));
        }
    }
}
