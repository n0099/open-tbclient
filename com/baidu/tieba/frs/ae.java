package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ae extends CustomMessageListener {
    final /* synthetic */ FrsActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(FrsActivity frsActivity, int i) {
        super(i);
        this.this$0 = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bl blVar;
        bl blVar2;
        bl blVar3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.coreExtra.data.i)) {
            com.baidu.tbadk.coreExtra.data.i iVar = (com.baidu.tbadk.coreExtra.data.i) customResponsedMessage.getData();
            if (!TextUtils.isEmpty(iVar.userId) && !TextUtils.isEmpty(iVar.userName)) {
                blVar = this.this$0.aUw;
                if (blVar != null) {
                    blVar2 = this.this$0.aUw;
                    if (blVar2.Mj() != null) {
                        blVar3 = this.this$0.aUw;
                        blVar3.Mj().aq(iVar.userId, iVar.userName);
                    }
                }
            }
        }
    }
}
