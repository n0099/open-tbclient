package com.baidu.tieba.discover;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class t extends CustomMessageListener {
    final /* synthetic */ DiscoverDelegateStatic aKB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(DiscoverDelegateStatic discoverDelegateStatic, int i) {
        super(i);
        this.aKB = discoverDelegateStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ImageView imageView;
        Boolean bool;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007004 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.mainTab.a)) {
            this.aKB.aKz = Boolean.valueOf(((com.baidu.tbadk.mainTab.a) customResponsedMessage.getData()).auL);
            imageView = this.aKB.aKy;
            bool = this.aKB.aKz;
            imageView.setVisibility(bool.booleanValue() ? 0 : 8);
        }
    }
}
