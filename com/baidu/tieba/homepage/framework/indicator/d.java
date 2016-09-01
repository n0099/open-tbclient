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
    final /* synthetic */ a cCq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(a aVar, int i) {
        super(i);
        this.cCq = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList arrayList;
        ArrayList arrayList2;
        com.baidu.tieba.homepage.recommendfrs.data.a aVar;
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            arrayList = this.cCq.cCi;
            if (!com.baidu.tbadk.core.util.y.t(arrayList)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().vS && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    arrayList2 = this.cCq.cCi;
                    Iterator it = arrayList2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            aVar = null;
                            break;
                        }
                        aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) it.next();
                        if (aVar != null && aVar.amR() != null && aVar.amR().tag_type.intValue() == 3) {
                            break;
                        }
                    }
                    if (aVar != null) {
                        for (Object obj : aVar.amT()) {
                            if (obj instanceof com.baidu.tieba.card.data.h) {
                                com.baidu.tieba.card.data.h hVar = (com.baidu.tieba.card.data.h) obj;
                                if (hVar.bbD != null && hVar.bbD.threadData != null && hVar.bbD.threadData.getAuthor() != null && hVar.bbD.threadData.getAuthor().getUserId() != null && hVar.bbD.threadData.getAuthor().getGodUserData() != null) {
                                    GodUserData godUserData = hVar.bbD.threadData.getAuthor().getGodUserData();
                                    if (hVar.bbD.threadData.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid)) {
                                        godUserData.setFollowed(updateAttentionMessage.getData().akW ? 1 : 0);
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
