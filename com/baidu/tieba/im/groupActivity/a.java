package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseCreateGroupActivityMessage;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ CreateGroupActivityActivity aYN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(CreateGroupActivityActivity createGroupActivityActivity, int i) {
        super(i);
        this.aYN = createGroupActivityActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        boolean z;
        this.aYN.hideProgressBar();
        if (socketResponsedMessage == null) {
            this.aYN.showToast(y.neterror);
        } else if (socketResponsedMessage.getCmd() == 103120) {
            if (socketResponsedMessage instanceof ResponseCreateGroupActivityMessage) {
                ResponseCreateGroupActivityMessage responseCreateGroupActivityMessage = (ResponseCreateGroupActivityMessage) socketResponsedMessage;
                if (responseCreateGroupActivityMessage.getError() == 0) {
                    z = this.aYN.aYM;
                    if (z) {
                        this.aYN.showToast(y.group_activity_edit_succ);
                    } else {
                        this.aYN.showToast(y.group_activity_create_succ);
                    }
                    this.aYN.setResult(-1);
                    this.aYN.finish();
                    return;
                }
                this.aYN.showToast(responseCreateGroupActivityMessage.getErrorString());
            } else if (socketResponsedMessage.getError() != 0) {
                this.aYN.showToast(socketResponsedMessage.getErrorString());
            }
        }
    }
}
