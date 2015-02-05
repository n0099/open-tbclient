package com.baidu.tieba.im.addFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.coreExtra.data.h;
import com.baidu.tbadk.newFriends.ResponseAddFriendMessage;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ AddFriendActivity aQT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AddFriendActivity addFriendActivity, int i) {
        super(i);
        this.aQT = addFriendActivity;
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
                str = this.aQT.userId;
                str2 = this.aQT.name;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001197, new h(str, str2)));
                z = this.aQT.aQS;
                if (z) {
                    this.aQT.showToast(this.aQT.getPageContext().getPageActivity().getString(z.add_ok_but_level_is_lower), false);
                } else {
                    this.aQT.showToast(this.aQT.getPageContext().getPageActivity().getString(z.group_apply_succ), false);
                }
                this.aQT.finish();
                return;
            }
            BdToast.a(this.aQT.getPageContext().getPageActivity(), errorString, BdToast.DefaultIcon.NOT).nU();
        }
    }
}
