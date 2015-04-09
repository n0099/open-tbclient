package com.baidu.tieba.addresslist.im.searchfriend;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.addresslist.im.searchfriend.cache.RequestRecommendWriteMessage;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class b extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ SearchFriendActivity azf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(SearchFriendActivity searchFriendActivity, int i) {
        super(i);
        this.azf = searchFriendActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        n nVar;
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 304106) {
            if (socketResponsedMessage.hasError() || !(socketResponsedMessage instanceof ResponsedRecommendMessage)) {
                this.azf.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? this.azf.getResources().getString(y.neterror) : socketResponsedMessage.getErrorString(), false);
                return;
            }
            com.baidu.tieba.addresslist.im.searchfriend.a.a recommendFriendInfo = ((ResponsedRecommendMessage) socketResponsedMessage).getRecommendFriendInfo();
            nVar = this.azf.ayX;
            nVar.a(recommendFriendInfo);
            this.azf.sendMessage(new RequestRecommendWriteMessage(recommendFriendInfo));
        }
    }
}
