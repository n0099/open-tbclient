package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ao extends CustomMessageListener {
    final /* synthetic */ FrsActivity bed;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ao(FrsActivity frsActivity, int i) {
        super(i);
        this.bed = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.coreExtra.data.k)) {
            com.baidu.tbadk.coreExtra.data.k kVar = (com.baidu.tbadk.coreExtra.data.k) customResponsedMessage.getData();
            if (!TextUtils.isEmpty(kVar.userId) && !TextUtils.isEmpty(kVar.userName) && this.bed.bdm != null && this.bed.bdm.Of() != null) {
                this.bed.bdm.Of().ao(kVar.userId, kVar.userName);
            }
        }
    }
}
