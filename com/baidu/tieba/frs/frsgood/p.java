package com.baidu.tieba.frs.frsgood;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class p extends CustomMessageListener {
    final /* synthetic */ FrsGoodActivity aZp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(FrsGoodActivity frsGoodActivity, int i) {
        super(i);
        this.aZp = frsGoodActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.aZp.aZj != null) {
            this.aZp.aZj.ny();
        }
    }
}
