package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes.dex */
class dc extends CustomMessageListener {
    final /* synthetic */ FrsMoreFeedForumsActivity bph;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dc(FrsMoreFeedForumsActivity frsMoreFeedForumsActivity, int i) {
        super(i);
        this.bph = frsMoreFeedForumsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        dd ddVar;
        List<FeedForumData> list;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.x)) {
            ddVar = this.bph.bpf;
            list = this.bph.bnh;
            ddVar.a(list, (com.baidu.tieba.tbadkCore.x) customResponsedMessage.getData());
        }
    }
}
