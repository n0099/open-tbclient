package com.baidu.tbadk.live.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import protobuf.LivegroupOwnerGag.LivegroupOwnerGagResIdl;
/* loaded from: classes.dex */
public class ResponseLiveGroupOwnerGagMessage extends SocketResponsedMessage {
    public ResponseLiveGroupOwnerGagMessage() {
        super(107109);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        LivegroupOwnerGagResIdl livegroupOwnerGagResIdl = (LivegroupOwnerGagResIdl) new Wire(new Class[0]).parseFrom(bArr, LivegroupOwnerGagResIdl.class);
        if (livegroupOwnerGagResIdl.error != null) {
            setError(livegroupOwnerGagResIdl.error.errorno.intValue());
            setErrorString(livegroupOwnerGagResIdl.error.usermsg);
            if (getError() != 0) {
            }
        }
    }
}
