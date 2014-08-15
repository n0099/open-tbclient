package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseCreateGroupActivityMessage;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ CreateGroupActivityActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(CreateGroupActivityActivity createGroupActivityActivity, int i) {
        super(i);
        this.a = createGroupActivityActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        boolean z;
        this.a.e();
        if (socketResponsedMessage == null) {
            this.a.c(x.neterror);
        } else if (socketResponsedMessage.getCmd() == 103120) {
            if (socketResponsedMessage instanceof ResponseCreateGroupActivityMessage) {
                ResponseCreateGroupActivityMessage responseCreateGroupActivityMessage = (ResponseCreateGroupActivityMessage) socketResponsedMessage;
                if (responseCreateGroupActivityMessage.getError() == 0) {
                    z = this.a.f;
                    if (z) {
                        this.a.c(x.group_activity_edit_succ);
                    } else {
                        this.a.c(x.group_activity_create_succ);
                    }
                    this.a.setResult(-1);
                    this.a.finish();
                    return;
                }
                this.a.a(responseCreateGroupActivityMessage.getErrorString());
            } else if (socketResponsedMessage.getError() != 0) {
                this.a.a(socketResponsedMessage.getErrorString());
            }
        }
    }
}
