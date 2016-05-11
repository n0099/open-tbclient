package com.baidu.tbadk.data;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.CloseAd.CloseAdResIdl;
/* loaded from: classes.dex */
public class MemberCloseAdHttpResponseMessage extends TbHttpResponsedMessage {
    private c mData;

    public MemberCloseAdHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        super.decodeInBackGround(i, bArr);
        if (bArr != null) {
            CloseAdResIdl closeAdResIdl = (CloseAdResIdl) new Wire(new Class[0]).parseFrom(bArr, CloseAdResIdl.class);
            if (closeAdResIdl.error != null) {
                setError(closeAdResIdl.error.errorno.intValue());
                setErrorString(closeAdResIdl.error.usermsg);
                if (getError() == 0 && closeAdResIdl.data != null) {
                    this.mData = new c();
                    this.mData.a(closeAdResIdl.data.vip_close_ad);
                }
            }
        }
    }

    public c getData() {
        return this.mData;
    }
}
