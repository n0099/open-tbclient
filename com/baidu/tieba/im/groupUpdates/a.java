package com.baidu.tieba.im.groupUpdates;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.message.ResponseDelSystemMessage;
import com.baidu.tieba.im.model.UpdatesModel;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ UpdatesActivity bhi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(UpdatesActivity updatesActivity, int i) {
        super(i);
        this.bhi = updatesActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        p pVar;
        UpdatesItemData updatesItemData;
        UpdatesModel updatesModel;
        UpdatesModel updatesModel2;
        UpdatesModel updatesModel3;
        com.baidu.tieba.im.g<Boolean> gVar;
        UpdatesItemData updatesItemData2;
        com.baidu.tieba.im.g gVar2;
        pVar = this.bhi.bhf;
        pVar.setLoadProgressBarVisable(false);
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage) && 202004 == socketResponsedMessage.getCmd() && ((ResponseDelSystemMessage) socketResponsedMessage).getError() == 0) {
            updatesItemData = this.bhi.pendingToDel;
            if (updatesItemData != null) {
                updatesItemData2 = this.bhi.pendingToDel;
                gVar2 = this.bhi.delDataCallBack;
                UpdatesModel.deleteUpdatesData(updatesItemData2, gVar2);
                this.bhi.pendingToDel = null;
            }
            updatesModel = this.bhi.bhh;
            if (updatesModel != null) {
                updatesModel2 = this.bhi.bhh;
                if (updatesModel2.getDeleteSize() > 0) {
                    updatesModel3 = this.bhi.bhh;
                    gVar = this.bhi.delDataCallBack;
                    updatesModel3.deleteDatas(gVar);
                }
            }
        }
    }
}
