package com.baidu.tieba.im.live.livelist;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.message.ResponseLiveBlackMembersMessage;
import java.util.List;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ BlackMembersListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BlackMembersListActivity blackMembersListActivity, int i) {
        super(i);
        this.a = blackMembersListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        i iVar;
        com.baidu.tieba.im.model.y yVar;
        boolean f;
        i iVar2;
        com.baidu.tieba.im.model.y yVar2;
        com.baidu.tieba.im.model.y yVar3;
        com.baidu.tieba.im.model.y yVar4;
        com.baidu.tieba.im.model.y yVar5;
        i iVar3;
        i iVar4;
        i iVar5;
        i iVar6;
        i iVar7;
        this.a.d();
        if (socketResponsedMessage == null) {
            this.a.showToast(com.baidu.tieba.u.neterror);
        } else if (socketResponsedMessage.getCmd() == 107009) {
            if (!(socketResponsedMessage instanceof ResponseLiveBlackMembersMessage)) {
                this.a.showToast(com.baidu.tieba.u.neterror);
                return;
            }
            ResponseLiveBlackMembersMessage responseLiveBlackMembersMessage = (ResponseLiveBlackMembersMessage) socketResponsedMessage;
            if (responseLiveBlackMembersMessage.hasError()) {
                if (responseLiveBlackMembersMessage.getError() > 0 && !TextUtils.isEmpty(responseLiveBlackMembersMessage.getErrorString())) {
                    this.a.showToast(responseLiveBlackMembersMessage.getErrorString());
                    return;
                } else {
                    this.a.showToast(com.baidu.tieba.u.neterror);
                    return;
                }
            }
            com.baidu.tieba.im.data.g liveBlackMembersListData = responseLiveBlackMembersMessage.getLiveBlackMembersListData();
            if (liveBlackMembersListData != null) {
                List<UserData> b = liveBlackMembersListData.b();
                iVar = this.a.a;
                iVar.e().a(liveBlackMembersListData.c());
                yVar = this.a.b;
                yVar.a(liveBlackMembersListData.a());
                f = this.a.f();
                if (!f || liveBlackMembersListData.c()) {
                    iVar2 = this.a.a;
                    iVar2.e().b(false);
                    yVar2 = this.a.b;
                    yVar3 = this.a.b;
                    yVar2.b(yVar3.c() + b.size());
                    yVar4 = this.a.b;
                    yVar5 = this.a.b;
                    yVar4.c(yVar5.d() + 1);
                    iVar3 = this.a.a;
                    iVar3.e().a(b);
                    iVar4 = this.a.a;
                    iVar4.c();
                } else if (b.size() != 0) {
                    iVar5 = this.a.a;
                    iVar5.e().b(true);
                    iVar6 = this.a.a;
                    iVar6.e().a(b);
                    iVar7 = this.a.a;
                    iVar7.c();
                } else {
                    this.a.h();
                }
            }
        } else {
            this.a.showToast(com.baidu.tieba.u.neterror);
        }
    }
}
