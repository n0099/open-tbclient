package com.baidu.tieba.homepage.personalize.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends CustomMessageListener {
    final /* synthetic */ ac cGG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(ac acVar, int i) {
        super(i);
        this.cGG = acVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
        if (updateAttentionMessage == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().vS) {
            return;
        }
        this.cGG.K(updateAttentionMessage.getData());
    }
}
