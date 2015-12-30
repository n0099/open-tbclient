package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes.dex */
class cq extends CustomMessageListener {
    final /* synthetic */ FrsMoreFeedForumsActivity bhj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cq(FrsMoreFeedForumsActivity frsMoreFeedForumsActivity, int i) {
        super(i);
        this.bhj = frsMoreFeedForumsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        cr crVar;
        List<FeedForumData> list;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.y)) {
            crVar = this.bhj.bhh;
            list = this.bhj.bfO;
            crVar.a(list, (com.baidu.tieba.tbadkCore.y) customResponsedMessage.getData());
        }
    }
}
