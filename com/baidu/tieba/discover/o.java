package com.baidu.tieba.discover;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class o extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public o(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ImageView imageView;
        Boolean bool;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007004 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.mainTab.a)) {
            DiscoverDelegateStatic.aBN = Boolean.valueOf(((com.baidu.tbadk.mainTab.a) customResponsedMessage.getData()).alH);
            imageView = DiscoverDelegateStatic.aBM;
            bool = DiscoverDelegateStatic.aBN;
            imageView.setVisibility(bool.booleanValue() ? 0 : 8);
        }
    }
}
