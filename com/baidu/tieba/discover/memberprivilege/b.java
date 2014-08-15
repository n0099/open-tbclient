package com.baidu.tieba.discover.memberprivilege;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class b extends CustomMessageListener {
    final /* synthetic */ MemberPrivilegeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(MemberPrivilegeActivity memberPrivilegeActivity, int i) {
        super(i);
        this.a = memberPrivilegeActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && ((Integer) customResponsedMessage.getData()) != null) {
            this.a.a();
        }
    }
}
