package com.baidu.tieba.homepage.framework;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
/* loaded from: classes.dex */
class t extends CustomMessageListener {
    final /* synthetic */ RecommendFrsDelegateStatic ctx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(RecommendFrsDelegateStatic recommendFrsDelegateStatic, int i) {
        super(i);
        this.ctx = recommendFrsDelegateStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        FragmentTabIndicator fragmentTabIndicator;
        ImageView imageView;
        ImageView imageView2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016325 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            fragmentTabIndicator = this.ctx.aDV;
            FragmentTabIndicator.a fS = fragmentTabIndicator.fS("godFeed");
            if (fS != null) {
                if (intValue <= 0) {
                    imageView2 = this.ctx.ctv;
                    imageView2.setVisibility(8);
                    return;
                }
                imageView = this.ctx.ctv;
                imageView.setVisibility(0);
                fS.dm(TbadkCoreApplication.m9getInst().getSkinType());
            }
        }
    }
}
