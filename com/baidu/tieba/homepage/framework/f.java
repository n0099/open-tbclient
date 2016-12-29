package com.baidu.tieba.homepage.framework;

import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.framework.q;
import com.baidu.tieba.r;
import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements q.a {
    final /* synthetic */ RecommendFrsControlFragment cnd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.cnd = recommendFrsControlFragment;
    }

    @Override // com.baidu.tieba.homepage.framework.q.a
    public void a(boolean z, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2, long j, String str, boolean z3) {
        long j2;
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        if (z) {
            this.cnd.aij();
        }
        if (z) {
            scrollFragmentTabHost3 = this.cnd.cmP;
            if (!scrollFragmentTabHost3.aiy() && cVar != null && cVar.isEmpty()) {
                if (this.cnd.getPageContext() == null || this.cnd.getPageContext().getResources() == null) {
                    return;
                }
                this.cnd.H(this.cnd.getPageContext().getResources().getString(r.j.neterror), false);
                return;
            }
        }
        if (z3) {
            scrollFragmentTabHost2 = this.cnd.cmP;
            j2 = scrollFragmentTabHost2.i(j, str);
        } else {
            j2 = j;
        }
        scrollFragmentTabHost = this.cnd.cmP;
        scrollFragmentTabHost.b(z, j2, cVar, z2);
    }

    @Override // com.baidu.tieba.homepage.framework.q.a
    public void a(long j, String str, String str2, int i, boolean z) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        this.cnd.aij();
        scrollFragmentTabHost = this.cnd.cmP;
        if (!scrollFragmentTabHost.aiy()) {
            if (this.cnd.getPageContext() == null || this.cnd.getPageContext().getResources() == null) {
                return;
            }
            this.cnd.H(this.cnd.getPageContext().getResources().getString(r.j.net_error_text, str2, Integer.valueOf(i)), false);
            return;
        }
        if (z) {
            scrollFragmentTabHost3 = this.cnd.cmP;
            j = scrollFragmentTabHost3.i(j, str);
        }
        scrollFragmentTabHost2 = this.cnd.cmP;
        scrollFragmentTabHost2.a(j, str2, i);
    }

    @Override // com.baidu.tieba.homepage.framework.q.a
    public void a(long j, DataRes dataRes, boolean z) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        this.cnd.aij();
        this.cnd.Jk();
        scrollFragmentTabHost = this.cnd.cmP;
        scrollFragmentTabHost.c(j, dataRes, z);
    }
}
