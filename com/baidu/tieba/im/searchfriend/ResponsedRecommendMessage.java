package com.baidu.tieba.im.searchfriend;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import protobuf.RecommendFriend.RecommendFriendResIdl;
/* loaded from: classes.dex */
public class ResponsedRecommendMessage extends SocketResponsedMessage {
    private com.baidu.tieba.im.searchfriend.a.a recommendFriends;

    public ResponsedRecommendMessage() {
        super(304106);
        this.recommendFriends = new com.baidu.tieba.im.searchfriend.a.a();
    }

    public com.baidu.tieba.im.searchfriend.a.a getRecommendFriendInfo() {
        return this.recommendFriends;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        RecommendFriendResIdl recommendFriendResIdl = (RecommendFriendResIdl) new Wire(new Class[0]).parseFrom(bArr, RecommendFriendResIdl.class);
        setError(recommendFriendResIdl.error.errorno.intValue());
        setErrorString(recommendFriendResIdl.error.usermsg);
        if (recommendFriendResIdl != null) {
            this.recommendFriends.a(recommendFriendResIdl);
        }
    }
}
