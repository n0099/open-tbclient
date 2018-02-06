package com.baidu.tieba.frs.gametabs;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.frs.af;
import tbclient.FrsTabInfo;
/* loaded from: classes3.dex */
public class SpecialFrsWebManagerStatic {
    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001616) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebManagerStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001616 && customResponsedMessage.getData() != null) {
                    af afVar = (af) customResponsedMessage.getData();
                    for (FrsTabInfo frsTabInfo : afVar.awo()) {
                        if (frsTabInfo.tab_id.intValue() > 100) {
                            d dVar = new d(frsTabInfo.tab_id.intValue(), frsTabInfo.tab_url);
                            afVar.b(dVar);
                            if (afVar.getContext() == null) {
                                continue;
                            } else {
                                com.baidu.tbadk.mainTab.c MV = dVar.MV();
                                if (MV != null) {
                                    MV.bxZ.setArguments(new Bundle());
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
