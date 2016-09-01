package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ab extends CustomMessageListener {
    final /* synthetic */ FrsActivity bQp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(FrsActivity frsActivity, int i) {
        super(i);
        this.bQp = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.bg)) {
            com.baidu.tbadk.core.data.bg bgVar = (com.baidu.tbadk.core.data.bg) customResponsedMessage.getData();
            this.bQp.bOY = bgVar.getId();
            str = this.bQp.bOY;
            if (TextUtils.isEmpty(str) || bgVar.rt() == null) {
                return;
            }
            this.bQp.hO(bgVar.rt().getIsLike());
        }
    }
}
