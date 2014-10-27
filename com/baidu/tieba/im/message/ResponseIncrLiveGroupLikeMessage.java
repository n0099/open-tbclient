package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import protobuf.IncrLiveGroupLike.IncrLiveGroupLikeResIdl;
import protobuf.LiveGroupInfo;
/* loaded from: classes.dex */
public class ResponseIncrLiveGroupLikeMessage extends SocketResponsedMessage {
    public LiveGroupInfo mLiveGroupInfo;
    public int mSubType;
    public int mType;

    public ResponseIncrLiveGroupLikeMessage() {
        super(107108);
        this.mLiveGroupInfo = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        IncrLiveGroupLikeResIdl incrLiveGroupLikeResIdl = (IncrLiveGroupLikeResIdl) new Wire(new Class[0]).parseFrom(bArr, IncrLiveGroupLikeResIdl.class);
        setError(incrLiveGroupLikeResIdl.error.errorno.intValue());
        setErrorString(incrLiveGroupLikeResIdl.error.usermsg);
        if (getError() == 0) {
            this.mLiveGroupInfo = incrLiveGroupLikeResIdl.data.group;
            this.mType = incrLiveGroupLikeResIdl.data.type.intValue();
            this.mSubType = incrLiveGroupLikeResIdl.data.subType.intValue();
        }
    }
}
