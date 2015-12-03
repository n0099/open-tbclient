package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class af extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public af(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null) {
            com.baidu.tbadk.core.sharedPref.b.tZ().remove("get_addresslist_switch" + ((String) customResponsedMessage.getData()));
        }
    }
}
