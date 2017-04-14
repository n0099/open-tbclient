package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ b bXH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i) {
        super(i);
        this.bXH = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                if (!updateAttentionMessage.getData().Cy) {
                    if (updateAttentionMessage.getData().errorString != null) {
                        this.bXH.bST.showToast(updateAttentionMessage.getData().errorString);
                        return;
                    }
                    return;
                }
                this.bXH.b(updateAttentionMessage);
                this.bXH.bST.a(updateAttentionMessage);
                this.bXH.c(updateAttentionMessage);
            }
        }
    }
}
