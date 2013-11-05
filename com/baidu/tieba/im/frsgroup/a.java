package com.baidu.tieba.im.frsgroup;

import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseUserPermissionMessage;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class a implements com.baidu.tieba.im.messageCenter.h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsGroupActivity f1552a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FrsGroupActivity frsGroupActivity) {
        this.f1552a = frsGroupActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.h
    public void a(Message message) {
        i iVar;
        i iVar2;
        com.baidu.tieba.im.model.b bVar;
        iVar = this.f1552a.f1545a;
        iVar.d(false);
        iVar2 = this.f1552a.f1545a;
        iVar2.b(true);
        if (message == null || !(message instanceof ResponseUserPermissionMessage)) {
            this.f1552a.b(R.string.neterror);
            return;
        }
        ResponseUserPermissionMessage responseUserPermissionMessage = (ResponseUserPermissionMessage) message;
        if (responseUserPermissionMessage.hasError()) {
            this.f1552a.a(responseUserPermissionMessage.getErrMsg());
            return;
        }
        GroupPermData groupPermData = responseUserPermissionMessage.getGroupPermData();
        if (groupPermData != null) {
            bVar = this.f1552a.b;
            bVar.a(groupPermData);
            this.f1552a.a(groupPermData);
        }
    }
}
