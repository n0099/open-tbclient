package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
/* loaded from: classes.dex */
class d extends CustomMessageListener {
    final /* synthetic */ HotTopicActivity bGR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(HotTopicActivity hotTopicActivity, int i) {
        super(i);
        this.bGR = hotTopicActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.hottopic.data.c cVar;
        com.baidu.tieba.hottopic.data.c cVar2;
        com.baidu.tieba.hottopic.data.c cVar3;
        RelateForumItemData aL;
        com.baidu.tieba.hottopic.data.c cVar4;
        com.baidu.tieba.hottopic.view.a aVar;
        com.baidu.tieba.hottopic.data.c cVar5;
        com.baidu.tieba.hottopic.view.a aVar2;
        if (customResponsedMessage != null) {
            cVar = this.bGR.bGM;
            if (cVar != null) {
                cVar2 = this.bGR.bGM;
                if (cVar2.Vz() != null) {
                    cVar3 = this.bGR.bGM;
                    if (cVar3.Vz().bIa != null) {
                        Object data = customResponsedMessage.getData();
                        if (data instanceof Long) {
                            aL = this.bGR.aL(((Long) data).longValue());
                            if (aL != null) {
                                aL.followNum++;
                                aL.setIsLiked(true);
                                cVar4 = this.bGR.bGM;
                                cVar4.Vz().bIc = true;
                                aVar = this.bGR.bGG;
                                cVar5 = this.bGR.bGM;
                                aVar.c(cVar5);
                                aVar2 = this.bGR.bGG;
                                aVar2.VH();
                            }
                        }
                    }
                }
            }
        }
    }
}
