package com.baidu.tieba.im.friend;

import android.os.Handler;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseCommitInviteMessage;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class l extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ InviteFriendListActivity aWb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(InviteFriendListActivity inviteFriendListActivity, int i) {
        super(i);
        this.aWb = inviteFriendListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        this.aWb.closeLoadingDialog();
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205002 && (socketResponsedMessage instanceof ResponseCommitInviteMessage)) {
            ResponseCommitInviteMessage responseCommitInviteMessage = (ResponseCommitInviteMessage) socketResponsedMessage;
            if (responseCommitInviteMessage.getError() != 0) {
                this.aWb.showToast(responseCommitInviteMessage.getErrorString());
                return;
            }
            this.aWb.showToast(this.aWb.getString(y.send_success), false);
            new Handler().postDelayed(new m(this), 400L);
        }
    }
}
