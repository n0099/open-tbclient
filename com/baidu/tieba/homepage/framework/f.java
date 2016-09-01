package com.baidu.tieba.homepage.framework;

import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.framework.q;
import com.baidu.tieba.t;
import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements q.a {
    final /* synthetic */ RecommendFrsControlFragment cBR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.cBR = recommendFrsControlFragment;
    }

    @Override // com.baidu.tieba.homepage.framework.q.a
    public void a(boolean z, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2, long j, String str, boolean z3) {
        long j2;
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        if (z) {
            this.cBR.alA();
        }
        if (z) {
            scrollFragmentTabHost3 = this.cBR.cBE;
            if (!scrollFragmentTabHost3.alP() && cVar != null && cVar.isEmpty()) {
                if (this.cBR.getPageContext() == null || this.cBR.getPageContext().getResources() == null) {
                    return;
                }
                this.cBR.F(this.cBR.getPageContext().getResources().getString(t.j.neterror), false);
                return;
            }
        }
        if (z3) {
            scrollFragmentTabHost2 = this.cBR.cBE;
            j2 = scrollFragmentTabHost2.i(j, str);
        } else {
            j2 = j;
        }
        scrollFragmentTabHost = this.cBR.cBE;
        scrollFragmentTabHost.b(z, j2, cVar, z2);
    }

    @Override // com.baidu.tieba.homepage.framework.q.a
    public void a(long j, String str, String str2, int i, boolean z) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        this.cBR.alA();
        scrollFragmentTabHost = this.cBR.cBE;
        if (!scrollFragmentTabHost.alP()) {
            if (this.cBR.getPageContext() == null || this.cBR.getPageContext().getResources() == null) {
                return;
            }
            this.cBR.F(this.cBR.getPageContext().getResources().getString(t.j.net_error_text, str2, Integer.valueOf(i)), false);
            return;
        }
        if (z) {
            scrollFragmentTabHost3 = this.cBR.cBE;
            j = scrollFragmentTabHost3.i(j, str);
        }
        scrollFragmentTabHost2 = this.cBR.cBE;
        scrollFragmentTabHost2.a(j, str2, i);
    }

    @Override // com.baidu.tieba.homepage.framework.q.a
    public void a(long j, DataRes dataRes, boolean z) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        this.cBR.alA();
        this.cBR.La();
        scrollFragmentTabHost = this.cBR.cBE;
        scrollFragmentTabHost.c(j, dataRes, z);
    }
}
