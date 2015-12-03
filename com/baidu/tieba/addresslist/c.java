package com.baidu.tieba.addresslist;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class c extends CustomMessageListener {
    final /* synthetic */ AddressListDelegateStatic aHz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(AddressListDelegateStatic addressListDelegateStatic, int i) {
        super(i);
        this.aHz = addressListDelegateStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ImageView imageView;
        ImageView imageView2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001189 && customResponsedMessage.getError() == 0) {
            imageView = this.aHz.aHw;
            if (imageView != null) {
                imageView2 = this.aHz.aHw;
                imageView2.setVisibility(8);
            }
        }
    }
}
