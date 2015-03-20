package com.baidu.tbadk.getUserInfo;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetUserInfo.GetUserInfoResIdl;
/* loaded from: classes.dex */
public class GetUserInfoSocketResponseMessage extends TbSocketReponsedMessage {
    private a mData;

    public GetUserInfoSocketResponseMessage(int i) {
        super(i);
    }

    public a getData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
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
        if (this.mData != null && this.mData.zl() != null) {
            b.zm().a(this.mData.zl());
        } else {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001253));
        }
    }
}
