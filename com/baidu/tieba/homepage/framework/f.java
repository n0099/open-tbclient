package com.baidu.tieba.homepage.framework;

import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.framework.q;
import com.baidu.tieba.r;
import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements q.a {
    final /* synthetic */ RecommendFrsControlFragment cCw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.cCw = recommendFrsControlFragment;
    }

    @Override // com.baidu.tieba.homepage.framework.q.a
    public void a(boolean z, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2, long j, String str, boolean z3) {
        long j2;
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        if (z) {
            this.cCw.alO();
        }
        if (z) {
            scrollFragmentTabHost3 = this.cCw.cCi;
            if (!scrollFragmentTabHost3.amd() && cVar != null && cVar.isEmpty()) {
                if (this.cCw.getPageContext() == null || this.cCw.getPageContext().getResources() == null) {
                    return;
                }
                this.cCw.G(this.cCw.getPageContext().getResources().getString(r.j.neterror), false);
                return;
            }
        }
        if (z3) {
            scrollFragmentTabHost2 = this.cCw.cCi;
            j2 = scrollFragmentTabHost2.i(j, str);
        } else {
            j2 = j;
        }
        scrollFragmentTabHost = this.cCw.cCi;
        scrollFragmentTabHost.b(z, j2, cVar, z2);
    }

    @Override // com.baidu.tieba.homepage.framework.q.a
    public void a(long j, String str, String str2, int i, boolean z) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        this.cCw.alO();
        scrollFragmentTabHost = this.cCw.cCi;
        if (!scrollFragmentTabHost.amd()) {
            if (this.cCw.getPageContext() == null || this.cCw.getPageContext().getResources() == null) {
                return;
            }
            this.cCw.G(this.cCw.getPageContext().getResources().getString(r.j.net_error_text, str2, Integer.valueOf(i)), false);
            return;
        }
        if (z) {
            scrollFragmentTabHost3 = this.cCw.cCi;
            j = scrollFragmentTabHost3.i(j, str);
        }
        scrollFragmentTabHost2 = this.cCw.cCi;
        scrollFragmentTabHost2.a(j, str2, i);
    }

    @Override // com.baidu.tieba.homepage.framework.q.a
    public void a(long j, DataRes dataRes, boolean z) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        this.cCw.alO();
        this.cCw.JJ();
        scrollFragmentTabHost = this.cCw.cCi;
        scrollFragmentTabHost.c(j, dataRes, z);
    }
}
