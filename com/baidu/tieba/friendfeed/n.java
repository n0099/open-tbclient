package com.baidu.tieba.friendfeed;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.message.ResponseFriendFeedMessage;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class n extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ FriendFeedActivity aBV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(FriendFeedActivity friendFeedActivity, int i) {
        super(i);
        this.aBV = friendFeedActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        x xVar;
        boolean isFirstLoad;
        com.baidu.tieba.model.l lVar;
        boolean isFirstLoad2;
        x xVar2;
        xVar = this.aBV.aBD;
        p FI = xVar.FI();
        this.aBV.hideProgress();
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseFriendFeedMessage)) {
            this.aBV.showToast(z.neterror);
            return;
        }
        ResponseFriendFeedMessage responseFriendFeedMessage = (ResponseFriendFeedMessage) socketResponsedMessage;
        if (responseFriendFeedMessage.getError() != 0) {
            if (responseFriendFeedMessage.getError() > 0) {
                this.aBV.showToast(responseFriendFeedMessage.getErrorString());
                return;
            }
            FI.bE(false);
            FI.notifyDataSetChanged();
            this.aBV.showToast(z.neterror);
            return;
        }
        com.baidu.tieba.data.i friendFeedData = responseFriendFeedMessage.getFriendFeedData();
        if (friendFeedData != null) {
            isFirstLoad = this.aBV.isFirstLoad();
            if (isFirstLoad) {
                FI.reset(true);
            }
            FI.bF(friendFeedData.isHasMore());
            if (!friendFeedData.isHasMore()) {
                isFirstLoad2 = this.aBV.isFirstLoad();
                if (isFirstLoad2 && friendFeedData.CS().size() == 0) {
                    xVar2 = this.aBV.aBD;
                    xVar2.showNoDataTip(true);
                    return;
                }
            }
            FI.bE(true);
            FI.a(friendFeedData);
            lVar = this.aBV.aBE;
            lVar.setTimeline(FI.FB());
            FI.notifyDataSetChanged();
        }
    }
}
