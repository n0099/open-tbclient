package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends CustomMessageListener {
    int num;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(int i) {
        super(i);
        this.num = 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001179) {
            com.baidu.tbadk.util.n.b(new ad(this), new ae(this));
        }
    }
}
