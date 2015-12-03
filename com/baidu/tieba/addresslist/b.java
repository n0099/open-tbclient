package com.baidu.tieba.addresslist;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* loaded from: classes.dex */
class b extends CustomMessageListener {
    final /* synthetic */ AddressListDelegateStatic aHz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(AddressListDelegateStatic addressListDelegateStatic, int i) {
        super(i);
        this.aHz = addressListDelegateStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001180 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
            imageView = this.aHz.aHw;
            if (imageView != null) {
                ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                if (responseUnreadPointNum.getNum() > 0 && responseUnreadPointNum.isFromNet()) {
                    imageView4 = this.aHz.aHw;
                    imageView4.setVisibility(0);
                } else if (!com.baidu.tbadk.core.sharedPref.b.tZ().getBoolean("show_new_icon_for_new_friend_" + TbadkCoreApplication.getCurrentAccount(), true) || !TbadkCoreApplication.isLogin()) {
                    imageView2 = this.aHz.aHw;
                    imageView2.setVisibility(8);
                } else {
                    imageView3 = this.aHz.aHw;
                    imageView3.setVisibility(0);
                }
            }
        }
    }
}
