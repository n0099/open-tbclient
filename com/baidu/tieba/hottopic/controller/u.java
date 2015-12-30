package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class u extends CustomMessageListener {
    final /* synthetic */ RelateTopicForumActivity bGY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(RelateTopicForumActivity relateTopicForumActivity, int i) {
        super(i);
        this.bGY = relateTopicForumActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList arrayList;
        RelateForumItemData aM;
        com.baidu.tieba.hottopic.view.h hVar;
        ArrayList arrayList2;
        if (customResponsedMessage != null) {
            arrayList = this.bGY.YJ;
            if (!arrayList.isEmpty()) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Long) {
                    aM = this.bGY.aM(((Long) data).longValue());
                    if (aM != null) {
                        aM.followNum--;
                        aM.setIsLiked(false);
                        hVar = this.bGY.bGX;
                        com.baidu.tieba.hottopic.a.u VN = hVar.VN();
                        if (VN != null) {
                            arrayList2 = this.bGY.YJ;
                            VN.setData(arrayList2);
                            VN.notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    }
}
