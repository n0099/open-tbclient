package com.baidu.tieba.homepage.framework;

import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.framework.q;
import com.baidu.tieba.w;
import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements q.a {
    final /* synthetic */ RecommendFrsControlFragment cvC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.cvC = recommendFrsControlFragment;
    }

    @Override // com.baidu.tieba.homepage.framework.q.a
    public void a(boolean z, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2, long j, String str, boolean z3) {
        long j2;
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        if (z) {
            this.cvC.aiD();
        }
        if (z) {
            scrollFragmentTabHost3 = this.cvC.cvo;
            if (!scrollFragmentTabHost3.aiS() && cVar != null && cVar.isEmpty()) {
                if (this.cvC.getPageContext() == null || this.cvC.getPageContext().getResources() == null) {
                    return;
                }
                this.cvC.H(this.cvC.getPageContext().getResources().getString(w.l.neterror), false);
                return;
            }
        }
        if (z3) {
            scrollFragmentTabHost2 = this.cvC.cvo;
            j2 = scrollFragmentTabHost2.f(j, str);
        } else {
            j2 = j;
        }
        scrollFragmentTabHost = this.cvC.cvo;
        scrollFragmentTabHost.b(z, j2, cVar, z2);
    }

    @Override // com.baidu.tieba.homepage.framework.q.a
    public void a(long j, String str, String str2, int i, boolean z) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        this.cvC.aiD();
        scrollFragmentTabHost = this.cvC.cvo;
        if (!scrollFragmentTabHost.aiS()) {
            if (this.cvC.getPageContext() == null || this.cvC.getPageContext().getResources() == null) {
                return;
            }
            this.cvC.H(this.cvC.getPageContext().getResources().getString(w.l.net_error_text, str2, Integer.valueOf(i)), false);
            return;
        }
        if (z) {
            scrollFragmentTabHost3 = this.cvC.cvo;
            j = scrollFragmentTabHost3.f(j, str);
        }
        scrollFragmentTabHost2 = this.cvC.cvo;
        scrollFragmentTabHost2.a(j, str2, i);
    }

    @Override // com.baidu.tieba.homepage.framework.q.a
    public void a(long j, DataRes dataRes, boolean z) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        this.cvC.aiD();
        this.cvC.Kd();
        scrollFragmentTabHost = this.cvC.cvo;
        scrollFragmentTabHost.c(j, dataRes, z);
    }
}
