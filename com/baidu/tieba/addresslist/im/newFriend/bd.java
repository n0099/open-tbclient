package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd extends HttpMessageListener {
    final /* synthetic */ bc ayR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bd(bc bcVar, int i) {
        super(i);
        this.ayR = bcVar;
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
                bgVar = this.ayR.ayN;
                if (bgVar != null) {
                    bgVar2 = this.ayR.ayN;
                    bgVar2.fg(null);
                    return;
                }
                return;
            }
            RecommendFriendResponseMessage recommendFriendResponseMessage = (RecommendFriendResponseMessage) httpResponsedMessage;
            String errMsg = recommendFriendResponseMessage.getErrMsg();
            if (recommendFriendResponseMessage.getError() != 0) {
                bgVar3 = this.ayR.ayN;
                if (bgVar3 != null) {
                    bgVar4 = this.ayR.ayN;
                    bgVar4.fg(errMsg);
                    return;
                }
                return;
            }
            com.baidu.tieba.im.l.a(new be(this, recommendFriendResponseMessage.getDatas()), new bf(this, errMsg));
        }
    }
}
