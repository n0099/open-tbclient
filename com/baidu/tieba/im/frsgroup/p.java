package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.data.MembersData;
import com.baidu.tieba.im.message.RequestMembersMessage;
import com.baidu.tieba.im.message.ResponseMembersMessage;
import java.util.List;
/* loaded from: classes.dex */
class p extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(MembersActivity membersActivity, int i) {
        super(i);
        this.a = membersActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        af afVar;
        RequestMembersMessage requestMembersMessage;
        com.baidu.tieba.im.model.u uVar;
        boolean h;
        boolean h2;
        com.baidu.tieba.im.model.u uVar2;
        com.baidu.tieba.im.model.u uVar3;
        com.baidu.tieba.im.model.u uVar4;
        boolean h3;
        afVar = this.a.b;
        ab f = afVar.f();
        this.a.g();
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseMembersMessage)) {
            this.a.showToast(com.baidu.tieba.x.neterror);
            return;
        }
        ResponseMembersMessage responseMembersMessage = (ResponseMembersMessage) socketResponsedMessage;
        Message<?> orginalMessage = responseMembersMessage.getOrginalMessage();
        if (orginalMessage == null || !(orginalMessage instanceof RequestMembersMessage)) {
            requestMembersMessage = null;
        } else {
            requestMembersMessage = (RequestMembersMessage) orginalMessage;
        }
        uVar = this.a.c;
        uVar.a(requestMembersMessage);
        if (responseMembersMessage.getError() != 0) {
            if (responseMembersMessage.getError() > 0) {
                if (!TextUtils.isEmpty(responseMembersMessage.getErrorString())) {
                    this.a.showToast(responseMembersMessage.getErrorString());
                    return;
                }
                return;
            }
            this.a.showToast(com.baidu.tieba.x.neterror);
            return;
        }
        MembersData membersData = responseMembersMessage.getMembersData();
        List<UserData> users = membersData.getUsers();
        if (users != null) {
            h = this.a.h();
            if (h) {
                this.a.a(membersData.getPermission());
            }
            h2 = this.a.h();
            if (h2) {
                f.a(true);
            }
            int size = users.size();
            uVar2 = this.a.c;
            if (size != uVar2.e()) {
                f.b(false);
                f.c(false);
                h3 = this.a.h();
                if (h3 && users.size() == 0) {
                    this.a.i();
                    return;
                }
            } else {
                f.c(true);
            }
            uVar3 = this.a.c;
            uVar3.c(users.size());
            uVar4 = this.a.c;
            uVar4.d(20);
            f.a(users);
            f.notifyDataSetChanged();
        }
    }
}
