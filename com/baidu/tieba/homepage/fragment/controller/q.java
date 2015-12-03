package com.baidu.tieba.homepage.fragment.controller;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class q extends CustomMessageListener {
    final /* synthetic */ p byf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(p pVar, int i) {
        super(i);
        this.byf = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ImageView imageView;
        boolean z;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007004 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.mainTab.a)) {
            this.byf.auC = ((com.baidu.tbadk.mainTab.a) customResponsedMessage.getData()).avE;
            imageView = this.byf.aOe;
            z = this.byf.auC;
            imageView.setVisibility(z ? 0 : 8);
        }
    }
}
