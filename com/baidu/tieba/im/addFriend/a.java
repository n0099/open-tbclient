package com.baidu.tieba.im.addFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseAddFriendMessage;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ AddFriendActivity aNB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AddFriendActivity addFriendActivity, int i) {
        super(i);
        this.aNB = addFriendActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        String str;
        String str2;
        boolean z;
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseAddFriendMessage)) {
            ResponseAddFriendMessage responseAddFriendMessage = (ResponseAddFriendMessage) socketResponsedMessage;
            int error = responseAddFriendMessage.getError();
            String errorString = responseAddFriendMessage.getErrorString();
            if (error == 0) {
                str = this.aNB.userId;
                str2 = this.aNB.name;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001197, new com.baidu.tbadk.coreExtra.data.e(str, str2)));
                z = this.aNB.aNA;
                if (z) {
                    this.aNB.showToast(this.aNB.getString(y.add_ok_but_level_is_lower), false);
                } else {
                    this.aNB.showToast(this.aNB.getString(y.group_apply_succ), false);
                }
                this.aNB.finish();
                return;
            }
            this.aNB.showToast(errorString);
        }
    }
}
