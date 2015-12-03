package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class t extends CustomMessageListener {
    final /* synthetic */ RelateTopicForumActivity bDu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(RelateTopicForumActivity relateTopicForumActivity, int i) {
        super(i);
        this.bDu = relateTopicForumActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList arrayList;
        RelateForumItemData aL;
        com.baidu.tieba.hottopic.view.h hVar;
        ArrayList arrayList2;
        if (customResponsedMessage != null) {
            arrayList = this.bDu.Yg;
            if (!arrayList.isEmpty()) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Long) {
                    aL = this.bDu.aL(((Long) data).longValue());
                    if (aL != null) {
                        aL.followNum++;
                        aL.setIsLiked(true);
                        hVar = this.bDu.bDt;
                        com.baidu.tieba.hottopic.a.u UH = hVar.UH();
                        if (UH != null) {
                            arrayList2 = this.bDu.Yg;
                            UH.setData(arrayList2);
                            UH.notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    }
}
