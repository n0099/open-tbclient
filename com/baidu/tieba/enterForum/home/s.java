package com.baidu.tieba.enterForum.home;

import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class s extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public s(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.mainTab.d AD;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
            EnterForumDelegateStatic enterForumDelegateStatic = new EnterForumDelegateStatic();
            ((com.baidu.tbadk.mainTab.f) customResponsedMessage.getData()).a(enterForumDelegateStatic);
            if (((com.baidu.tbadk.mainTab.f) customResponsedMessage.getData()).getContext() != null && (AD = enterForumDelegateStatic.AD()) != null) {
                AD.anf.setArguments(new Bundle());
            }
        }
    }
}
