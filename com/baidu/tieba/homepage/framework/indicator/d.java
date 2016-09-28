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
    final /* synthetic */ a cCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(a aVar, int i) {
        super(i);
        this.cCV = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList arrayList;
        ArrayList arrayList2;
        com.baidu.tieba.homepage.recommendfrs.data.a aVar;
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            arrayList = this.cCV.cCN;
            if (!com.baidu.tbadk.core.util.y.t(arrayList)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().vS && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    arrayList2 = this.cCV.cCN;
                    Iterator it = arrayList2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            aVar = null;
                            break;
                        }
                        aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) it.next();
                        if (aVar != null && aVar.anf() != null && aVar.anf().tag_type.intValue() == 3) {
                            break;
                        }
                    }
                    if (aVar != null) {
                        for (Object obj : aVar.anh()) {
                            if (obj instanceof com.baidu.tieba.card.data.h) {
                                com.baidu.tieba.card.data.h hVar = (com.baidu.tieba.card.data.h) obj;
                                if (hVar.bbV != null && hVar.bbV.threadData != null && hVar.bbV.threadData.getAuthor() != null && hVar.bbV.threadData.getAuthor().getUserId() != null && hVar.bbV.threadData.getAuthor().getGodUserData() != null) {
                                    GodUserData godUserData = hVar.bbV.threadData.getAuthor().getGodUserData();
                                    if (hVar.bbV.threadData.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid)) {
                                        godUserData.setFollowed(updateAttentionMessage.getData().akC ? 1 : 0);
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
