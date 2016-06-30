package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class e extends CustomMessageListener {
    final /* synthetic */ FrsActivity bDB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(FrsActivity frsActivity, int i) {
        super(i);
        this.bDB = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bq bqVar;
        bq bqVar2;
        if (customResponsedMessage != null) {
            bqVar = this.bDB.bCD;
            if (bqVar != null) {
                bqVar2 = this.bDB.bCD;
                bqVar2.jB();
            }
        }
    }
}
