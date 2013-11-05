package com.baidu.tieba.im.frsgroup;

import com.baidu.tieba.im.data.MembersData;
import com.baidu.tieba.im.data.UserData;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.RequestMembersMessage;
import com.baidu.tieba.im.message.ResponseMembersMessage;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
class v implements com.baidu.tieba.im.messageCenter.h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MembersActivity f1577a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(MembersActivity membersActivity) {
        this.f1577a = membersActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.h
    public void a(Message message) {
        ae aeVar;
        RequestMembersMessage requestMembersMessage;
        com.baidu.tieba.im.model.h hVar;
        boolean p;
        boolean p2;
        com.baidu.tieba.im.model.h hVar2;
        com.baidu.tieba.im.model.h hVar3;
        com.baidu.tieba.im.model.h hVar4;
        boolean p3;
        aeVar = this.f1577a.f1551a;
        aa i = aeVar.i();
        this.f1577a.o();
        if (message == null || !(message instanceof ResponseMembersMessage)) {
            this.f1577a.b(R.string.neterror);
            return;
        }
        ResponseMembersMessage responseMembersMessage = (ResponseMembersMessage) message;
        Message orginalMessage = responseMembersMessage.getOrginalMessage();
        if (orginalMessage == null || !(orginalMessage instanceof RequestMembersMessage)) {
            requestMembersMessage = null;
        } else {
            requestMembersMessage = (RequestMembersMessage) orginalMessage;
        }
        hVar = this.f1577a.b;
        hVar.a(requestMembersMessage);
        if (responseMembersMessage.hasError()) {
            this.f1577a.a(responseMembersMessage.getErrMsg());
            return;
        }
        MembersData membersData = responseMembersMessage.getMembersData();
        List<UserData> users = membersData.getUsers();
        if (users != null) {
            p = this.f1577a.p();
            if (p) {
                this.f1577a.a(membersData.getPermission());
            }
            p2 = this.f1577a.p();
            if (p2) {
                i.a(true);
            }
            int size = users.size();
            hVar2 = this.f1577a.b;
            if (size != hVar2.f()) {
                i.b(false);
                i.c(false);
                p3 = this.f1577a.p();
                if (p3 && users.size() == 0) {
                    this.f1577a.q();
                    return;
                }
            } else {
                i.c(true);
            }
            hVar3 = this.f1577a.b;
            hVar3.c(users.size());
            hVar4 = this.f1577a.b;
            hVar4.d(20);
            i.a(users);
            i.notifyDataSetChanged();
            this.f1577a.c();
        }
    }
}
