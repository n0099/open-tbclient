package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb extends HttpMessageListener {
    final /* synthetic */ ba bkn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bb(ba baVar, int i) {
        super(i);
        this.bkn = baVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        be beVar;
        be beVar2;
        be beVar3;
        be beVar4;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001900) {
            if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof RecommendFriendResponseMessage)) {
                beVar = this.bkn.bkj;
                if (beVar != null) {
                    beVar2 = this.bkn.bkj;
                    beVar2.fw(null);
                    return;
                }
                return;
            }
            RecommendFriendResponseMessage recommendFriendResponseMessage = (RecommendFriendResponseMessage) httpResponsedMessage;
            String errMsg = recommendFriendResponseMessage.getErrMsg();
            if (recommendFriendResponseMessage.getError() != 0) {
                beVar3 = this.bkn.bkj;
                if (beVar3 != null) {
                    beVar4 = this.bkn.bkj;
                    beVar4.fw(errMsg);
                    return;
                }
                return;
            }
            com.baidu.tieba.im.i.a(new bc(this, recommendFriendResponseMessage.getDatas()), new bd(this, errMsg));
        }
    }
}
