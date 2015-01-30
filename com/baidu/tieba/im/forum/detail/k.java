package com.baidu.tieba.im.forum.detail;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends CustomMessageListener {
    final /* synthetic */ h baE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(h hVar, int i) {
        super(i);
        this.baE = hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ForumDetailActivity forumDetailActivity;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001155) {
            forumDetailActivity = this.baE.baC;
            forumDetailActivity.showToast(z.cash_del_suc);
        }
    }
}
