package com.baidu.tieba.frs.frsgood;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class n extends CustomMessageListener {
    final /* synthetic */ FrsGoodActivity bgy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(FrsGoodActivity frsGoodActivity, int i) {
        super(i);
        this.bgy = frsGoodActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.z)) {
            com.baidu.tbadk.core.data.z zVar = (com.baidu.tbadk.core.data.z) customResponsedMessage.getData();
            this.bgy.aXW = zVar.getId();
            str = this.bgy.aXW;
            if (TextUtils.isEmpty(str) || zVar.getPraise() == null) {
                return;
            }
            this.bgy.fU(zVar.getPraise().getIsLike());
        }
    }
}
