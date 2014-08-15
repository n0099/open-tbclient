package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.message.ResponseUserPermissionMessage;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ FrsGroupActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(FrsGroupActivity frsGroupActivity, int i) {
        super(i);
        this.a = frsGroupActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        j jVar;
        j jVar2;
        com.baidu.tieba.im.model.i iVar;
        jVar = this.a.d;
        jVar.d(false);
        jVar2 = this.a.d;
        jVar2.b(true);
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseUserPermissionMessage)) {
            this.a.c(com.baidu.tieba.x.neterror);
            return;
        }
        ResponseUserPermissionMessage responseUserPermissionMessage = (ResponseUserPermissionMessage) socketResponsedMessage;
        if (responseUserPermissionMessage.getError() != 0) {
            if (responseUserPermissionMessage.getError() > 0) {
                if (!TextUtils.isEmpty(responseUserPermissionMessage.getErrorString())) {
                    this.a.a(responseUserPermissionMessage.getErrorString());
                    return;
                }
                return;
            }
            this.a.c(com.baidu.tieba.x.neterror);
            return;
        }
        GroupPermData groupPermData = responseUserPermissionMessage.getGroupPermData();
        if (groupPermData != null) {
            iVar = this.a.e;
            iVar.a(groupPermData);
            this.a.a(groupPermData);
        }
    }
}
