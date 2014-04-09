package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.message.ResponseUserPermissionMessage;
/* loaded from: classes.dex */
final class a extends com.baidu.adp.framework.c.g {
    final /* synthetic */ FrsGroupActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(FrsGroupActivity frsGroupActivity, int i) {
        super(103008);
        this.a = frsGroupActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        k kVar;
        k kVar2;
        com.baidu.tieba.im.model.k kVar3;
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        kVar = this.a.c;
        kVar.d(false);
        kVar2 = this.a.c;
        kVar2.b(true);
        if (socketResponsedMessage2 == null || !(socketResponsedMessage2 instanceof ResponseUserPermissionMessage)) {
            this.a.c(com.baidu.tieba.im.j.neterror);
            return;
        }
        ResponseUserPermissionMessage responseUserPermissionMessage = (ResponseUserPermissionMessage) socketResponsedMessage2;
        if (responseUserPermissionMessage.e() != 0) {
            if (responseUserPermissionMessage.e() <= 0) {
                this.a.c(com.baidu.tieba.im.j.neterror);
                return;
            } else if (TextUtils.isEmpty(responseUserPermissionMessage.f())) {
                return;
            } else {
                this.a.a(responseUserPermissionMessage.f());
                return;
            }
        }
        GroupPermData d = responseUserPermissionMessage.d();
        if (d != null) {
            kVar3 = this.a.d;
            kVar3.a(d);
            FrsGroupActivity.a(this.a, d);
        }
    }
}
