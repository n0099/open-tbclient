package com.baidu.tieba.homepage.framework;

import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.framework.q;
import com.baidu.tieba.u;
import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements q.a {
    final /* synthetic */ RecommendFrsControlFragment cow;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.cow = recommendFrsControlFragment;
    }

    @Override // com.baidu.tieba.homepage.framework.q.a
    public void a(boolean z, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2, long j, String str, boolean z3) {
        long j2;
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        if (z) {
            this.cow.agm();
        }
        if (z) {
            scrollFragmentTabHost3 = this.cow.coi;
            if (!scrollFragmentTabHost3.agA() && cVar != null && cVar.isEmpty()) {
                if (this.cow.getPageContext() == null || this.cow.getPageContext().getResources() == null) {
                    return;
                }
                this.cow.B(this.cow.getPageContext().getResources().getString(u.j.neterror), false);
                return;
            }
        }
        if (z3) {
            scrollFragmentTabHost2 = this.cow.coi;
            j2 = scrollFragmentTabHost2.f(j, str);
        } else {
            j2 = j;
        }
        scrollFragmentTabHost = this.cow.coi;
        scrollFragmentTabHost.b(z, j2, cVar, z2);
    }

    @Override // com.baidu.tieba.homepage.framework.q.a
    public void a(long j, String str, String str2, int i, boolean z) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        this.cow.agm();
        scrollFragmentTabHost = this.cow.coi;
        if (!scrollFragmentTabHost.agA()) {
            if (this.cow.getPageContext() == null || this.cow.getPageContext().getResources() == null) {
                return;
            }
            this.cow.B(this.cow.getPageContext().getResources().getString(u.j.net_error_text, str2, Integer.valueOf(i)), false);
            return;
        }
        if (z) {
            scrollFragmentTabHost3 = this.cow.coi;
            j = scrollFragmentTabHost3.f(j, str);
        }
        scrollFragmentTabHost2 = this.cow.coi;
        scrollFragmentTabHost2.a(j, str2, i);
    }

    @Override // com.baidu.tieba.homepage.framework.q.a
    public void a(long j, DataRes dataRes, boolean z) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        this.cow.agm();
        this.cow.IM();
        scrollFragmentTabHost = this.cow.coi;
        scrollFragmentTabHost.c(j, dataRes, z);
    }
}
