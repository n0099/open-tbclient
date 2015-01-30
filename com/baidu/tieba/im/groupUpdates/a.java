package com.baidu.tieba.im.groupUpdates;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.message.ResponseDelSystemMessage;
import com.baidu.tieba.im.model.UpdatesModel;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ UpdatesActivity bhj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(UpdatesActivity updatesActivity, int i) {
        super(i);
        this.bhj = updatesActivity;
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
        pVar = this.bhj.bhg;
        pVar.setLoadProgressBarVisable(false);
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage) && 202004 == socketResponsedMessage.getCmd() && ((ResponseDelSystemMessage) socketResponsedMessage).getError() == 0) {
            updatesItemData = this.bhj.pendingToDel;
            if (updatesItemData != null) {
                updatesItemData2 = this.bhj.pendingToDel;
                gVar2 = this.bhj.delDataCallBack;
                UpdatesModel.deleteUpdatesData(updatesItemData2, gVar2);
                this.bhj.pendingToDel = null;
            }
            updatesModel = this.bhj.bhi;
            if (updatesModel != null) {
                updatesModel2 = this.bhj.bhi;
                if (updatesModel2.getDeleteSize() > 0) {
                    updatesModel3 = this.bhj.bhi;
                    gVar = this.bhj.delDataCallBack;
                    updatesModel3.deleteDatas(gVar);
                }
            }
        }
    }
}
