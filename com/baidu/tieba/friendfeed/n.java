package com.baidu.tieba.friendfeed;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.message.ResponseFriendFeedMessage;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class n extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ FriendFeedActivity aBS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(FriendFeedActivity friendFeedActivity, int i) {
        super(i);
        this.aBS = friendFeedActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        x xVar;
        boolean isFirstLoad;
        com.baidu.tieba.model.l lVar;
        boolean isFirstLoad2;
        x xVar2;
        xVar = this.aBS.aBA;
        p FC = xVar.FC();
        this.aBS.hideProgress();
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseFriendFeedMessage)) {
            this.aBS.showToast(z.neterror);
            return;
        }
        ResponseFriendFeedMessage responseFriendFeedMessage = (ResponseFriendFeedMessage) socketResponsedMessage;
        if (responseFriendFeedMessage.getError() != 0) {
            if (responseFriendFeedMessage.getError() > 0) {
                this.aBS.showToast(responseFriendFeedMessage.getErrorString());
                return;
            }
            FC.bE(false);
            FC.notifyDataSetChanged();
            this.aBS.showToast(z.neterror);
            return;
        }
        com.baidu.tieba.data.i friendFeedData = responseFriendFeedMessage.getFriendFeedData();
        if (friendFeedData != null) {
            isFirstLoad = this.aBS.isFirstLoad();
            if (isFirstLoad) {
                FC.reset(true);
            }
            FC.bF(friendFeedData.isHasMore());
            if (!friendFeedData.isHasMore()) {
                isFirstLoad2 = this.aBS.isFirstLoad();
                if (isFirstLoad2 && friendFeedData.CM().size() == 0) {
                    xVar2 = this.aBS.aBA;
                    xVar2.showNoDataTip(true);
                    return;
                }
            }
            FC.bE(true);
            FC.a(friendFeedData);
            lVar = this.aBS.aBB;
            lVar.setTimeline(FC.Fv());
            FC.notifyDataSetChanged();
        }
    }
}
