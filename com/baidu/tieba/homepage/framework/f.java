package com.baidu.tieba.homepage.framework;

import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.framework.q;
import com.baidu.tieba.u;
import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements q.a {
    final /* synthetic */ RecommendFrsControlFragment cqJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.cqJ = recommendFrsControlFragment;
    }

    @Override // com.baidu.tieba.homepage.framework.q.a
    public void a(boolean z, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2, long j, String str, boolean z3) {
        long j2;
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        if (z) {
            this.cqJ.agP();
        }
        if (z) {
            scrollFragmentTabHost3 = this.cqJ.cqw;
            if (!scrollFragmentTabHost3.ahe() && cVar != null && cVar.isEmpty()) {
                if (this.cqJ.getPageContext() == null || this.cqJ.getPageContext().getResources() == null) {
                    return;
                }
                this.cqJ.B(this.cqJ.getPageContext().getResources().getString(u.j.neterror), false);
                return;
            }
        }
        if (z3) {
            scrollFragmentTabHost2 = this.cqJ.cqw;
            j2 = scrollFragmentTabHost2.f(j, str);
        } else {
            j2 = j;
        }
        scrollFragmentTabHost = this.cqJ.cqw;
        scrollFragmentTabHost.b(z, j2, cVar, z2);
    }

    @Override // com.baidu.tieba.homepage.framework.q.a
    public void a(long j, String str, String str2, int i, boolean z) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        this.cqJ.agP();
        scrollFragmentTabHost = this.cqJ.cqw;
        if (!scrollFragmentTabHost.ahe()) {
            if (this.cqJ.getPageContext() == null || this.cqJ.getPageContext().getResources() == null) {
                return;
            }
            this.cqJ.B(this.cqJ.getPageContext().getResources().getString(u.j.net_error_text, str2, Integer.valueOf(i)), false);
            return;
        }
        if (z) {
            scrollFragmentTabHost3 = this.cqJ.cqw;
            j = scrollFragmentTabHost3.f(j, str);
        }
        scrollFragmentTabHost2 = this.cqJ.cqw;
        scrollFragmentTabHost2.a(j, str2, i);
    }

    @Override // com.baidu.tieba.homepage.framework.q.a
    public void a(long j, DataRes dataRes, boolean z) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        this.cqJ.agP();
        this.cqJ.IL();
        scrollFragmentTabHost = this.cqJ.cqw;
        scrollFragmentTabHost.c(j, dataRes, z);
    }
}
