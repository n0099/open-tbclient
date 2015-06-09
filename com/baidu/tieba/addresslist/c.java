package com.baidu.tieba.addresslist;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ AddressListDelegateStatic ayX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(AddressListDelegateStatic addressListDelegateStatic, int i) {
        super(i);
        this.ayX = addressListDelegateStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ImageView imageView;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001189 && customResponsedMessage.getError() == 0) {
            imageView = this.ayX.ayU;
            imageView.setVisibility(8);
        }
    }
}
