package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class g extends CustomMessageListener {
    final /* synthetic */ FrsActivity aBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(FrsActivity frsActivity, int i) {
        super(i);
        this.aBk = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.q)) {
            com.baidu.tbadk.core.data.q qVar = (com.baidu.tbadk.core.data.q) customResponsedMessage.getData();
            this.aBk.ayw = qVar.getId();
            str = this.aBk.ayw;
            if (TextUtils.isEmpty(str) || qVar.getPraise() == null) {
                return;
            }
            this.aBk.eD(qVar.getPraise().getIsLike());
        }
    }
}
