package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class al extends CustomMessageListener {
    final /* synthetic */ FrsActivity bag;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public al(FrsActivity frsActivity, int i) {
        super(i);
        this.bag = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.coreExtra.data.k)) {
            com.baidu.tbadk.coreExtra.data.k kVar = (com.baidu.tbadk.coreExtra.data.k) customResponsedMessage.getData();
            if (!TextUtils.isEmpty(kVar.userId) && !TextUtils.isEmpty(kVar.userName) && this.bag.aZq != null && this.bag.aZq.NM() != null) {
                this.bag.aZq.NM().aq(kVar.userId, kVar.userName);
            }
        }
    }
}
