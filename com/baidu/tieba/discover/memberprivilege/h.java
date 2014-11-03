package com.baidu.tieba.discover.memberprivilege;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class h extends CustomMessageListener {
    final /* synthetic */ MemberPrivilegeActivity apH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(MemberPrivilegeActivity memberPrivilegeActivity, int i) {
        super(i);
        this.apH = memberPrivilegeActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && ((Integer) customResponsedMessage.getData()) != null) {
            this.apH.AZ();
        }
    }
}
