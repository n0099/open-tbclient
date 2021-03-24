package com.baidu.tieba.im.forum.broadcast.data;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import d.b.i0.d1.i.a.b.a;
import tbclient.Error;
import tbclient.GetForumBroadcastList.GetForumBroadcastListResIdl;
/* loaded from: classes4.dex */
public class ResponseSocketMajorHistoryMessage extends SocketResponsedMessage {
    public a majorHistoryData;

    public ResponseSocketMajorHistoryMessage() {
        super(309669);
        this.majorHistoryData = new a();
    }

    public a getData() {
        return this.majorHistoryData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetForumBroadcastListResIdl getForumBroadcastListResIdl;
        Error error;
        if (bArr == null || (error = (getForumBroadcastListResIdl = (GetForumBroadcastListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetForumBroadcastListResIdl.class)).error) == null) {
            return;
        }
        setError(error.errorno.intValue());
        setErrorString(getForumBroadcastListResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
        this.majorHistoryData.d(getForumBroadcastListResIdl.data);
        this.majorHistoryData.f();
    }
}
