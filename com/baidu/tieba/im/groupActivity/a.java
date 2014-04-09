package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseCreateGroupActivityMessage;
/* loaded from: classes.dex */
final class a extends com.baidu.adp.framework.c.g {
    final /* synthetic */ CreateGroupActivityActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(CreateGroupActivityActivity createGroupActivityActivity, int i) {
        super(103120);
        this.a = createGroupActivityActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        boolean z;
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        this.a.e();
        if (socketResponsedMessage2 == null) {
            this.a.c(com.baidu.tieba.im.j.neterror);
        } else if (socketResponsedMessage2.g() == 103120) {
            if (!(socketResponsedMessage2 instanceof ResponseCreateGroupActivityMessage)) {
                if (socketResponsedMessage2.e() != 0) {
                    this.a.a(socketResponsedMessage2.f());
                    return;
                }
                return;
            }
            ResponseCreateGroupActivityMessage responseCreateGroupActivityMessage = (ResponseCreateGroupActivityMessage) socketResponsedMessage2;
            if (responseCreateGroupActivityMessage.e() != 0) {
                this.a.a(responseCreateGroupActivityMessage.f());
                return;
            }
            z = this.a.e;
            if (z) {
                this.a.c(com.baidu.tieba.im.j.group_activity_edit_succ);
            } else {
                this.a.c(com.baidu.tieba.im.j.group_activity_create_succ);
            }
            this.a.setResult(-1);
            this.a.finish();
        }
    }
}
