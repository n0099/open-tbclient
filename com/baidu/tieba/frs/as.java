package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class as extends CustomMessageListener {
    final /* synthetic */ FrsActivity blk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public as(FrsActivity frsActivity, int i) {
        super(i);
        this.blk = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.coreExtra.data.k)) {
            com.baidu.tbadk.coreExtra.data.k kVar = (com.baidu.tbadk.coreExtra.data.k) customResponsedMessage.getData();
            if (!TextUtils.isEmpty(kVar.userId) && !TextUtils.isEmpty(kVar.userName) && this.blk.bko != null && this.blk.bko.Sb() != null) {
                this.blk.bko.Sb().av(kVar.userId, kVar.userName);
            }
        }
    }
}
