package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
/* loaded from: classes.dex */
class e extends CustomMessageListener {
    final /* synthetic */ HotTopicActivity bDn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(HotTopicActivity hotTopicActivity, int i) {
        super(i);
        this.bDn = hotTopicActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.hottopic.data.c cVar;
        com.baidu.tieba.hottopic.data.c cVar2;
        com.baidu.tieba.hottopic.data.c cVar3;
        RelateForumItemData aK;
        com.baidu.tieba.hottopic.data.c cVar4;
        com.baidu.tieba.hottopic.view.a aVar;
        com.baidu.tieba.hottopic.data.c cVar5;
        com.baidu.tieba.hottopic.view.a aVar2;
        if (customResponsedMessage != null) {
            cVar = this.bDn.bDi;
            if (cVar != null) {
                cVar2 = this.bDn.bDi;
                if (cVar2.Uw() != null) {
                    cVar3 = this.bDn.bDi;
                    if (cVar3.Uw().bEw != null) {
                        Object data = customResponsedMessage.getData();
                        if (data instanceof Long) {
                            aK = this.bDn.aK(((Long) data).longValue());
                            if (aK != null) {
                                aK.followNum--;
                                aK.setIsLiked(false);
                                cVar4 = this.bDn.bDi;
                                cVar4.Uw().bEy = true;
                                aVar = this.bDn.bDc;
                                cVar5 = this.bDn.bDi;
                                aVar.c(cVar5);
                                aVar2 = this.bDn.bDc;
                                aVar2.UD();
                            }
                        }
                    }
                }
            }
        }
    }
}
