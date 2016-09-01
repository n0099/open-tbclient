package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class l extends CustomMessageListener {
    final /* synthetic */ FrsActivity bQp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(FrsActivity frsActivity, int i) {
        super(i);
        this.bQp = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null) {
            String str = (String) customResponsedMessage.getData();
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.core.util.bi.vx().c(this.bQp.getPageContext(), new String[]{str});
            }
        }
    }
}
