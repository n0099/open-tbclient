package com.baidu.tieba.homepage.framework;

import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements b {
    final /* synthetic */ RecommendFrsControlFragment cwt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.cwt = recommendFrsControlFragment;
    }

    @Override // com.baidu.tieba.homepage.framework.b
    public void a(int i, long j, long j2, String str) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        q qVar;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        ScrollFragmentTabHost scrollFragmentTabHost4;
        scrollFragmentTabHost = this.cwt.cwf;
        if (scrollFragmentTabHost != null) {
            qVar = this.cwt.cwg;
            scrollFragmentTabHost2 = this.cwt.cwf;
            int bl = scrollFragmentTabHost2.bl(j);
            scrollFragmentTabHost3 = this.cwt.cwf;
            long bm = scrollFragmentTabHost3.bm(j);
            scrollFragmentTabHost4 = this.cwt.cwf;
            qVar.a(i, j, bl, j2, bm, scrollFragmentTabHost4.bn(j), str);
        }
    }

    @Override // com.baidu.tieba.homepage.framework.b
    public void bi(long j) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        q qVar;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        ScrollFragmentTabHost scrollFragmentTabHost4;
        scrollFragmentTabHost = this.cwt.cwf;
        if (scrollFragmentTabHost != null) {
            qVar = this.cwt.cwg;
            scrollFragmentTabHost2 = this.cwt.cwf;
            int bl = scrollFragmentTabHost2.bl(j);
            scrollFragmentTabHost3 = this.cwt.cwf;
            long bm = scrollFragmentTabHost3.bm(j);
            scrollFragmentTabHost4 = this.cwt.cwf;
            qVar.a(j, bl, bm, scrollFragmentTabHost4.bn(j));
        }
    }
}
