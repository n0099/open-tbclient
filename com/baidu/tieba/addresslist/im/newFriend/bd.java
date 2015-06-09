package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd extends HttpMessageListener {
    final /* synthetic */ bc aAD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bd(bc bcVar, int i) {
        super(i);
        this.aAD = bcVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        bg bgVar;
        bg bgVar2;
        bg bgVar3;
        bg bgVar4;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001900) {
            if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof RecommendFriendResponseMessage)) {
                bgVar = this.aAD.aAz;
                if (bgVar != null) {
                    bgVar2 = this.aAD.aAz;
                    bgVar2.fB(null);
                    return;
                }
                return;
            }
            RecommendFriendResponseMessage recommendFriendResponseMessage = (RecommendFriendResponseMessage) httpResponsedMessage;
            String errMsg = recommendFriendResponseMessage.getErrMsg();
            if (recommendFriendResponseMessage.getError() != 0) {
                bgVar3 = this.aAD.aAz;
                if (bgVar3 != null) {
                    bgVar4 = this.aAD.aAz;
                    bgVar4.fB(errMsg);
                    return;
                }
                return;
            }
            com.baidu.tieba.im.l.a(new be(this, recommendFriendResponseMessage.getDatas()), new bf(this, errMsg));
        }
    }
}
