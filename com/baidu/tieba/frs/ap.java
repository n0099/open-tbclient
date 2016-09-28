package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ap extends CustomMessageListener {
    final /* synthetic */ FrsActivity bQi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(FrsActivity frsActivity, int i) {
        super(i);
        this.bQi = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.coreExtra.data.o)) {
            com.baidu.tbadk.coreExtra.data.o oVar = (com.baidu.tbadk.coreExtra.data.o) customResponsedMessage.getData();
            if (!TextUtils.isEmpty(oVar.userId) && !TextUtils.isEmpty(oVar.userName)) {
                bmVar = this.bQi.bPi;
                if (bmVar != null) {
                    bmVar2 = this.bQi.bPi;
                    if (bmVar2.abW() != null) {
                        bmVar3 = this.bQi.bPi;
                        bmVar3.abW().aw(oVar.userId, oVar.userName);
                    }
                }
            }
        }
    }
}
