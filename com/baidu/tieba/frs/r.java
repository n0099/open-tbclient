package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class r extends CustomMessageListener {
    final /* synthetic */ FrsActivity aBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(FrsActivity frsActivity, int i) {
        super(i);
        this.aBu = frsActivity;
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
                buVar = this.aBu.aAF;
                if (buVar != null) {
                    buVar2 = this.aBu.aAF;
                    if (buVar2.GJ() != null) {
                        buVar3 = this.aBu.aAF;
                        buVar3.GJ().ae(eVar.userId, eVar.userName);
                    }
                }
            }
        }
    }
}
