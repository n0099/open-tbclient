package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends HttpMessageListener {
    final /* synthetic */ aw a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ax(aw awVar, int i) {
        super(i);
        this.a = awVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        ba baVar;
        ba baVar2;
        ba baVar3;
        ba baVar4;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001900) {
            if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof RecommendFriendResponseMessage)) {
                baVar = this.a.a;
                if (baVar != null) {
                    baVar2 = this.a.a;
                    baVar2.b(null);
                    return;
                }
                return;
            }
            RecommendFriendResponseMessage recommendFriendResponseMessage = (RecommendFriendResponseMessage) httpResponsedMessage;
            String errMsg = recommendFriendResponseMessage.getErrMsg();
            if (recommendFriendResponseMessage.getError() != 0) {
                baVar3 = this.a.a;
                if (baVar3 != null) {
                    baVar4 = this.a.a;
                    baVar4.b(errMsg);
                    return;
                }
                return;
            }
            com.baidu.tieba.im.e.a(new ay(this, recommendFriendResponseMessage.getDatas()), new az(this, errMsg));
        }
    }
}
