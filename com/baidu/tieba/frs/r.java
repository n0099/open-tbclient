package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class r extends CustomMessageListener {
    final /* synthetic */ FrsActivity aBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(FrsActivity frsActivity, int i) {
        super(i);
        this.aBk = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bu buVar;
        bu buVar2;
        bu buVar3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.coreExtra.data.e)) {
            com.baidu.tbadk.coreExtra.data.e eVar = (com.baidu.tbadk.coreExtra.data.e) customResponsedMessage.getData();
            if (!TextUtils.isEmpty(eVar.userId) && !TextUtils.isEmpty(eVar.userName)) {
                buVar = this.aBk.aAv;
                if (buVar != null) {
                    buVar2 = this.aBk.aAv;
                    if (buVar2.GH() != null) {
                        buVar3 = this.aBk.aAv;
                        buVar3.GH().ae(eVar.userId, eVar.userName);
                    }
                }
            }
        }
    }
}
