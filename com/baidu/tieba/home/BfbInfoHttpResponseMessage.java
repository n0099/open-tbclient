package com.baidu.tieba.home;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetUserBfbInfo.GetUserBfbInfoResIdl;
import tbclient.UserBfbInfo;
/* loaded from: classes23.dex */
public class BfbInfoHttpResponseMessage extends TbHttpResponsedMessage {
    private UserBfbInfo bfbInfo;

    public BfbInfoHttpResponseMessage() {
        super(1003100);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetUserBfbInfoResIdl getUserBfbInfoResIdl = (GetUserBfbInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetUserBfbInfoResIdl.class);
        if (getUserBfbInfoResIdl != null) {
            if (getUserBfbInfoResIdl.error != null) {
                setError(getUserBfbInfoResIdl.error.errorno.intValue());
                setErrorString(getUserBfbInfoResIdl.error.usermsg);
            }
            if (getUserBfbInfoResIdl.data != null) {
                this.bfbInfo = getUserBfbInfoResIdl.data.bfb;
            }
        }
    }

    public UserBfbInfo getBfbInfo() {
        return this.bfbInfo;
    }
}
