package com.baidu.tieba.friendfeed;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.message.ResponseFriendFeedMessage;
import com.baidu.tieba.model.ac;
/* loaded from: classes.dex */
class o extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ FriendFeedActivity ayL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(FriendFeedActivity friendFeedActivity, int i) {
        super(i);
        this.ayL = friendFeedActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        y yVar;
        boolean isFirstLoad;
        ac acVar;
        boolean isFirstLoad2;
        y yVar2;
        yVar = this.ayL.ayq;
        q EQ = yVar.EQ();
        this.ayL.hideProgress();
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseFriendFeedMessage)) {
            this.ayL.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        ResponseFriendFeedMessage responseFriendFeedMessage = (ResponseFriendFeedMessage) socketResponsedMessage;
        if (responseFriendFeedMessage.getError() != 0) {
            if (responseFriendFeedMessage.getError() > 0) {
                this.ayL.showToast(responseFriendFeedMessage.getErrorString());
                return;
            }
            EQ.bN(false);
            EQ.notifyDataSetChanged();
            this.ayL.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        com.baidu.tieba.data.s friendFeedData = responseFriendFeedMessage.getFriendFeedData();
        if (friendFeedData != null) {
            isFirstLoad = this.ayL.isFirstLoad();
            if (isFirstLoad) {
                EQ.bM(true);
            }
            EQ.bO(friendFeedData.isHasMore());
            if (!friendFeedData.isHasMore()) {
                isFirstLoad2 = this.ayL.isFirstLoad();
                if (isFirstLoad2 && friendFeedData.zf().size() == 0) {
                    yVar2 = this.ayL.ayq;
                    yVar2.bP(true);
                    return;
                }
            }
            EQ.bN(true);
            EQ.a(friendFeedData);
            acVar = this.ayL.ayr;
            acVar.setTimeline(EQ.EK());
            EQ.notifyDataSetChanged();
        }
    }
}
