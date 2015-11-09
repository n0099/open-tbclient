package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
/* loaded from: classes.dex */
class d extends CustomMessageListener {
    final /* synthetic */ HotTopicActivity bpp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(HotTopicActivity hotTopicActivity, int i) {
        super(i);
        this.bpp = hotTopicActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.hottopic.data.b bVar;
        com.baidu.tieba.hottopic.data.b bVar2;
        com.baidu.tieba.hottopic.data.b bVar3;
        RelateForumItemData aw;
        com.baidu.tieba.hottopic.data.b bVar4;
        com.baidu.tieba.hottopic.view.a aVar;
        com.baidu.tieba.hottopic.data.b bVar5;
        com.baidu.tieba.hottopic.view.a aVar2;
        if (customResponsedMessage != null) {
            bVar = this.bpp.bph;
            if (bVar != null) {
                bVar2 = this.bpp.bph;
                if (bVar2.Rl() != null) {
                    bVar3 = this.bpp.bph;
                    if (bVar3.Rl().bpU != null) {
                        Object data = customResponsedMessage.getData();
                        if (data instanceof Long) {
                            aw = this.bpp.aw(((Long) data).longValue());
                            if (aw != null) {
                                aw.followNum--;
                                aw.setIsLiked(false);
                                bVar4 = this.bpp.bph;
                                bVar4.Rl().bpW = true;
                                aVar = this.bpp.bpd;
                                bVar5 = this.bpp.bph;
                                aVar.b(bVar5);
                                aVar2 = this.bpp.bpd;
                                aVar2.Ru();
                            }
                        }
                    }
                }
            }
        }
    }
}
