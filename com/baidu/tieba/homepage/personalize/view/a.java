package com.baidu.tieba.homepage.personalize.view;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class a extends CustomMessageListener {
    final /* synthetic */ HomeTabBarView cwW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(HomeTabBarView homeTabBarView, int i) {
        super(i);
        this.cwW = homeTabBarView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ImageView imageView;
        ImageView imageView2;
        if (customResponsedMessage.getData() instanceof Boolean ? ((Boolean) customResponsedMessage.getData()).booleanValue() : false) {
            imageView2 = this.cwW.cwT;
            imageView2.setVisibility(0);
            return;
        }
        imageView = this.cwW.cwT;
        imageView.setVisibility(8);
    }
}
