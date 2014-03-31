package com.baidu.tieba.im.friend;

import android.os.Handler;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseCommitInviteMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o extends com.baidu.adp.framework.c.g {
    final /* synthetic */ InviteFriendListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(InviteFriendListActivity inviteFriendListActivity, int i) {
        super(205002);
        this.a = inviteFriendListActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        this.a.closeLoadingDialog();
        if (socketResponsedMessage2 != null && socketResponsedMessage2.g() == 205002 && (socketResponsedMessage2 instanceof ResponseCommitInviteMessage)) {
            try {
                ResponseCommitInviteMessage responseCommitInviteMessage = (ResponseCommitInviteMessage) socketResponsedMessage2;
                if (responseCommitInviteMessage.e() != 0) {
                    this.a.showToast(responseCommitInviteMessage.f());
                } else {
                    this.a.showToast(this.a.getString(com.baidu.tieba.im.j.send_success), false);
                    new Handler().postDelayed(new p(this), 400L);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
