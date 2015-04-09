package com.baidu.tieba.im.groupUpdates;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.im.model.UpdatesModel;
/* loaded from: classes.dex */
class b extends CustomMessageListener {
    final /* synthetic */ UpdatesActivity biO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(UpdatesActivity updatesActivity, int i) {
        super(i);
        this.biO = updatesActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        s sVar;
        com.baidu.tieba.im.g gVar;
        sVar = this.biO.biL;
        sVar.setLoadProgressBarVisable(false);
        if (customResponsedMessage != null && (customResponsedMessage instanceof ResponsedMessage)) {
            int cmd = customResponsedMessage.getCmd();
            if (2001136 == cmd || 2001137 == cmd || 2001134 == cmd || 2001133 == cmd || 2001141 == cmd) {
                gVar = this.biO.getDataCallBack;
                UpdatesModel.requestUpdatesDataFromDB(gVar);
            }
        }
    }
}
