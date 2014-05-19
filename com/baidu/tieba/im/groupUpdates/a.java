package com.baidu.tieba.im.groupUpdates;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.groupInfo.RequestDelSystemMessage;
import com.baidu.tieba.im.groupInfo.ResponseDelSystemMessage;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.b {
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
        com.baidu.tieba.im.a aVar;
        p pVar2;
        p pVar3;
        com.baidu.tieba.im.a<Boolean> aVar2;
        UpdatesItemData updatesItemData2;
        com.baidu.tieba.im.a aVar3;
        tVar = this.a.b;
        tVar.a(false);
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage) && 202004 == socketResponsedMessage.getCmd()) {
            ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage;
            RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
            if (responseDelSystemMessage.getError() != 0) {
                BdLog.e("del group info err:" + responseDelSystemMessage.getErrorString());
                return;
            }
            BdLog.d("del group info: gid" + requestDelSystemMessage.getGroupId() + " msgid:" + requestDelSystemMessage.getMsgIds());
            updatesItemData = this.a.i;
            if (updatesItemData != null) {
                updatesItemData2 = this.a.i;
                aVar3 = this.a.e;
                p.a(updatesItemData2, aVar3);
                this.a.i = null;
            }
            pVar = this.a.j;
            if (pVar != null) {
                pVar2 = this.a.j;
                if (pVar2.d() > 0) {
                    pVar3 = this.a.j;
                    aVar2 = this.a.e;
                    pVar3.a(aVar2);
                }
            }
            aVar = this.a.d;
            com.baidu.tieba.im.validate.n.a(Integer.MAX_VALUE, 0, aVar);
            com.baidu.tieba.im.pushNotify.a.a(false, (com.baidu.tieba.im.a<Void>) null);
        }
    }
}
