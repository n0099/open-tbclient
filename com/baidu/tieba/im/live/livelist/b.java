package com.baidu.tieba.im.live.livelist;

import android.text.TextUtils;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.RequestLiveGroupOwnerGagMessage;
import com.baidu.tieba.im.message.ResponseLiveGroupOwnerGagMessage;
/* loaded from: classes.dex */
class b extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ BlackMembersListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(BlackMembersListActivity blackMembersListActivity, int i) {
        super(i);
        this.a = blackMembersListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        String userNames;
        i iVar;
        i iVar2;
        i iVar3;
        com.baidu.tieba.im.model.y yVar;
        com.baidu.tieba.im.model.y yVar2;
        this.a.d();
        if (socketResponsedMessage == null) {
            this.a.showToast(com.baidu.tieba.y.neterror);
        } else if (socketResponsedMessage.getCmd() == 107109) {
            if (!(socketResponsedMessage instanceof ResponseLiveGroupOwnerGagMessage)) {
                this.a.showToast(com.baidu.tieba.y.neterror);
                return;
            }
            ResponseLiveGroupOwnerGagMessage responseLiveGroupOwnerGagMessage = (ResponseLiveGroupOwnerGagMessage) socketResponsedMessage;
            if (responseLiveGroupOwnerGagMessage.hasError()) {
                if (responseLiveGroupOwnerGagMessage.getError() > 0 && !TextUtils.isEmpty(responseLiveGroupOwnerGagMessage.getErrorString())) {
                    this.a.showToast(responseLiveGroupOwnerGagMessage.getErrorString());
                    return;
                } else {
                    this.a.showToast(com.baidu.tieba.y.neterror);
                    return;
                }
            }
            Message<?> orginalMessage = responseLiveGroupOwnerGagMessage.getOrginalMessage();
            if (orginalMessage instanceof RequestLiveGroupOwnerGagMessage) {
                RequestLiveGroupOwnerGagMessage requestLiveGroupOwnerGagMessage = (RequestLiveGroupOwnerGagMessage) orginalMessage;
                if (requestLiveGroupOwnerGagMessage.getType() == 2) {
                    String[] split = requestLiveGroupOwnerGagMessage.getUserIds().split(",");
                    if (split.length > 0) {
                        for (String str : split) {
                            iVar3 = this.a.a;
                            if (iVar3.e().a(str)) {
                                yVar = this.a.b;
                                yVar2 = this.a.b;
                                yVar.a(yVar2.a() - 1);
                            }
                        }
                        iVar = this.a.a;
                        iVar.e().notifyDataSetChanged();
                        iVar2 = this.a.a;
                        if (iVar2.e().c() == 0) {
                            this.a.h();
                        }
                    }
                    if (!TextUtils.isEmpty(requestLiveGroupOwnerGagMessage.getUserNames())) {
                        this.a.showToast(String.valueOf(userNames) + this.a.getString(com.baidu.tieba.y.live_black_members_unset_success));
                    } else {
                        this.a.showToast(com.baidu.tieba.y.live_black_members_unset_success);
                    }
                }
            }
        }
    }
}
