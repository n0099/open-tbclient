package com.baidu.tieba.homepage.framework;

import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class u extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public u(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.mainTab.c EF;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
            RecommendFrsDelegateStatic recommendFrsDelegateStatic = new RecommendFrsDelegateStatic();
            ((com.baidu.tbadk.mainTab.e) customResponsedMessage.getData()).a(recommendFrsDelegateStatic);
            if (((com.baidu.tbadk.mainTab.e) customResponsedMessage.getData()).getContext() != null && (EF = recommendFrsDelegateStatic.EF()) != null) {
                EF.azI.setArguments(new Bundle());
            }
        }
    }
}
