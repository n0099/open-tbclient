package com.baidu.tieba.im.friend;

import android.os.Handler;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseCommitInviteMessage;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class l extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ InviteFriendListActivity bas;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(InviteFriendListActivity inviteFriendListActivity, int i) {
        super(i);
        this.bas = inviteFriendListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        this.bas.closeLoadingDialog();
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205002 && (socketResponsedMessage instanceof ResponseCommitInviteMessage)) {
            ResponseCommitInviteMessage responseCommitInviteMessage = (ResponseCommitInviteMessage) socketResponsedMessage;
            if (responseCommitInviteMessage.getError() != 0) {
                this.bas.showToast(responseCommitInviteMessage.getErrorString());
                return;
            }
            this.bas.showToast(this.bas.getPageContext().getString(z.send_success), false);
            new Handler().postDelayed(new m(this), 400L);
        }
    }
}
