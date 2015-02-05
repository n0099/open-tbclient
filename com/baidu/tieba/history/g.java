package com.baidu.tieba.history;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.v;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class g extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public g(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.mainTab.f fVar;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007007 && customResponsedMessage.getData() != null) {
            PbHistoryStatic.aPh = (com.baidu.tbadk.mainTab.f) customResponsedMessage.getData();
            fVar = PbHistoryStatic.aPh;
            h hVar = new h(this, fVar.getContext(), z.my_history, v.icon_news_down_bar_one, v.icon_menu_history_n, 0);
            hVar.aN(false);
            ((com.baidu.tbadk.mainTab.f) customResponsedMessage.getData()).a(hVar);
        }
    }
}
