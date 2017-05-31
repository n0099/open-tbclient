package com.baidu.tieba.homepage.framework;

import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements NoNetworkView.a {
    final /* synthetic */ RecommendFrsControlFragment czI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.czI = recommendFrsControlFragment;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aK(boolean z) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        if (z && this.czI.isPrimary()) {
            scrollFragmentTabHost = this.czI.czu;
            scrollFragmentTabHost.aiz();
        }
    }
}
