package com.baidu.tieba.im.groupUpdates;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.groupInfo.RequestDelSystemMessage;
import com.baidu.tieba.im.groupInfo.ResponseDelSystemMessage;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ UpdatesActivity bbU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(UpdatesActivity updatesActivity, int i) {
        super(i);
        this.bbU = updatesActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        t tVar;
        UpdatesItemData updatesItemData;
        p pVar;
        p pVar2;
        p pVar3;
        com.baidu.tieba.im.a<Boolean> aVar;
        UpdatesItemData updatesItemData2;
        com.baidu.tieba.im.a aVar2;
        tVar = this.bbU.bbM;
        tVar.dg(false);
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage) && 202004 == socketResponsedMessage.getCmd()) {
            ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage;
            RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
            if (responseDelSystemMessage.getError() == 0) {
                updatesItemData = this.bbU.bbS;
                if (updatesItemData != null) {
                    updatesItemData2 = this.bbU.bbS;
                    aVar2 = this.bbU.bbP;
                    p.a(updatesItemData2, aVar2);
                    this.bbU.bbS = null;
                }
                pVar = this.bbU.bbT;
                if (pVar != null) {
                    pVar2 = this.bbU.bbT;
                    if (pVar2.Ph() > 0) {
                        pVar3 = this.bbU.bbT;
                        aVar = this.bbU.bbP;
                        pVar3.b(aVar);
                    }
                }
            }
        }
    }
}
