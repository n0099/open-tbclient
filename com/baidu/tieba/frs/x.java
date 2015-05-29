package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class x extends CustomMessageListener {
    final /* synthetic */ FrsActivity aLX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(FrsActivity frsActivity, int i) {
        super(i);
        this.aLX = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bf bfVar;
        bf bfVar2;
        bf bfVar3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.coreExtra.data.i)) {
            com.baidu.tbadk.coreExtra.data.i iVar = (com.baidu.tbadk.coreExtra.data.i) customResponsedMessage.getData();
            if (!TextUtils.isEmpty(iVar.userId) && !TextUtils.isEmpty(iVar.userName)) {
                bfVar = this.aLX.aLi;
                if (bfVar != null) {
                    bfVar2 = this.aLX.aLi;
                    if (bfVar2.Lw() != null) {
                        bfVar3 = this.aLX.aLi;
                        bfVar3.Lw().aq(iVar.userId, iVar.userName);
                    }
                }
            }
        }
    }
}
