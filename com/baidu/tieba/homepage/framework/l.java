package com.baidu.tieba.homepage.framework;

import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements b {
    final /* synthetic */ RecommendFrsControlFragment cud;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.cud = recommendFrsControlFragment;
    }

    @Override // com.baidu.tieba.homepage.framework.b
    public void a(int i, long j, long j2, String str) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        q qVar;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        ScrollFragmentTabHost scrollFragmentTabHost4;
        scrollFragmentTabHost = this.cud.ctP;
        if (scrollFragmentTabHost != null) {
            qVar = this.cud.ctQ;
            scrollFragmentTabHost2 = this.cud.ctP;
            int bl = scrollFragmentTabHost2.bl(j);
            scrollFragmentTabHost3 = this.cud.ctP;
            long bm = scrollFragmentTabHost3.bm(j);
            scrollFragmentTabHost4 = this.cud.ctP;
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
        scrollFragmentTabHost = this.cud.ctP;
        if (scrollFragmentTabHost != null) {
            qVar = this.cud.ctQ;
            scrollFragmentTabHost2 = this.cud.ctP;
            int bl = scrollFragmentTabHost2.bl(j);
            scrollFragmentTabHost3 = this.cud.ctP;
            long bm = scrollFragmentTabHost3.bm(j);
            scrollFragmentTabHost4 = this.cud.ctP;
            qVar.a(j, bl, bm, scrollFragmentTabHost4.bn(j));
        }
    }
}
