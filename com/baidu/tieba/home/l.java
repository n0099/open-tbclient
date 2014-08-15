package com.baidu.tieba.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class l extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public l(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (TbadkApplication.isLogin()) {
            new com.baidu.tieba.model.n().a(true);
        }
    }
}
