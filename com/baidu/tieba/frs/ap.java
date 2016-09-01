package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ap extends CustomMessageListener {
    final /* synthetic */ FrsActivity bQp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(FrsActivity frsActivity, int i) {
        super(i);
        this.bQp = frsActivity;
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
                bmVar = this.bQp.bPo;
                if (bmVar != null) {
                    bmVar2 = this.bQp.bPo;
                    if (bmVar2.abJ() != null) {
                        bmVar3 = this.bQp.bPo;
                        bmVar3.abJ().aw(oVar.userId, oVar.userName);
                    }
                }
            }
        }
    }
}
