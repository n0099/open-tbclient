package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseCreateGroupActivityMessage;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ CreateGroupActivityActivity aYA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(CreateGroupActivityActivity createGroupActivityActivity, int i) {
        super(i);
        this.aYA = createGroupActivityActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        boolean z;
        this.aYA.hideProgressBar();
        if (socketResponsedMessage == null) {
            this.aYA.showToast(y.neterror);
        } else if (socketResponsedMessage.getCmd() == 103120) {
            if (socketResponsedMessage instanceof ResponseCreateGroupActivityMessage) {
                ResponseCreateGroupActivityMessage responseCreateGroupActivityMessage = (ResponseCreateGroupActivityMessage) socketResponsedMessage;
                if (responseCreateGroupActivityMessage.getError() == 0) {
                    z = this.aYA.aYz;
                    if (z) {
                        this.aYA.showToast(y.group_activity_edit_succ);
                    } else {
                        this.aYA.showToast(y.group_activity_create_succ);
                    }
                    this.aYA.setResult(-1);
                    this.aYA.finish();
                    return;
                }
                this.aYA.showToast(responseCreateGroupActivityMessage.getErrorString());
            } else if (socketResponsedMessage.getError() != 0) {
                this.aYA.showToast(socketResponsedMessage.getErrorString());
            }
        }
    }
}
