package com.baidu.tieba.friendfeed;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.message.ResponseFriendFeedMessage;
/* loaded from: classes.dex */
class o extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ FriendFeedActivity aAU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(FriendFeedActivity friendFeedActivity, int i) {
        super(i);
        this.aAU = friendFeedActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        y yVar;
        boolean isFirstLoad;
        com.baidu.tieba.model.l lVar;
        boolean isFirstLoad2;
        y yVar2;
        yVar = this.aAU.aAB;
        q Fk = yVar.Fk();
        this.aAU.hideProgress();
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseFriendFeedMessage)) {
            this.aAU.showToast(com.baidu.tieba.z.neterror);
            return;
        }
        ResponseFriendFeedMessage responseFriendFeedMessage = (ResponseFriendFeedMessage) socketResponsedMessage;
        if (responseFriendFeedMessage.getError() != 0) {
            if (responseFriendFeedMessage.getError() > 0) {
                this.aAU.showToast(responseFriendFeedMessage.getErrorString());
                return;
            }
            Fk.bB(false);
            Fk.notifyDataSetChanged();
            this.aAU.showToast(com.baidu.tieba.z.neterror);
            return;
        }
        com.baidu.tieba.data.i friendFeedData = responseFriendFeedMessage.getFriendFeedData();
        if (friendFeedData != null) {
            isFirstLoad = this.aAU.isFirstLoad();
            if (isFirstLoad) {
                Fk.reset(true);
            }
            Fk.bC(friendFeedData.isHasMore());
            if (!friendFeedData.isHasMore()) {
                isFirstLoad2 = this.aAU.isFirstLoad();
                if (isFirstLoad2 && friendFeedData.Ct().size() == 0) {
                    yVar2 = this.aAU.aAB;
                    yVar2.showNoDataTip(true);
                    return;
                }
            }
            Fk.bB(true);
            Fk.a(friendFeedData);
            lVar = this.aAU.aAC;
            lVar.setTimeline(Fk.Fd());
            Fk.notifyDataSetChanged();
        }
    }
}
