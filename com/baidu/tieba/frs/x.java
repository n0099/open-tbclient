package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class x extends CustomMessageListener {
    final /* synthetic */ FrsActivity aJG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(FrsActivity frsActivity, int i) {
        super(i);
        this.aJG = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bf bfVar;
        bf bfVar2;
        bf bfVar3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.coreExtra.data.h)) {
            com.baidu.tbadk.coreExtra.data.h hVar = (com.baidu.tbadk.coreExtra.data.h) customResponsedMessage.getData();
            if (!TextUtils.isEmpty(hVar.userId) && !TextUtils.isEmpty(hVar.userName)) {
                bfVar = this.aJG.aIS;
                if (bfVar != null) {
                    bfVar2 = this.aJG.aIS;
                    if (bfVar2.Kk() != null) {
                        bfVar3 = this.aJG.aIS;
                        bfVar3.Kk().al(hVar.userId, hVar.userName);
                    }
                }
            }
        }
    }
}
