package com.baidu.tieba.addresslist;

import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class AddressListDelegateStatic {
    private ImageView aHw;
    CustomMessageListener aHx = new b(this, CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM);
    CustomMessageListener aHy = new c(this, CmdConfigCustom.CMD_CLEAR_ADDRESSLIST_TIP);

    public AddressListDelegateStatic() {
        this.aHx.setPriority(7);
        MessageManager.getInstance().registerListener(this.aHx);
        this.aHy.setPriority(7);
        MessageManager.getInstance().registerListener(this.aHy);
    }
}
