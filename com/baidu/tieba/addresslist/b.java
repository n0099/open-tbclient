package com.baidu.tieba.addresslist;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends CustomMessageListener {
    final /* synthetic */ AddressListDelegateStatic ayW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(AddressListDelegateStatic addressListDelegateStatic, int i) {
        super(i);
        this.ayW = addressListDelegateStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001180 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
            ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
            if (responseUnreadPointNum.getNum() > 0 && responseUnreadPointNum.isFromNet()) {
                imageView3 = this.ayW.ayT;
                imageView3.setVisibility(0);
            } else if (!com.baidu.tbadk.core.sharedPref.b.sl().getBoolean("show_new_icon_for_new_friend_" + TbadkCoreApplication.getCurrentAccount(), true) || !TbadkCoreApplication.isLogin()) {
                imageView = this.ayW.ayT;
                imageView.setVisibility(8);
            } else {
                imageView2 = this.ayW.ayT;
                imageView2.setVisibility(0);
            }
        }
    }
}
