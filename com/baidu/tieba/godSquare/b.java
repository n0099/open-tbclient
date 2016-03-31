package com.baidu.tieba.godSquare;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* loaded from: classes.dex */
class b extends CustomMessageListener {
    final /* synthetic */ GodSquareActivity bJY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(GodSquareActivity godSquareActivity, int i) {
        super(i);
        this.bJY = godSquareActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.godSquare.model.b bVar;
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                long c = com.baidu.adp.lib.h.b.c(updateAttentionMessage.getData().toUid, 0L);
                bVar = this.bJY.bJV;
                if (bVar.aR(c)) {
                    this.bJY.bJW = true;
                }
            }
        }
    }
}
