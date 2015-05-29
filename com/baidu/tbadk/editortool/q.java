package com.baidu.tbadk.editortool;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends CustomMessageListener {
    final /* synthetic */ EmotionTabHost akb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(EmotionTabHost emotionTabHost, int i) {
        super(i);
        this.akb = emotionTabHost;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        switch (customResponsedMessage.getCmd()) {
            case 2001120:
                this.akb.reset();
                this.akb.setup();
                return;
            default:
                return;
        }
    }
}
