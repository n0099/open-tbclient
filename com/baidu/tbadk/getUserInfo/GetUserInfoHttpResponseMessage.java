package com.baidu.tbadk.getUserInfo;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import d.a.i0.z.a;
import d.a.i0.z.b;
import tbclient.Error;
import tbclient.GetUserInfo.GetUserInfoResIdl;
/* loaded from: classes3.dex */
public class GetUserInfoHttpResponseMessage extends TbHttpResponsedMessage {
    public a mData;

    public GetUserInfoHttpResponseMessage(int i2) {
        super(i2);
    }

    public a getData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i2, byte[] bArr) {
        super.afterDispatchInBackGround(i2, (int) bArr);
        a aVar = this.mData;
        if (aVar != null && aVar.a() != null) {
            b.a().e(this.mData.a());
        } else {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001247));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetUserInfoResIdl getUserInfoResIdl;
        Error error;
        super.decodeInBackGround(i2, bArr);
        if (bArr == null || (error = (getUserInfoResIdl = (GetUserInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetUserInfoResIdl.class)).error) == null) {
            return;
        }
        setError(error.errorno.intValue());
        setErrorString(getUserInfoResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
        a aVar = new a();
        this.mData = aVar;
        aVar.b(getUserInfoResIdl.data);
    }
}
