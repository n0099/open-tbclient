package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import com.baidu.tieba.im.data.MembersData;
import com.baidu.tieba.im.data.UserData;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.RequestMembersMessage;
import com.baidu.tieba.im.message.ResponseMembersMessage;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
class r implements com.baidu.tieba.im.messageCenter.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MembersActivity f1720a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(MembersActivity membersActivity) {
        this.f1720a = membersActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(Message message) {
        aa aaVar;
        RequestMembersMessage requestMembersMessage;
        com.baidu.tieba.im.model.h hVar;
        boolean i;
        boolean i2;
        com.baidu.tieba.im.model.h hVar2;
        com.baidu.tieba.im.model.h hVar3;
        com.baidu.tieba.im.model.h hVar4;
        boolean i3;
        aaVar = this.f1720a.b;
        w i4 = aaVar.i();
        this.f1720a.h();
        if (message == null || !(message instanceof ResponseMembersMessage)) {
            this.f1720a.showToast(R.string.neterror);
            return;
        }
        ResponseMembersMessage responseMembersMessage = (ResponseMembersMessage) message;
        Message orginalMessage = responseMembersMessage.getOrginalMessage();
        if (orginalMessage == null || !(orginalMessage instanceof RequestMembersMessage)) {
            requestMembersMessage = null;
        } else {
            requestMembersMessage = (RequestMembersMessage) orginalMessage;
        }
        hVar = this.f1720a.c;
        hVar.a(requestMembersMessage);
        if (responseMembersMessage.hasError()) {
            if (responseMembersMessage.getErrNo() > 0) {
                if (!TextUtils.isEmpty(responseMembersMessage.getErrMsg())) {
                    this.f1720a.showToast(responseMembersMessage.getErrMsg());
                    return;
                }
                return;
            }
            this.f1720a.showToast(R.string.neterror);
            return;
        }
        MembersData membersData = responseMembersMessage.getMembersData();
        List<UserData> users = membersData.getUsers();
        if (users != null) {
            i = this.f1720a.i();
            if (i) {
                this.f1720a.a(membersData.getPermission());
            }
            i2 = this.f1720a.i();
            if (i2) {
                i4.a(true);
            }
            int size = users.size();
            hVar2 = this.f1720a.c;
            if (size != hVar2.f()) {
                i4.b(false);
                i4.c(false);
                i3 = this.f1720a.i();
                if (i3 && users.size() == 0) {
                    this.f1720a.j();
                    return;
                }
            } else {
                i4.c(true);
            }
            hVar3 = this.f1720a.c;
            hVar3.c(users.size());
            hVar4 = this.f1720a.c;
            hVar4.d(20);
            i4.a(users);
            i4.notifyDataSetChanged();
            this.f1720a.c();
        }
    }
}
