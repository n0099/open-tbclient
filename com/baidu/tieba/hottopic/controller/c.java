package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
/* loaded from: classes.dex */
class c extends CustomMessageListener {
    final /* synthetic */ HotTopicActivity boA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(HotTopicActivity hotTopicActivity, int i) {
        super(i);
        this.boA = hotTopicActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.hottopic.data.b bVar;
        com.baidu.tieba.hottopic.data.b bVar2;
        com.baidu.tieba.hottopic.data.b bVar3;
        RelateForumItemData ao;
        com.baidu.tieba.hottopic.data.b bVar4;
        com.baidu.tieba.hottopic.view.a aVar;
        com.baidu.tieba.hottopic.data.b bVar5;
        com.baidu.tieba.hottopic.view.a aVar2;
        if (customResponsedMessage != null) {
            bVar = this.boA.bos;
            if (bVar != null) {
                bVar2 = this.boA.bos;
                if (bVar2.QT() != null) {
                    bVar3 = this.boA.bos;
                    if (bVar3.QT().bpf != null) {
                        Object data = customResponsedMessage.getData();
                        if (data instanceof Long) {
                            ao = this.boA.ao(((Long) data).longValue());
                            if (ao != null) {
                                ao.followNum++;
                                ao.setIsLiked(true);
                                bVar4 = this.boA.bos;
                                bVar4.QT().bph = true;
                                aVar = this.boA.boo;
                                bVar5 = this.boA.bos;
                                aVar.b(bVar5);
                                aVar2 = this.boA.boo;
                                aVar2.Rc();
                            }
                        }
                    }
                }
            }
        }
    }
}
