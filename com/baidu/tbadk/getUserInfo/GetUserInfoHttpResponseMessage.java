package com.baidu.tbadk.getUserInfo;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetUserInfo.GetUserInfoResIdl;
/* loaded from: classes.dex */
public class GetUserInfoHttpResponseMessage extends TbHttpResponsedMessage {
    private a mData;

    public GetUserInfoHttpResponseMessage(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        super.decodeInBackGround(i, bArr);
        if (bArr != null) {
            GetUserInfoResIdl getUserInfoResIdl = (GetUserInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetUserInfoResIdl.class);
            if (getUserInfoResIdl.error != null) {
                setError(getUserInfoResIdl.error.errorno.intValue());
                setErrorString(getUserInfoResIdl.error.usermsg);
                if (getError() == 0) {
                    this.mData = new a();
                    this.mData.a(getUserInfoResIdl.data);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        super.afterDispatchInBackGround(i, (int) bArr);
        if (this.mData != null && this.mData.Nk() != null) {
            b.Nl().a(this.mData.Nk());
        } else {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001247));
        }
    }

    public a getData() {
        return this.mData;
    }
}
