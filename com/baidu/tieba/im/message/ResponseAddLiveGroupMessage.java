package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.squareup.wire.Wire;
import protobuf.AddLiveGroup.AddLiveGroupResIdl;
import protobuf.LiveGroupInfo;
/* loaded from: classes.dex */
public class ResponseAddLiveGroupMessage extends SocketResponsedMessage {
    private LiveGroupInfo groupInfo;

    public ResponseAddLiveGroupMessage() {
        super(MessageTypes.CMD_ADD_LIVE_GROUP);
    }

    public LiveGroupInfo getLiveGroupInfo() {
        return this.groupInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        AddLiveGroupResIdl addLiveGroupResIdl = (AddLiveGroupResIdl) new Wire(new Class[0]).parseFrom(bArr, AddLiveGroupResIdl.class);
        setError(addLiveGroupResIdl.error.errorno.intValue());
        setErrorString(addLiveGroupResIdl.error.usermsg);
        if (getError() == 0) {
            this.groupInfo = addLiveGroupResIdl.data.group;
        }
    }
}
