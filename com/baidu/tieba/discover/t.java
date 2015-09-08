package com.baidu.tieba.discover;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class t extends CustomMessageListener {
    final /* synthetic */ DiscoverDelegateStatic aLJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(DiscoverDelegateStatic discoverDelegateStatic, int i) {
        super(i);
        this.aLJ = discoverDelegateStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ImageView imageView;
        Boolean bool;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007004 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.mainTab.a)) {
            this.aLJ.aLH = Boolean.valueOf(((com.baidu.tbadk.mainTab.a) customResponsedMessage.getData()).awm);
            imageView = this.aLJ.aLG;
            bool = this.aLJ.aLH;
            imageView.setVisibility(bool.booleanValue() ? 0 : 8);
        }
    }
}
