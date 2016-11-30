package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class z extends CustomMessageListener {
    final /* synthetic */ FrsActivity bTa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(FrsActivity frsActivity, int i) {
        super(i);
        this.bTa = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.coreExtra.data.o)) {
            com.baidu.tbadk.coreExtra.data.o oVar = (com.baidu.tbadk.coreExtra.data.o) customResponsedMessage.getData();
            if (!TextUtils.isEmpty(oVar.userId) && !TextUtils.isEmpty(oVar.userName) && this.bTa.bRW != null && this.bTa.bRW.ade() != null) {
                this.bTa.bRW.ade().ax(oVar.userId, oVar.userName);
            }
        }
    }
}
