package com.baidu.tieba.im.live;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import protobuf.GetAccessToken.GetAccessTokenResIdl;
/* loaded from: classes.dex */
public class ResponseGetAccessTokenMessage extends SocketResponsedMessage {
    private String accessToken;
    private int leftExpiredTimeInSeconds;

    public ResponseGetAccessTokenMessage() {
        super(107201);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        GetAccessTokenResIdl getAccessTokenResIdl = (GetAccessTokenResIdl) new Wire(new Class[0]).parseFrom(bArr, GetAccessTokenResIdl.class);
        setError(getAccessTokenResIdl.error.errorno.intValue());
        setErrorString(getAccessTokenResIdl.error.usermsg);
        if (getError() == 0) {
            this.accessToken = getAccessTokenResIdl.data.accessToken;
            this.leftExpiredTimeInSeconds = getAccessTokenResIdl.data.expireTime.intValue();
        }
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public int getLeftExpiredTimeInSeconds() {
        return this.leftExpiredTimeInSeconds;
    }
}
