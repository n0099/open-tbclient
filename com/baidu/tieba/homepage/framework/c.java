package com.baidu.tieba.homepage.framework;

import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements NoNetworkView.a {
    final /* synthetic */ RecommendFrsControlFragment ctq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.ctq = recommendFrsControlFragment;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aL(boolean z) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        if (z && this.ctq.isPrimary()) {
            scrollFragmentTabHost = this.ctq.ctc;
            scrollFragmentTabHost.ahk();
        }
    }
}
