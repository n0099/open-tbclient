package com.baidu.tieba.addresslist;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends CustomMessageListener {
    final /* synthetic */ AddressListDelegateStatic ayX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(AddressListDelegateStatic addressListDelegateStatic, int i) {
        super(i);
        this.ayX = addressListDelegateStatic;
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
                imageView3 = this.ayX.ayU;
                imageView3.setVisibility(0);
            } else if (!com.baidu.tbadk.core.sharedPref.b.sl().getBoolean("show_new_icon_for_new_friend_" + TbadkCoreApplication.getCurrentAccount(), true) || !TbadkCoreApplication.isLogin()) {
                imageView = this.ayX.ayU;
                imageView.setVisibility(8);
            } else {
                imageView2 = this.ayX.ayU;
                imageView2.setVisibility(0);
            }
        }
    }
}
