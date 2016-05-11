package com.baidu.tbadk.data;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import tbclient.CloseAd.CloseAdResIdl;
/* loaded from: classes.dex */
public class MemberCloseAdSocketResponseMessage extends TbSocketReponsedMessage {
    private c mData;

    public MemberCloseAdSocketResponseMessage(int i) {
        super(i);
    }

    public c getData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
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
}
