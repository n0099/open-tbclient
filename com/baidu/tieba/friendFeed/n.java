package com.baidu.tieba.friendFeed;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.friendFeed.message.ResponseFriendFeedMessage;
/* loaded from: classes.dex */
class n extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ FriendFeedActivity aHM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(FriendFeedActivity friendFeedActivity, int i) {
        super(i);
        this.aHM = friendFeedActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        y yVar;
        boolean isFirstLoad;
        com.baidu.tieba.friendFeed.a.a aVar;
        boolean isFirstLoad2;
        y yVar2;
        yVar = this.aHM.aHt;
        p Jb = yVar.Jb();
        Jb.bJ(false);
        this.aHM.hideProgress();
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseFriendFeedMessage)) {
            this.aHM.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        ResponseFriendFeedMessage responseFriendFeedMessage = (ResponseFriendFeedMessage) socketResponsedMessage;
        if (responseFriendFeedMessage.getError() != 0) {
            if (responseFriendFeedMessage.getError() > 0) {
                this.aHM.showToast(StringUtils.isNull(responseFriendFeedMessage.getErrorString()) ? this.aHM.getResources().getString(com.baidu.tieba.y.neterror) : responseFriendFeedMessage.getErrorString());
                return;
            }
            Jb.bH(false);
            Jb.notifyDataSetChanged();
            this.aHM.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        com.baidu.tieba.friendFeed.data.a friendFeedData = responseFriendFeedMessage.getFriendFeedData();
        if (friendFeedData != null) {
            isFirstLoad = this.aHM.isFirstLoad();
            if (isFirstLoad) {
                Jb.reset(true);
            }
            Jb.bI(friendFeedData.isHasMore());
            if (!friendFeedData.isHasMore()) {
                isFirstLoad2 = this.aHM.isFirstLoad();
                if (isFirstLoad2 && friendFeedData.Ji().size() == 0) {
                    yVar2 = this.aHM.aHt;
                    yVar2.showNoDataTip(true);
                    return;
                }
            }
            Jb.bH(true);
            Jb.a(friendFeedData);
            aVar = this.aHM.aHu;
            aVar.setTimeline(Jb.IU());
            Jb.notifyDataSetChanged();
        }
    }
}
