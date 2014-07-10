package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import protobuf.UpgradeMemberGroup.UpgradeMemberGroupResIdl;
/* loaded from: classes.dex */
public class ResponseUpgradeMemberGroupMessage extends SocketResponsedMessage {
    public ResponseUpgradeMemberGroupMessage() {
        super(103105);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        UpgradeMemberGroupResIdl upgradeMemberGroupResIdl = (UpgradeMemberGroupResIdl) new Wire(new Class[0]).parseFrom(bArr, UpgradeMemberGroupResIdl.class);
        setError(upgradeMemberGroupResIdl.error.errorno.intValue());
        setErrorString(upgradeMemberGroupResIdl.error.usermsg);
        if (getError() != 0) {
        }
    }
}
