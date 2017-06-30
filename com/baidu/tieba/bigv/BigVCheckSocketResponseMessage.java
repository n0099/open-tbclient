package com.baidu.tieba.bigv;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetVUserInfo.GetVUserInfoResIdl;
/* loaded from: classes.dex */
public class BigVCheckSocketResponseMessage extends TbSocketReponsedMessage {
    private boolean isBigV;

    public boolean isBigV() {
        return this.isBigV;
    }

    public BigVCheckSocketResponseMessage() {
        super(309463);
        this.isBigV = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetVUserInfoResIdl getVUserInfoResIdl = (GetVUserInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetVUserInfoResIdl.class);
        if (getVUserInfoResIdl != null) {
            if (getVUserInfoResIdl.error != null) {
                setError(getVUserInfoResIdl.error.errorno.intValue());
                setErrorString(getVUserInfoResIdl.error.errmsg);
            }
            if (getVUserInfoResIdl.data != null) {
                this.isBigV = getVUserInfoResIdl.data.is_god.intValue() == 1;
            }
        }
    }
}
