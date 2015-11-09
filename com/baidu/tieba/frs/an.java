package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class an extends CustomMessageListener {
    final /* synthetic */ FrsActivity aUS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public an(FrsActivity frsActivity, int i) {
        super(i);
        this.aUS = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bs bsVar;
        bs bsVar2;
        bs bsVar3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.coreExtra.data.i)) {
            com.baidu.tbadk.coreExtra.data.i iVar = (com.baidu.tbadk.coreExtra.data.i) customResponsedMessage.getData();
            if (!TextUtils.isEmpty(iVar.userId) && !TextUtils.isEmpty(iVar.userName)) {
                bsVar = this.aUS.aUc;
                if (bsVar != null) {
                    bsVar2 = this.aUS.aUc;
                    if (bsVar2.Ml() != null) {
                        bsVar3 = this.aUS.aUc;
                        bsVar3.Ml().an(iVar.userId, iVar.userName);
                    }
                }
            }
        }
    }
}
