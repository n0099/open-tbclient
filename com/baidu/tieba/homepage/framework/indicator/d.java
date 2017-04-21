package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.data.GodUserData;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ a cwV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(a aVar, int i) {
        super(i);
        this.cwV = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList arrayList;
        ArrayList arrayList2;
        com.baidu.tieba.homepage.recommendfrs.data.a aVar;
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            arrayList = this.cwV.cwN;
            if (!com.baidu.tbadk.core.util.x.q(arrayList)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().CB && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    arrayList2 = this.cwV.cwN;
                    Iterator it = arrayList2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            aVar = null;
                            break;
                        }
                        aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) it.next();
                        if (aVar != null && aVar.akO() != null && aVar.akO().tag_type.intValue() == 3) {
                            break;
                        }
                    }
                    if (aVar != null) {
                        for (Object obj : aVar.akQ()) {
                            if (obj instanceof com.baidu.tieba.card.data.g) {
                                com.baidu.tieba.card.data.g gVar = (com.baidu.tieba.card.data.g) obj;
                                if (gVar.bxi != null && gVar.bxi.threadData != null && gVar.bxi.threadData.getAuthor() != null && gVar.bxi.threadData.getAuthor().getUserId() != null && gVar.bxi.threadData.getAuthor().getGodUserData() != null) {
                                    GodUserData godUserData = gVar.bxi.threadData.getAuthor().getGodUserData();
                                    if (gVar.bxi.threadData.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid)) {
                                        godUserData.setIsLike(updateAttentionMessage.getData().isAttention);
                                    }
                                } else {
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
