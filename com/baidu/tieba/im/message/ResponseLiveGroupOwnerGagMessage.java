package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.squareup.wire.Wire;
import protobuf.LivegroupOwnerGag.LivegroupOwnerGagResIdl;
/* loaded from: classes.dex */
public class ResponseLiveGroupOwnerGagMessage extends SocketResponsedMessage {
    public ResponseLiveGroupOwnerGagMessage() {
        super(MessageTypes.CMD_LIVE_GROUP_OWNER_GAG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
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
