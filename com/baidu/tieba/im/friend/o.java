package com.baidu.tieba.im.friend;

import android.os.Handler;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseCommitInviteMessage;
/* loaded from: classes.dex */
class o extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ InviteFriendListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(InviteFriendListActivity inviteFriendListActivity, int i) {
        super(i);
        this.a = inviteFriendListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        this.a.closeLoadingDialog();
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205002 && (socketResponsedMessage instanceof ResponseCommitInviteMessage)) {
            try {
                ResponseCommitInviteMessage responseCommitInviteMessage = (ResponseCommitInviteMessage) socketResponsedMessage;
                if (responseCommitInviteMessage.getError() != 0) {
                    this.a.showToast(responseCommitInviteMessage.getErrorString());
                } else {
                    this.a.showToast(this.a.getString(com.baidu.tieba.y.send_success), false);
                    new Handler().postDelayed(new p(this), 400L);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
