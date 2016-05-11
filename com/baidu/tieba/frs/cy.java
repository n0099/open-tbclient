package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes.dex */
class cy extends CustomMessageListener {
    final /* synthetic */ FrsMoreFeedForumsActivity bkA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cy(FrsMoreFeedForumsActivity frsMoreFeedForumsActivity, int i) {
        super(i);
        this.bkA = frsMoreFeedForumsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        cz czVar;
        List<FeedForumData> list;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.y)) {
            czVar = this.bkA.bky;
            list = this.bkA.biJ;
            czVar.a(list, (com.baidu.tieba.tbadkCore.y) customResponsedMessage.getData());
        }
    }
}
