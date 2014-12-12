package com.baidu.tieba.discover;

import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class n extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public n(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.mainTab.d we;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
            DiscoverDelegateStatic discoverDelegateStatic = new DiscoverDelegateStatic();
            ((com.baidu.tbadk.mainTab.g) customResponsedMessage.getData()).a(discoverDelegateStatic);
            if (((com.baidu.tbadk.mainTab.g) customResponsedMessage.getData()).getContext() != null && (we = discoverDelegateStatic.we()) != null) {
                we.acb.setArguments(new Bundle());
            }
        }
    }
}
