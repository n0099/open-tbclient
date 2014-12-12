package com.baidu.tieba.im.groupUpdates;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.im.model.UpdatesModel;
/* loaded from: classes.dex */
class b extends CustomMessageListener {
    final /* synthetic */ UpdatesActivity bfR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(UpdatesActivity updatesActivity, int i) {
        super(i);
        this.bfR = updatesActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        p pVar;
        com.baidu.tieba.im.g gVar;
        pVar = this.bfR.bfO;
        pVar.setLoadProgressBarVisable(false);
        if (customResponsedMessage != null && (customResponsedMessage instanceof ResponsedMessage)) {
            int cmd = customResponsedMessage.getCmd();
            if (2001136 == cmd || 2001137 == cmd || 2001134 == cmd || 2001133 == cmd || 2001141 == cmd) {
                gVar = this.bfR.getDataCallBack;
                UpdatesModel.requestUpdatesDataFromDB(gVar);
            }
        }
    }
}
