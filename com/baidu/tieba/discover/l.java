package com.baidu.tieba.discover;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends CustomMessageListener {
    final /* synthetic */ a aKG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(a aVar, int i) {
        super(i);
        this.aKG = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2009503) {
            return;
        }
        this.aKG.Hq();
        this.aKG.bE(false);
        if (customResponsedMessage.getData() instanceof Integer) {
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            if (intValue == 2902001) {
                TiebaStatic.eventStat(this.aKG.getPageContext().getPageActivity(), "plugin_discover_neighbors", null);
            } else if (intValue == 2902040) {
                TiebaStatic.eventStat(this.aKG.getPageContext().getPageActivity(), "plugin_discover_randchat", null);
            }
        }
    }
}
