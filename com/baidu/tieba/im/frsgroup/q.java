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
class q extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(MembersActivity membersActivity, int i) {
        super(i);
        this.a = membersActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        ah ahVar;
        RequestMembersMessage requestMembersMessage;
        com.baidu.tieba.im.model.ad adVar;
        boolean i;
        boolean i2;
        com.baidu.tieba.im.model.ad adVar2;
        com.baidu.tieba.im.model.ad adVar3;
        com.baidu.tieba.im.model.ad adVar4;
        boolean i3;
        ahVar = this.a.b;
        ad f = ahVar.f();
        this.a.h();
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseMembersMessage)) {
            this.a.showToast(com.baidu.tieba.u.neterror);
            return;
        }
        ResponseMembersMessage responseMembersMessage = (ResponseMembersMessage) socketResponsedMessage;
        Message<?> orginalMessage = responseMembersMessage.getOrginalMessage();
        if (orginalMessage == null || !(orginalMessage instanceof RequestMembersMessage)) {
            requestMembersMessage = null;
        } else {
            requestMembersMessage = (RequestMembersMessage) orginalMessage;
        }
        adVar = this.a.c;
        adVar.a(requestMembersMessage);
        if (responseMembersMessage.getError() != 0) {
            if (responseMembersMessage.getError() > 0) {
                if (!TextUtils.isEmpty(responseMembersMessage.getErrorString())) {
                    this.a.showToast(responseMembersMessage.getErrorString());
                    return;
                }
                return;
            }
            this.a.showToast(com.baidu.tieba.u.neterror);
            return;
        }
        MembersData membersData = responseMembersMessage.getMembersData();
        List<UserData> users = membersData.getUsers();
        if (users != null) {
            i = this.a.i();
            if (i) {
                this.a.a(membersData.getPermission());
            }
            i2 = this.a.i();
            if (i2) {
                f.a(true);
            }
            int size = users.size();
            adVar2 = this.a.c;
            if (size != adVar2.e()) {
                f.b(false);
                f.c(false);
                i3 = this.a.i();
                if (i3 && users.size() == 0) {
                    this.a.j();
                    return;
                }
            } else {
                f.c(true);
            }
            adVar3 = this.a.c;
            adVar3.c(users.size());
            adVar4 = this.a.c;
            adVar4.d(20);
            f.a(users);
            f.notifyDataSetChanged();
            this.a.c();
        }
    }
}
