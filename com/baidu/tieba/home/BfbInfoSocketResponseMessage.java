package com.baidu.tieba.home;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetUserBfbInfo.DataRes;
import tbclient.GetUserBfbInfo.GetUserBfbInfoResIdl;
import tbclient.UserBfbInfo;
/* loaded from: classes3.dex */
public class BfbInfoSocketResponseMessage extends SocketResponsedMessage {
    public UserBfbInfo bfbInfo;

    public BfbInfoSocketResponseMessage() {
        super(309366);
    }

    public UserBfbInfo getBfbInfo() {
        return this.bfbInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetUserBfbInfoResIdl getUserBfbInfoResIdl = (GetUserBfbInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetUserBfbInfoResIdl.class);
        if (getUserBfbInfoResIdl == null) {
            return;
        }
        Error error = getUserBfbInfoResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getUserBfbInfoResIdl.error.usermsg);
        }
        DataRes dataRes = getUserBfbInfoResIdl.data;
        if (dataRes != null) {
            this.bfbInfo = dataRes.bfb;
        }
    }
}
