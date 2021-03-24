package com.baidu.tieba.chosen.unlike;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Unlike.DataRes;
import tbclient.Unlike.UnlikeResIdl;
/* loaded from: classes4.dex */
public class UnlikeSocketReponse extends TbSocketReponsedMessage {
    public long threadId;

    public UnlikeSocketReponse(int i) {
        super(307007);
    }

    public long getThreadId() {
        return this.threadId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        DataRes dataRes;
        Long l;
        UnlikeResIdl unlikeResIdl = (UnlikeResIdl) new Wire(new Class[0]).parseFrom(bArr, UnlikeResIdl.class);
        setError(unlikeResIdl.error.errorno.intValue());
        setErrorString(unlikeResIdl.error.usermsg);
        if (getError() != 0 || (dataRes = unlikeResIdl.data) == null || (l = dataRes.thread_id) == null) {
            return;
        }
        this.threadId = l.longValue();
    }
}
