package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes.dex */
class cx extends CustomMessageListener {
    final /* synthetic */ FrsMoreFeedForumsActivity bjY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cx(FrsMoreFeedForumsActivity frsMoreFeedForumsActivity, int i) {
        super(i);
        this.bjY = frsMoreFeedForumsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        cy cyVar;
        List<FeedForumData> list;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.x)) {
            cyVar = this.bjY.bjW;
            list = this.bjY.biw;
            cyVar.a(list, (com.baidu.tieba.tbadkCore.x) customResponsedMessage.getData());
        }
    }
}
