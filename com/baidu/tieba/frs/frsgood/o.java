package com.baidu.tieba.frs.frsgood;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.as;
/* loaded from: classes.dex */
class o extends CustomMessageListener {
    final /* synthetic */ FrsGoodActivity bsj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(FrsGoodActivity frsGoodActivity, int i) {
        super(i);
        this.bsj = frsGoodActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof as)) {
            as asVar = (as) customResponsedMessage.getData();
            this.bsj.biU = asVar.getId();
            str = this.bsj.biU;
            if (TextUtils.isEmpty(str) || asVar.getPraise() == null) {
                return;
            }
            this.bsj.gB(asVar.getPraise().getIsLike());
        }
    }
}
