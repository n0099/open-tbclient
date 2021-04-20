package com.baidu.tieba.home;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetUserBfbInfo.DataRes;
import tbclient.GetUserBfbInfo.GetUserBfbInfoResIdl;
import tbclient.UserBfbInfo;
/* loaded from: classes4.dex */
public class BfbInfoHttpResponseMessage extends TbHttpResponsedMessage {
    public UserBfbInfo bfbInfo;

    public BfbInfoHttpResponseMessage() {
        super(CmdConfigHttp.CMD_GET_BFB_INFO);
    }

    public UserBfbInfo getBfbInfo() {
        return this.bfbInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
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
