package com.baidu.tbadk.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import protobuf.AddLiveGroup.AddLiveGroupResIdl;
import protobuf.LiveGroupInfo;
/* loaded from: classes.dex */
public class ResponseAddLiveGroupMessage extends SocketResponsedMessage {
    private LiveGroupInfo groupInfo;

    public ResponseAddLiveGroupMessage() {
        super(107101);
    }

    public LiveGroupInfo getLiveGroupInfo() {
        return this.groupInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        AddLiveGroupResIdl addLiveGroupResIdl = (AddLiveGroupResIdl) new Wire(new Class[0]).parseFrom(bArr, AddLiveGroupResIdl.class);
        setError(addLiveGroupResIdl.error.errorno.intValue());
        setErrorString(addLiveGroupResIdl.error.usermsg);
        if (getError() == 0) {
            this.groupInfo = addLiveGroupResIdl.data.group;
        }
    }
}
