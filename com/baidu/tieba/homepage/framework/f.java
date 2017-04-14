package com.baidu.tieba.homepage.framework;

import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.framework.q;
import com.baidu.tieba.w;
import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements q.a {
    final /* synthetic */ RecommendFrsControlFragment cuc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.cuc = recommendFrsControlFragment;
    }

    @Override // com.baidu.tieba.homepage.framework.q.a
    public void a(boolean z, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2, long j, String str, boolean z3) {
        long j2;
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        if (z) {
            this.cuc.aix();
        }
        if (z) {
            scrollFragmentTabHost3 = this.cuc.ctO;
            if (!scrollFragmentTabHost3.aiM() && cVar != null && cVar.isEmpty()) {
                if (this.cuc.getPageContext() == null || this.cuc.getPageContext().getResources() == null) {
                    return;
                }
                this.cuc.H(this.cuc.getPageContext().getResources().getString(w.l.neterror), false);
                return;
            }
        }
        if (z3) {
            scrollFragmentTabHost2 = this.cuc.ctO;
            j2 = scrollFragmentTabHost2.f(j, str);
        } else {
            j2 = j;
        }
        scrollFragmentTabHost = this.cuc.ctO;
        scrollFragmentTabHost.b(z, j2, cVar, z2);
    }

    @Override // com.baidu.tieba.homepage.framework.q.a
    public void a(long j, String str, String str2, int i, boolean z) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        this.cuc.aix();
        scrollFragmentTabHost = this.cuc.ctO;
        if (!scrollFragmentTabHost.aiM()) {
            if (this.cuc.getPageContext() == null || this.cuc.getPageContext().getResources() == null) {
                return;
            }
            this.cuc.H(this.cuc.getPageContext().getResources().getString(w.l.net_error_text, str2, Integer.valueOf(i)), false);
            return;
        }
        if (z) {
            scrollFragmentTabHost3 = this.cuc.ctO;
            j = scrollFragmentTabHost3.f(j, str);
        }
        scrollFragmentTabHost2 = this.cuc.ctO;
        scrollFragmentTabHost2.a(j, str2, i);
    }

    @Override // com.baidu.tieba.homepage.framework.q.a
    public void a(long j, DataRes dataRes, boolean z) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        this.cuc.aix();
        this.cuc.KD();
        scrollFragmentTabHost = this.cuc.ctO;
        scrollFragmentTabHost.c(j, dataRes, z);
    }
}
