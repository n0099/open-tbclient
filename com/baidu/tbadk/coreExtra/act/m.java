package com.baidu.tbadk.coreExtra.act;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class m extends CustomMessageListener {
    final /* synthetic */ LoginActivity agE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(LoginActivity loginActivity, int i) {
        super(i);
        this.agE = loginActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.u)) {
            com.baidu.tbadk.core.data.u uVar = (com.baidu.tbadk.core.data.u) customResponsedMessage.getData();
            if (uVar.Vx == 0) {
                this.agE.wg();
            } else {
                this.agE.dA(uVar.errorMsg);
            }
        }
    }
}
