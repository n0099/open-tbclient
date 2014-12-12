package com.baidu.tieba.home;

import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class r extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public r(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.mainTab.d we;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
            EnterForumDelegateStatic enterForumDelegateStatic = new EnterForumDelegateStatic();
            ((com.baidu.tbadk.mainTab.g) customResponsedMessage.getData()).a(enterForumDelegateStatic);
            if (((com.baidu.tbadk.mainTab.g) customResponsedMessage.getData()).getContext() != null && (we = enterForumDelegateStatic.we()) != null) {
                we.acb.setArguments(new Bundle());
            }
        }
    }
}
