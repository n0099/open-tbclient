package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.hottopic.a.n;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class j extends CustomMessageListener {
    final /* synthetic */ RelateTopicForumActivity boE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(RelateTopicForumActivity relateTopicForumActivity, int i) {
        super(i);
        this.boE = relateTopicForumActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList arrayList;
        RelateForumItemData ap;
        com.baidu.tieba.hottopic.view.e eVar;
        ArrayList arrayList2;
        if (customResponsedMessage != null) {
            arrayList = this.boE.Xo;
            if (!arrayList.isEmpty()) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Long) {
                    ap = this.boE.ap(((Long) data).longValue());
                    if (ap != null) {
                        ap.followNum++;
                        ap.setIsLiked(true);
                        eVar = this.boE.boD;
                        n Rj = eVar.Rj();
                        if (Rj != null) {
                            arrayList2 = this.boE.Xo;
                            Rj.setData(arrayList2);
                            Rj.notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    }
}
