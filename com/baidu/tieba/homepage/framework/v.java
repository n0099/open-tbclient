package com.baidu.tieba.homepage.framework;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
/* loaded from: classes.dex */
class v extends CustomMessageListener {
    final /* synthetic */ RecommendFrsDelegateStatic coM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(RecommendFrsDelegateStatic recommendFrsDelegateStatic, int i) {
        super(i);
        this.coM = recommendFrsDelegateStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        FragmentTabIndicator fragmentTabIndicator;
        ImageView imageView;
        ImageView imageView2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016325 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            fragmentTabIndicator = this.coM.avz;
            FragmentTabIndicator.a fZ = fragmentTabIndicator.fZ("godFeed");
            if (fZ != null) {
                if (intValue <= 0) {
                    imageView2 = this.coM.coK;
                    imageView2.setVisibility(8);
                    return;
                }
                imageView = this.coM.coK;
                imageView.setVisibility(0);
                fZ.cX(TbadkCoreApplication.m9getInst().getSkinType());
            }
        }
    }
}
