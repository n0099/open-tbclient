package com.baidu.tieba.homepage.framework;

import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.framework.q;
import com.baidu.tieba.r;
import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements q.a {
    final /* synthetic */ RecommendFrsControlFragment cud;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.cud = recommendFrsControlFragment;
    }

    @Override // com.baidu.tieba.homepage.framework.q.a
    public void a(boolean z, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2, long j, String str, boolean z3) {
        long j2;
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        if (z) {
            this.cud.ajq();
        }
        if (z) {
            scrollFragmentTabHost3 = this.cud.ctP;
            if (!scrollFragmentTabHost3.ajG() && cVar != null && cVar.isEmpty()) {
                if (this.cud.getPageContext() == null || this.cud.getPageContext().getResources() == null) {
                    return;
                }
                this.cud.G(this.cud.getPageContext().getResources().getString(r.l.neterror), false);
                return;
            }
        }
        if (z3) {
            scrollFragmentTabHost2 = this.cud.ctP;
            j2 = scrollFragmentTabHost2.f(j, str);
        } else {
            j2 = j;
        }
        scrollFragmentTabHost = this.cud.ctP;
        scrollFragmentTabHost.b(z, j2, cVar, z2);
    }

    @Override // com.baidu.tieba.homepage.framework.q.a
    public void a(long j, String str, String str2, int i, boolean z) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        this.cud.ajq();
        scrollFragmentTabHost = this.cud.ctP;
        if (!scrollFragmentTabHost.ajG()) {
            if (this.cud.getPageContext() == null || this.cud.getPageContext().getResources() == null) {
                return;
            }
            this.cud.G(this.cud.getPageContext().getResources().getString(r.l.net_error_text, str2, Integer.valueOf(i)), false);
            return;
        }
        if (z) {
            scrollFragmentTabHost3 = this.cud.ctP;
            j = scrollFragmentTabHost3.f(j, str);
        }
        scrollFragmentTabHost2 = this.cud.ctP;
        scrollFragmentTabHost2.a(j, str2, i);
    }

    @Override // com.baidu.tieba.homepage.framework.q.a
    public void a(long j, DataRes dataRes, boolean z) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        this.cud.ajq();
        this.cud.Jy();
        scrollFragmentTabHost = this.cud.ctP;
        scrollFragmentTabHost.c(j, dataRes, z);
    }
}
