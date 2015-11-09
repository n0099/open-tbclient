package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.hottopic.a.n;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class j extends CustomMessageListener {
    final /* synthetic */ RelateTopicForumActivity bpt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(RelateTopicForumActivity relateTopicForumActivity, int i) {
        super(i);
        this.bpt = relateTopicForumActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList arrayList;
        RelateForumItemData ax;
        com.baidu.tieba.hottopic.view.e eVar;
        ArrayList arrayList2;
        if (customResponsedMessage != null) {
            arrayList = this.bpt.Xt;
            if (!arrayList.isEmpty()) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Long) {
                    ax = this.bpt.ax(((Long) data).longValue());
                    if (ax != null) {
                        ax.followNum++;
                        ax.setIsLiked(true);
                        eVar = this.bpt.bps;
                        n RB = eVar.RB();
                        if (RB != null) {
                            arrayList2 = this.bpt.Xt;
                            RB.setData(arrayList2);
                            RB.notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    }
}
