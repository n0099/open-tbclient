package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ay extends CustomMessageListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ay(FrsActivity frsActivity, int i) {
        super(i);
        this.a = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        cu cuVar;
        cu cuVar2;
        if (customResponsedMessage != null) {
            cuVar = this.a.z;
            if (cuVar != null) {
                cuVar2 = this.a.z;
                cuVar2.S();
            }
        }
    }
}
