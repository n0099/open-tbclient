package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
/* loaded from: classes.dex */
class i extends CustomMessageListener {
    final /* synthetic */ HotTopicActivity bKr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(HotTopicActivity hotTopicActivity, int i) {
        super(i);
        this.bKr = hotTopicActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.hottopic.data.e eVar;
        com.baidu.tieba.hottopic.data.e eVar2;
        com.baidu.tieba.hottopic.data.e eVar3;
        RelateForumItemData aM;
        com.baidu.tieba.hottopic.data.e eVar4;
        com.baidu.tieba.hottopic.view.c cVar;
        com.baidu.tieba.hottopic.data.e eVar5;
        com.baidu.tieba.hottopic.view.c cVar2;
        if (customResponsedMessage != null) {
            eVar = this.bKr.bKl;
            if (eVar != null) {
                eVar2 = this.bKr.bKl;
                if (eVar2.XS() != null) {
                    eVar3 = this.bKr.bKl;
                    if (eVar3.XS().bLE != null) {
                        Object data = customResponsedMessage.getData();
                        if (data instanceof Long) {
                            aM = this.bKr.aM(((Long) data).longValue());
                            if (aM != null) {
                                aM.followNum--;
                                aM.setIsLiked(false);
                                eVar4 = this.bKr.bKl;
                                eVar4.XS().bLG = true;
                                cVar = this.bKr.bKf;
                                eVar5 = this.bKr.bKl;
                                cVar.c(eVar5);
                                cVar2 = this.bKr.bKf;
                                cVar2.Yc();
                            }
                        }
                    }
                }
            }
        }
    }
}
