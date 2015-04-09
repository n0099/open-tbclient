package com.baidu.tieba.im.groupUpdates;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.message.RequestDelSystemMessage;
import com.baidu.tieba.im.message.ResponseDelSystemMessage;
import com.baidu.tieba.im.model.UpdatesModel;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ UpdatesActivity biO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(UpdatesActivity updatesActivity, int i) {
        super(i);
        this.biO = updatesActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        s sVar;
        UpdatesItemData updatesItemData;
        UpdatesModel updatesModel;
        UpdatesModel updatesModel2;
        UpdatesModel updatesModel3;
        com.baidu.tieba.im.g<Boolean> gVar;
        UpdatesItemData updatesItemData2;
        com.baidu.tieba.im.g gVar2;
        sVar = this.biO.biL;
        sVar.setLoadProgressBarVisable(false);
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage) && 202004 == socketResponsedMessage.getCmd()) {
            ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage;
            RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
            if (responseDelSystemMessage.getError() == 0) {
                updatesItemData = this.biO.pendingToDel;
                if (updatesItemData != null) {
                    updatesItemData2 = this.biO.pendingToDel;
                    gVar2 = this.biO.delDataCallBack;
                    UpdatesModel.deleteUpdatesData(updatesItemData2, gVar2);
                    this.biO.pendingToDel = null;
                }
                updatesModel = this.biO.biN;
                if (updatesModel != null) {
                    updatesModel2 = this.biO.biN;
                    if (updatesModel2.getDeleteSize() > 0) {
                        updatesModel3 = this.biO.biN;
                        gVar = this.biO.delDataCallBack;
                        updatesModel3.deleteDatas(gVar);
                    }
                }
            }
        }
    }
}
