package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends HttpMessageListener {
    final /* synthetic */ ap a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq(ap apVar, int i) {
        super(i);
        this.a = apVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        at atVar;
        at atVar2;
        at atVar3;
        at atVar4;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001900) {
            if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof RecommendFriendResponseMessage)) {
                atVar = this.a.a;
                if (atVar != null) {
                    atVar2 = this.a.a;
                    atVar2.b(null);
                    return;
                }
                return;
            }
            RecommendFriendResponseMessage recommendFriendResponseMessage = (RecommendFriendResponseMessage) httpResponsedMessage;
            String errMsg = recommendFriendResponseMessage.getErrMsg();
            if (recommendFriendResponseMessage.getError() != 0) {
                atVar3 = this.a.a;
                if (atVar3 != null) {
                    atVar4 = this.a.a;
                    atVar4.b(errMsg);
                    return;
                }
                return;
            }
            com.baidu.tieba.im.i.a(new ar(this, recommendFriendResponseMessage.getDatas()), new as(this, errMsg));
        }
    }
}
