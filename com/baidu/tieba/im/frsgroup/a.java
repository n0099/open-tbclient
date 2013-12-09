package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseUserPermissionMessage;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class a implements com.baidu.tieba.im.messageCenter.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsGroupActivity f1701a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FrsGroupActivity frsGroupActivity) {
        this.f1701a = frsGroupActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(Message message) {
        g gVar;
        g gVar2;
        com.baidu.tieba.im.model.b bVar;
        gVar = this.f1701a.b;
        gVar.d(false);
        gVar2 = this.f1701a.b;
        gVar2.b(true);
        if (message == null || !(message instanceof ResponseUserPermissionMessage)) {
            this.f1701a.b(R.string.neterror);
            return;
        }
        ResponseUserPermissionMessage responseUserPermissionMessage = (ResponseUserPermissionMessage) message;
        if (responseUserPermissionMessage.hasError()) {
            if (responseUserPermissionMessage.getErrNo() > 0) {
                if (!TextUtils.isEmpty(responseUserPermissionMessage.getErrMsg())) {
                    this.f1701a.b(responseUserPermissionMessage.getErrMsg());
                    return;
                }
                return;
            }
            this.f1701a.b(R.string.neterror);
            return;
        }
        GroupPermData groupPermData = responseUserPermissionMessage.getGroupPermData();
        if (groupPermData != null) {
            bVar = this.f1701a.c;
            bVar.a(groupPermData);
            this.f1701a.a(groupPermData);
        }
    }
}
