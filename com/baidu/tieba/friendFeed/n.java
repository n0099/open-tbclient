package com.baidu.tieba.friendFeed;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.friendFeed.message.ResponseFriendFeedMessage;
/* loaded from: classes.dex */
class n extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ FriendFeedActivity aHU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(FriendFeedActivity friendFeedActivity, int i) {
        super(i);
        this.aHU = friendFeedActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        y yVar;
        boolean isFirstLoad;
        com.baidu.tieba.friendFeed.a.a aVar;
        boolean isFirstLoad2;
        y yVar2;
        yVar = this.aHU.aHB;
        p Jh = yVar.Jh();
        Jh.bJ(false);
        this.aHU.hideProgress();
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseFriendFeedMessage)) {
            this.aHU.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        ResponseFriendFeedMessage responseFriendFeedMessage = (ResponseFriendFeedMessage) socketResponsedMessage;
        if (responseFriendFeedMessage.getError() != 0) {
            if (responseFriendFeedMessage.getError() > 0) {
                this.aHU.showToast(StringUtils.isNull(responseFriendFeedMessage.getErrorString()) ? this.aHU.getResources().getString(com.baidu.tieba.y.neterror) : responseFriendFeedMessage.getErrorString());
                return;
            }
            Jh.bH(false);
            Jh.notifyDataSetChanged();
            this.aHU.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        com.baidu.tieba.friendFeed.data.a friendFeedData = responseFriendFeedMessage.getFriendFeedData();
        if (friendFeedData != null) {
            isFirstLoad = this.aHU.isFirstLoad();
            if (isFirstLoad) {
                Jh.reset(true);
            }
            Jh.bI(friendFeedData.isHasMore());
            if (!friendFeedData.isHasMore()) {
                isFirstLoad2 = this.aHU.isFirstLoad();
                if (isFirstLoad2 && friendFeedData.Jo().size() == 0) {
                    yVar2 = this.aHU.aHB;
                    yVar2.showNoDataTip(true);
                    return;
                }
            }
            Jh.bH(true);
            Jh.a(friendFeedData);
            aVar = this.aHU.aHC;
            aVar.setTimeline(Jh.Ja());
            Jh.notifyDataSetChanged();
        }
    }
}
