package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ai extends CustomMessageListener {
    final /* synthetic */ FrsActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(FrsActivity frsActivity, int i) {
        super(i);
        this.this$0 = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bl blVar;
        bl blVar2;
        if (customResponsedMessage != null) {
            blVar = this.this$0.aUw;
            if (blVar != null) {
                blVar2 = this.this$0.aUw;
                blVar2.ny();
            }
        }
    }
}
