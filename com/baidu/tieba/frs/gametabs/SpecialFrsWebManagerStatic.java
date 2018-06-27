package com.baidu.tieba.frs.gametabs;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.frs.ad;
import tbclient.FrsTabInfo;
/* loaded from: classes3.dex */
public class SpecialFrsWebManagerStatic {
    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001616) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebManagerStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001616 && customResponsedMessage.getData() != null) {
                    ad adVar = (ad) customResponsedMessage.getData();
                    for (FrsTabInfo frsTabInfo : adVar.avg()) {
                        if (frsTabInfo.tab_id.intValue() > 100) {
                            c cVar = new c(frsTabInfo.tab_id.intValue(), frsTabInfo.tab_url);
                            adVar.b(cVar);
                            if (adVar.getContext() == null) {
                                continue;
                            } else {
                                com.baidu.tbadk.mainTab.c Jt = cVar.Jt();
                                if (Jt != null) {
                                    Jt.aRL.setArguments(new Bundle());
                                } else {
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        });
    }
}
