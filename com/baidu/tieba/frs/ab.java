package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ab extends CustomMessageListener {
    final /* synthetic */ FrsActivity bQi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(FrsActivity frsActivity, int i) {
        super(i);
        this.bQi = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.bi)) {
            com.baidu.tbadk.core.data.bi biVar = (com.baidu.tbadk.core.data.bi) customResponsedMessage.getData();
            this.bQi.bOS = biVar.getId();
            str = this.bQi.bOS;
            if (TextUtils.isEmpty(str) || biVar.rF() == null) {
                return;
            }
            this.bQi.hS(biVar.rF().getIsLike());
        }
    }
}
