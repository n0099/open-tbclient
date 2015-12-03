package com.baidu.tieba.discover;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class s extends CustomMessageListener {
    final /* synthetic */ DiscoverDelegateStatic aOh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(DiscoverDelegateStatic discoverDelegateStatic, int i) {
        super(i);
        this.aOh = discoverDelegateStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ImageView imageView;
        Boolean bool;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007004 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.mainTab.a)) {
            this.aOh.aOf = Boolean.valueOf(((com.baidu.tbadk.mainTab.a) customResponsedMessage.getData()).avE);
            imageView = this.aOh.aOe;
            bool = this.aOh.aOf;
            imageView.setVisibility(bool.booleanValue() ? 0 : 8);
        }
    }
}
