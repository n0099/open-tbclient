package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class y extends CustomMessageListener {
    final /* synthetic */ RelateTopicForumActivity bKy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(RelateTopicForumActivity relateTopicForumActivity, int i) {
        super(i);
        this.bKy = relateTopicForumActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList arrayList;
        RelateForumItemData aN;
        com.baidu.tieba.hottopic.view.p pVar;
        ArrayList arrayList2;
        if (customResponsedMessage != null) {
            arrayList = this.bKy.Zg;
            if (!arrayList.isEmpty()) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Long) {
                    aN = this.bKy.aN(((Long) data).longValue());
                    if (aN != null) {
                        aN.followNum--;
                        aN.setIsLiked(false);
                        pVar = this.bKy.bKx;
                        com.baidu.tieba.hottopic.a.v Yh = pVar.Yh();
                        if (Yh != null) {
                            arrayList2 = this.bKy.Zg;
                            Yh.setData(arrayList2);
                            Yh.notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    }
}
