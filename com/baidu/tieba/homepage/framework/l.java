package com.baidu.tieba.homepage.framework;

import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements b {
    final /* synthetic */ RecommendFrsControlFragment cnd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.cnd = recommendFrsControlFragment;
    }

    @Override // com.baidu.tieba.homepage.framework.b
    public void a(int i, long j, long j2, String str) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        q qVar;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        ScrollFragmentTabHost scrollFragmentTabHost4;
        scrollFragmentTabHost = this.cnd.cmP;
        if (scrollFragmentTabHost != null) {
            qVar = this.cnd.cmQ;
            scrollFragmentTabHost2 = this.cnd.cmP;
            int bq = scrollFragmentTabHost2.bq(j);
            scrollFragmentTabHost3 = this.cnd.cmP;
            long br = scrollFragmentTabHost3.br(j);
            scrollFragmentTabHost4 = this.cnd.cmP;
            qVar.a(i, j, bq, j2, br, scrollFragmentTabHost4.bs(j), str);
        }
    }

    @Override // com.baidu.tieba.homepage.framework.b
    public void bn(long j) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        q qVar;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        ScrollFragmentTabHost scrollFragmentTabHost4;
        scrollFragmentTabHost = this.cnd.cmP;
        if (scrollFragmentTabHost != null) {
            qVar = this.cnd.cmQ;
            scrollFragmentTabHost2 = this.cnd.cmP;
            int bq = scrollFragmentTabHost2.bq(j);
            scrollFragmentTabHost3 = this.cnd.cmP;
            long br = scrollFragmentTabHost3.br(j);
            scrollFragmentTabHost4 = this.cnd.cmP;
            qVar.a(j, bq, br, scrollFragmentTabHost4.bs(j));
        }
    }
}
