package com.baidu.tieba.homepage.framework;

import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements b {
    final /* synthetic */ RecommendFrsControlFragment cuc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.cuc = recommendFrsControlFragment;
    }

    @Override // com.baidu.tieba.homepage.framework.b
    public void a(int i, long j, long j2, String str) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        q qVar;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        ScrollFragmentTabHost scrollFragmentTabHost4;
        scrollFragmentTabHost = this.cuc.ctO;
        if (scrollFragmentTabHost != null) {
            qVar = this.cuc.ctP;
            scrollFragmentTabHost2 = this.cuc.ctO;
            int bl = scrollFragmentTabHost2.bl(j);
            scrollFragmentTabHost3 = this.cuc.ctO;
            long bm = scrollFragmentTabHost3.bm(j);
            scrollFragmentTabHost4 = this.cuc.ctO;
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
        scrollFragmentTabHost = this.cuc.ctO;
        if (scrollFragmentTabHost != null) {
            qVar = this.cuc.ctP;
            scrollFragmentTabHost2 = this.cuc.ctO;
            int bl = scrollFragmentTabHost2.bl(j);
            scrollFragmentTabHost3 = this.cuc.ctO;
            long bm = scrollFragmentTabHost3.bm(j);
            scrollFragmentTabHost4 = this.cuc.ctO;
            qVar.a(j, bl, bm, scrollFragmentTabHost4.bn(j));
        }
    }
}
