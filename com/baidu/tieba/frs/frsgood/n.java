package com.baidu.tieba.frs.frsgood;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class n extends CustomMessageListener {
    final /* synthetic */ FrsGoodActivity aZB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(FrsGoodActivity frsGoodActivity, int i) {
        super(i);
        this.aZB = frsGoodActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.v)) {
            com.baidu.tbadk.core.data.v vVar = (com.baidu.tbadk.core.data.v) customResponsedMessage.getData();
            this.aZB.aSp = vVar.getId();
            str = this.aZB.aSp;
            if (TextUtils.isEmpty(str) || vVar.getPraise() == null) {
                return;
            }
            this.aZB.fp(vVar.getPraise().getIsLike());
        }
    }
}
