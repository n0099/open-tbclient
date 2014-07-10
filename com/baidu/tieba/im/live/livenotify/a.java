package com.baidu.tieba.im.live.livenotify;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.groupInfo.ResponseDelSystemMessage;
import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ LiveNotifyActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(LiveNotifyActivity liveNotifyActivity, int i) {
        super(i);
        this.a = liveNotifyActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        s sVar;
        UpdatesItemData updatesItemData;
        o oVar;
        com.baidu.tieba.im.a aVar;
        o oVar2;
        o oVar3;
        com.baidu.tieba.im.a<Boolean> aVar2;
        UpdatesItemData updatesItemData2;
        com.baidu.tieba.im.a aVar3;
        sVar = this.a.b;
        sVar.a(false);
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage) && 202004 == socketResponsedMessage.getCmd() && ((ResponseDelSystemMessage) socketResponsedMessage).getError() == 0) {
            updatesItemData = this.a.h;
            if (updatesItemData != null) {
                updatesItemData2 = this.a.h;
                aVar3 = this.a.d;
                o.a(updatesItemData2, aVar3);
                this.a.h = null;
            }
            oVar = this.a.i;
            if (oVar != null) {
                oVar2 = this.a.i;
                if (oVar2.d() > 0) {
                    oVar3 = this.a.i;
                    aVar2 = this.a.d;
                    oVar3.a(aVar2);
                }
            }
            aVar = this.a.c;
            com.baidu.tieba.im.validate.n.a(Integer.MAX_VALUE, 0, aVar);
            com.baidu.tieba.im.pushNotify.a.a((com.baidu.tieba.im.a<Void>) null);
        }
    }
}
