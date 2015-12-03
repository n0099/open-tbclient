package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.addresslist.im.newFriend.ay;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends HttpMessageListener {
    final /* synthetic */ ay aJh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az(ay ayVar, int i) {
        super(i);
        this.aJh = ayVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        ay.a aVar;
        ay.a aVar2;
        ay.a aVar3;
        ay.a aVar4;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001900) {
            if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof RecommendFriendResponseMessage)) {
                aVar = this.aJh.aJd;
                if (aVar != null) {
                    aVar2 = this.aJh.aJd;
                    aVar2.bK(null);
                    return;
                }
                return;
            }
            RecommendFriendResponseMessage recommendFriendResponseMessage = (RecommendFriendResponseMessage) httpResponsedMessage;
            String errMsg = recommendFriendResponseMessage.getErrMsg();
            if (recommendFriendResponseMessage.getError() != 0) {
                aVar3 = this.aJh.aJd;
                if (aVar3 != null) {
                    aVar4 = this.aJh.aJd;
                    aVar4.bK(errMsg);
                    return;
                }
                return;
            }
            com.baidu.tbadk.util.n.b(new ba(this, recommendFriendResponseMessage.getDatas()), new bb(this, errMsg));
        }
    }
}
