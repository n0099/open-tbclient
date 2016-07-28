package com.baidu.tieba.homepage.personalize.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends CustomMessageListener {
    final /* synthetic */ ad cvb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(ad adVar, int i) {
        super(i);
        this.cvb = adVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
        if (updateAttentionMessage == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().tF) {
            return;
        }
        this.cvb.H(updateAttentionMessage.getData());
    }
}
