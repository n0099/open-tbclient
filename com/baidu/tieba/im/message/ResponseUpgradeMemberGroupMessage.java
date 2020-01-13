package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import protobuf.UpgradeMemberGroup.UpgradeMemberGroupResIdl;
/* loaded from: classes6.dex */
public class ResponseUpgradeMemberGroupMessage extends SocketResponsedMessage {
    public ResponseUpgradeMemberGroupMessage() {
        super(CmdConfigSocket.CMD_UPGRADE_MEMBER_GROUP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        UpgradeMemberGroupResIdl upgradeMemberGroupResIdl = (UpgradeMemberGroupResIdl) new Wire(new Class[0]).parseFrom(bArr, UpgradeMemberGroupResIdl.class);
        setError(upgradeMemberGroupResIdl.error.errorno.intValue());
        setErrorString(upgradeMemberGroupResIdl.error.usermsg);
        if (getError() != 0) {
        }
    }
}
