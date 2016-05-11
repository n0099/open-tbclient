package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class z extends CustomMessageListener {
    final /* synthetic */ FrsActivity bhl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(FrsActivity frsActivity, int i) {
        super(i);
        this.bhl = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ax)) {
            com.baidu.tbadk.core.data.ax axVar = (com.baidu.tbadk.core.data.ax) customResponsedMessage.getData();
            this.bhl.beT = axVar.getId();
            str = this.bhl.beT;
            if (TextUtils.isEmpty(str) || axVar.getPraise() == null) {
                return;
            }
            this.bhl.gh(axVar.getPraise().getIsLike());
        }
    }
}
