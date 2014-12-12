package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class x extends CustomMessageListener {
    final /* synthetic */ FrsActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(FrsActivity frsActivity, int i) {
        super(i);
        this.aCV = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.coreExtra.data.h)) {
            com.baidu.tbadk.coreExtra.data.h hVar = (com.baidu.tbadk.coreExtra.data.h) customResponsedMessage.getData();
            if (!TextUtils.isEmpty(hVar.userId) && !TextUtils.isEmpty(hVar.userName)) {
                bqVar = this.aCV.aBX;
                if (bqVar != null) {
                    bqVar2 = this.aCV.aBX;
                    if (bqVar2.GO() != null) {
                        bqVar3 = this.aCV.aBX;
                        bqVar3.GO().am(hVar.userId, hVar.userName);
                    }
                }
            }
        }
    }
}
