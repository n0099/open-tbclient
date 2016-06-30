package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ap extends CustomMessageListener {
    final /* synthetic */ FrsActivity bDB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(FrsActivity frsActivity, int i) {
        super(i);
        this.bDB = frsActivity;
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
                bqVar = this.bDB.bCD;
                if (bqVar != null) {
                    bqVar2 = this.bDB.bCD;
                    if (bqVar2.Ww() != null) {
                        bqVar3 = this.bDB.bCD;
                        bqVar3.Ww().av(lVar.userId, lVar.userName);
                    }
                }
            }
        }
    }
}
