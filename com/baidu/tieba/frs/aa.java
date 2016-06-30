package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class aa extends CustomMessageListener {
    final /* synthetic */ FrsActivity bDB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(FrsActivity frsActivity, int i) {
        super(i);
        this.bDB = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.az)) {
            com.baidu.tbadk.core.data.az azVar = (com.baidu.tbadk.core.data.az) customResponsedMessage.getData();
            this.bDB.bBg = azVar.getId();
            str = this.bDB.bBg;
            if (TextUtils.isEmpty(str) || azVar.getPraise() == null) {
                return;
            }
            this.bDB.hi(azVar.getPraise().getIsLike());
        }
    }
}
