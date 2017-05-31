package com.baidu.tieba.homepage.framework;

import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.framework.q;
import com.baidu.tieba.w;
import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements q.a {
    final /* synthetic */ RecommendFrsControlFragment czI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.czI = recommendFrsControlFragment;
    }

    @Override // com.baidu.tieba.homepage.framework.q.a
    public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
    }

    @Override // com.baidu.tieba.homepage.framework.q.a
    public void a(String str, String str2, int i, boolean z) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        this.czI.ait();
        scrollFragmentTabHost = this.czI.czu;
        if (scrollFragmentTabHost.aiD()) {
            scrollFragmentTabHost2 = this.czI.czu;
            scrollFragmentTabHost2.M(str2, i);
        } else if (this.czI.getPageContext() == null || this.czI.getPageContext().getResources() == null) {
        } else {
            this.czI.E(this.czI.getPageContext().getResources().getString(w.l.net_error_text, str2, Integer.valueOf(i)), false);
        }
    }

    @Override // com.baidu.tieba.homepage.framework.q.a
    public void a(DataRes dataRes, boolean z, boolean z2) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        this.czI.ait();
        this.czI.Mx();
        scrollFragmentTabHost = this.czI.czu;
        scrollFragmentTabHost.c(dataRes, z, z2);
    }
}
