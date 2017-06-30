package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.RequestEnterForumDataMessage;
import com.baidu.tieba.enterForum.model.EnterForumModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        EnterForumModel enterForumModel;
        EnterForumModel enterForumModel2;
        if (TbadkCoreApplication.isLogin() && (customResponsedMessage instanceof RequestEnterForumDataMessage)) {
            if (((RequestEnterForumDataMessage) customResponsedMessage).isCache()) {
                enterForumModel2 = CoreSearchRequestStatic.bSR;
                enterForumModel2.ec(true);
                return;
            }
            enterForumModel = CoreSearchRequestStatic.bSR;
            enterForumModel.eb(true);
        }
    }
}
