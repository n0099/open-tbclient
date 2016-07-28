package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ap extends CustomMessageListener {
    final /* synthetic */ FrsActivity bEL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(FrsActivity frsActivity, int i) {
        super(i);
        this.bEL = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.coreExtra.data.l)) {
            com.baidu.tbadk.coreExtra.data.l lVar = (com.baidu.tbadk.coreExtra.data.l) customResponsedMessage.getData();
            if (!TextUtils.isEmpty(lVar.userId) && !TextUtils.isEmpty(lVar.userName)) {
                bqVar = this.bEL.bDK;
                if (bqVar != null) {
                    bqVar2 = this.bEL.bDK;
                    if (bqVar2.WN() != null) {
                        bqVar3 = this.bEL.bDK;
                        bqVar3.WN().av(lVar.userId, lVar.userName);
                    }
                }
            }
        }
    }
}
