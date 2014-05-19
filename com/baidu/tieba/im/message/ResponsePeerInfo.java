package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.squareup.wire.Wire;
import protobuf.GetPeerInfo.GetPeerInfoResIdl;
/* loaded from: classes.dex */
public class ResponsePeerInfo extends SocketResponsedMessage {
    private int isAllowed;

    public boolean getIsAllowed() {
        return this.isAllowed != 0;
    }

    public ResponsePeerInfo() {
        super(MessageTypes.CMD_GET_PEER_INFO);
        this.isAllowed = 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        GetPeerInfoResIdl getPeerInfoResIdl = (GetPeerInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetPeerInfoResIdl.class);
        setError(getPeerInfoResIdl.error.errorno.intValue());
        setErrorString(getPeerInfoResIdl.error.usermsg);
        if (getError() == 0) {
            this.isAllowed = getPeerInfoResIdl.data.isAllowed.intValue();
        }
    }
}
