package com.baidu.tieba.im.forum.broadcast.data;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetForumBroadcastList.GetForumBroadcastListResIdl;
/* loaded from: classes25.dex */
public class ResponseSocketMajorHistoryMessage extends SocketResponsedMessage {
    a majorHistoryData;

    public ResponseSocketMajorHistoryMessage() {
        super(309669);
        this.majorHistoryData = new a();
    }

    public a getData() {
        return this.majorHistoryData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        if (bArr != null) {
            GetForumBroadcastListResIdl getForumBroadcastListResIdl = (GetForumBroadcastListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetForumBroadcastListResIdl.class);
            if (getForumBroadcastListResIdl.error != null) {
                setError(getForumBroadcastListResIdl.error.errorno.intValue());
                setErrorString(getForumBroadcastListResIdl.error.usermsg);
                if (getError() == 0) {
                    this.majorHistoryData.a(getForumBroadcastListResIdl.data);
                    this.majorHistoryData.cIf();
                }
            }
        }
    }
}
