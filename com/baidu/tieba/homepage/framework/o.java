package com.baidu.tieba.homepage.framework;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends CustomMessageListener {
    final /* synthetic */ RecommendFrsControlFragment cHu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(RecommendFrsControlFragment recommendFrsControlFragment, int i) {
        super(i);
        this.cHu = recommendFrsControlFragment;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bf)) {
            bf bfVar = (bf) customResponsedMessage.getData();
            scrollFragmentTabHost = this.cHu.cHg;
            scrollFragmentTabHost.P(bfVar.getForumName(), bfVar.qN());
        }
    }
}
