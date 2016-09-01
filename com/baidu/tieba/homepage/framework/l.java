package com.baidu.tieba.homepage.framework;

import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements b {
    final /* synthetic */ RecommendFrsControlFragment cBR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.cBR = recommendFrsControlFragment;
    }

    @Override // com.baidu.tieba.homepage.framework.b
    public void a(int i, long j, long j2, String str) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        q qVar;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        ScrollFragmentTabHost scrollFragmentTabHost4;
        scrollFragmentTabHost = this.cBR.cBE;
        if (scrollFragmentTabHost != null) {
            qVar = this.cBR.cBF;
            scrollFragmentTabHost2 = this.cBR.cBE;
            int bD = scrollFragmentTabHost2.bD(j);
            scrollFragmentTabHost3 = this.cBR.cBE;
            long bE = scrollFragmentTabHost3.bE(j);
            scrollFragmentTabHost4 = this.cBR.cBE;
            qVar.a(i, j, bD, j2, bE, scrollFragmentTabHost4.bF(j), str);
        }
    }

    @Override // com.baidu.tieba.homepage.framework.b
    public void bA(long j) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        q qVar;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        ScrollFragmentTabHost scrollFragmentTabHost4;
        scrollFragmentTabHost = this.cBR.cBE;
        if (scrollFragmentTabHost != null) {
            qVar = this.cBR.cBF;
            scrollFragmentTabHost2 = this.cBR.cBE;
            int bD = scrollFragmentTabHost2.bD(j);
            scrollFragmentTabHost3 = this.cBR.cBE;
            long bE = scrollFragmentTabHost3.bE(j);
            scrollFragmentTabHost4 = this.cBR.cBE;
            qVar.a(j, bD, bE, scrollFragmentTabHost4.bF(j));
        }
    }
}
