package com.baidu.tieba.im.searchfriend;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.searchfriend.cache.RequestRecommendWriteMessage;
/* loaded from: classes.dex */
class b extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ SearchFriendActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(SearchFriendActivity searchFriendActivity, int i) {
        super(i);
        this.a = searchFriendActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        l lVar;
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 304106) {
            if (socketResponsedMessage.hasError() || !(socketResponsedMessage instanceof ResponsedRecommendMessage)) {
                String errorString = socketResponsedMessage.getErrorString();
                if (!TextUtils.isEmpty(errorString)) {
                    this.a.showToast(errorString, false);
                    return;
                }
                return;
            }
            com.baidu.tieba.im.searchfriend.a.a recommendFriendInfo = ((ResponsedRecommendMessage) socketResponsedMessage).getRecommendFriendInfo();
            lVar = this.a.d;
            lVar.a(recommendFriendInfo);
            this.a.sendMessage(new RequestRecommendWriteMessage(recommendFriendInfo));
        }
    }
}
