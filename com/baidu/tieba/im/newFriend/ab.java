package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends CustomMessageListener {
    int num;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(int i) {
        super(i);
        this.num = 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001179) {
            com.baidu.tieba.im.i.a(new ac(this), new ad(this));
        }
    }
}
