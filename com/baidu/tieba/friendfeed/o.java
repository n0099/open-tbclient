package com.baidu.tieba.friendfeed;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.message.ResponseFriendFeedMessage;
import com.baidu.tieba.model.ac;
/* loaded from: classes.dex */
class o extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ FriendFeedActivity ayU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(FriendFeedActivity friendFeedActivity, int i) {
        super(i);
        this.ayU = friendFeedActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        y yVar;
        boolean isFirstLoad;
        ac acVar;
        boolean isFirstLoad2;
        y yVar2;
        yVar = this.ayU.ayz;
        q ES = yVar.ES();
        this.ayU.hideProgress();
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseFriendFeedMessage)) {
            this.ayU.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        ResponseFriendFeedMessage responseFriendFeedMessage = (ResponseFriendFeedMessage) socketResponsedMessage;
        if (responseFriendFeedMessage.getError() != 0) {
            if (responseFriendFeedMessage.getError() > 0) {
                this.ayU.showToast(responseFriendFeedMessage.getErrorString());
                return;
            }
            ES.bN(false);
            ES.notifyDataSetChanged();
            this.ayU.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        com.baidu.tieba.data.s friendFeedData = responseFriendFeedMessage.getFriendFeedData();
        if (friendFeedData != null) {
            isFirstLoad = this.ayU.isFirstLoad();
            if (isFirstLoad) {
                ES.bM(true);
            }
            ES.bO(friendFeedData.isHasMore());
            if (!friendFeedData.isHasMore()) {
                isFirstLoad2 = this.ayU.isFirstLoad();
                if (isFirstLoad2 && friendFeedData.zh().size() == 0) {
                    yVar2 = this.ayU.ayz;
                    yVar2.bP(true);
                    return;
                }
            }
            ES.bN(true);
            ES.a(friendFeedData);
            acVar = this.ayU.ayA;
            acVar.setTimeline(ES.EM());
            ES.notifyDataSetChanged();
        }
    }
}
