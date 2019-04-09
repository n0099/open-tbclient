package com.baidu.tieba.frs.gametabs;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.frs.ab;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class SpecialFrsWebManagerStatic {
    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001616) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebManagerStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001616 && customResponsedMessage.getData() != null) {
                    ab abVar = (ab) customResponsedMessage.getData();
                    for (FrsTabInfo frsTabInfo : abVar.beo()) {
                        if (frsTabInfo.tab_id.intValue() > 100) {
                            c cVar = new c(frsTabInfo.tab_id.intValue(), frsTabInfo.tab_url);
                            abVar.b(cVar);
                            if (abVar.getContext() == null) {
                                continue;
                            } else {
                                com.baidu.tbadk.mainTab.c anH = cVar.anH();
                                if (anH != null) {
                                    anH.cog.setArguments(new Bundle());
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
