package com.baidu.tieba.addresslist.im.searchfriend;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.addresslist.im.searchfriend.cache.RequestRecommendWriteMessage;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class b extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ SearchFriendActivity aJw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(SearchFriendActivity searchFriendActivity, int i) {
        super(i);
        this.aJw = searchFriendActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        m mVar;
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 304106) {
            if (socketResponsedMessage.hasError() || !(socketResponsedMessage instanceof ResponsedRecommendMessage)) {
                this.aJw.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? this.aJw.getResources().getString(n.i.neterror) : socketResponsedMessage.getErrorString(), false);
                return;
            }
            com.baidu.tieba.addresslist.im.searchfriend.a.a recommendFriendInfo = ((ResponsedRecommendMessage) socketResponsedMessage).getRecommendFriendInfo();
            mVar = this.aJw.aJo;
            mVar.a(recommendFriendInfo);
            this.aJw.sendMessage(new RequestRecommendWriteMessage(recommendFriendInfo));
        }
    }
}
