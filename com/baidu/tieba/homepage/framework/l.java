package com.baidu.tieba.homepage.framework;

import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements b {
    final /* synthetic */ RecommendFrsControlFragment cow;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.cow = recommendFrsControlFragment;
    }

    @Override // com.baidu.tieba.homepage.framework.b
    public void a(int i, long j, long j2, String str) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        q qVar;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        ScrollFragmentTabHost scrollFragmentTabHost4;
        scrollFragmentTabHost = this.cow.coi;
        if (scrollFragmentTabHost != null) {
            qVar = this.cow.coj;
            scrollFragmentTabHost2 = this.cow.coi;
            int bm = scrollFragmentTabHost2.bm(j);
            scrollFragmentTabHost3 = this.cow.coi;
            long bn = scrollFragmentTabHost3.bn(j);
            scrollFragmentTabHost4 = this.cow.coi;
            qVar.a(i, j, bm, j2, bn, scrollFragmentTabHost4.bo(j), str);
        }
    }

    @Override // com.baidu.tieba.homepage.framework.b
    public void bj(long j) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        q qVar;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        ScrollFragmentTabHost scrollFragmentTabHost4;
        scrollFragmentTabHost = this.cow.coi;
        if (scrollFragmentTabHost != null) {
            qVar = this.cow.coj;
            scrollFragmentTabHost2 = this.cow.coi;
            int bm = scrollFragmentTabHost2.bm(j);
            scrollFragmentTabHost3 = this.cow.coi;
            long bn = scrollFragmentTabHost3.bn(j);
            scrollFragmentTabHost4 = this.cow.coi;
            qVar.a(j, bm, bn, scrollFragmentTabHost4.bo(j));
        }
    }
}
