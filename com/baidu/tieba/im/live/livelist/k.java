package com.baidu.tieba.im.live.livelist;

import android.text.TextUtils;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.RequestOperateFrsLiveListMessage;
import com.baidu.tieba.im.message.ResponseOperateFrsLiveListMessage;
/* loaded from: classes.dex */
class k extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ FrsLiveListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(FrsLiveListActivity frsLiveListActivity, int i) {
        super(i);
        this.a = frsLiveListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        w wVar;
        w wVar2;
        w wVar3;
        w wVar4;
        this.a.closeLoadingDialog();
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseOperateFrsLiveListMessage)) {
            this.a.showToast(com.baidu.tieba.u.neterror);
            return;
        }
        ResponseOperateFrsLiveListMessage responseOperateFrsLiveListMessage = (ResponseOperateFrsLiveListMessage) socketResponsedMessage;
        Message<?> orginalMessage = responseOperateFrsLiveListMessage.getOrginalMessage();
        if (orginalMessage != null && (orginalMessage instanceof RequestOperateFrsLiveListMessage)) {
            RequestOperateFrsLiveListMessage requestOperateFrsLiveListMessage = (RequestOperateFrsLiveListMessage) orginalMessage;
            int type = requestOperateFrsLiveListMessage.getType();
            int oldType = requestOperateFrsLiveListMessage.getOldType();
            if (responseOperateFrsLiveListMessage.hasError()) {
                if (responseOperateFrsLiveListMessage.getError() > 0 && !TextUtils.isEmpty(responseOperateFrsLiveListMessage.getErrorString())) {
                    this.a.showToast(responseOperateFrsLiveListMessage.getErrorString());
                    return;
                } else {
                    this.a.showToast(com.baidu.tieba.u.neterror);
                    return;
                }
            }
            int groupId = responseOperateFrsLiveListMessage.getGroupId();
            switch (type) {
                case 0:
                    if (oldType == 1) {
                        this.a.d();
                        return;
                    } else if (oldType == 2) {
                        wVar3 = this.a.b;
                        wVar3.c().a().a(groupId, false);
                        wVar4 = this.a.b;
                        wVar4.c().notifyDataSetChanged();
                        return;
                    } else {
                        return;
                    }
                case 1:
                    this.a.d();
                    return;
                case 2:
                    wVar = this.a.b;
                    wVar.c().a().a(groupId, true);
                    wVar2 = this.a.b;
                    wVar2.c().notifyDataSetChanged();
                    return;
                default:
                    return;
            }
        }
        this.a.showToast(com.baidu.tieba.u.neterror);
    }
}
