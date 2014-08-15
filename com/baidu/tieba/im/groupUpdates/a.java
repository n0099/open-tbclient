package com.baidu.tieba.im.groupUpdates;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.groupInfo.RequestDelSystemMessage;
import com.baidu.tieba.im.groupInfo.ResponseDelSystemMessage;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ UpdatesActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(UpdatesActivity updatesActivity, int i) {
        super(i);
        this.a = updatesActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        t tVar;
        UpdatesItemData updatesItemData;
        p pVar;
        p pVar2;
        p pVar3;
        com.baidu.tieba.im.a<Boolean> aVar;
        UpdatesItemData updatesItemData2;
        com.baidu.tieba.im.a aVar2;
        tVar = this.a.b;
        tVar.a(false);
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage) && 202004 == socketResponsedMessage.getCmd()) {
            ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage;
            RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
            if (responseDelSystemMessage.getError() == 0) {
                updatesItemData = this.a.h;
                if (updatesItemData != null) {
                    updatesItemData2 = this.a.h;
                    aVar2 = this.a.e;
                    p.a(updatesItemData2, aVar2);
                    this.a.h = null;
                }
                pVar = this.a.i;
                if (pVar != null) {
                    pVar2 = this.a.i;
                    if (pVar2.d() > 0) {
                        pVar3 = this.a.i;
                        aVar = this.a.e;
                        pVar3.a(aVar);
                    }
                }
            }
        }
    }
}
