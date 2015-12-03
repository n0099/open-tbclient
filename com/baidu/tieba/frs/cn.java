package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes.dex */
class cn extends CustomMessageListener {
    final /* synthetic */ FrsMoreFeedForumsActivity bdj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cn(FrsMoreFeedForumsActivity frsMoreFeedForumsActivity, int i) {
        super(i);
        this.bdj = frsMoreFeedForumsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        co coVar;
        List<FeedForumData> list;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.y)) {
            coVar = this.bdj.bdh;
            list = this.bdj.bbP;
            coVar.a(list, (com.baidu.tieba.tbadkCore.y) customResponsedMessage.getData());
        }
    }
}
