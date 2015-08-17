package com.baidu.tieba.chosen.unlike;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Unlike.UnlikeResIdl;
/* loaded from: classes.dex */
public class UnlikeSocketReponse extends TbSocketReponsedMessage {
    private long threadId;

    public UnlikeSocketReponse(int i) {
        super(307007);
    }

    public long getThreadId() {
        return this.threadId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        UnlikeResIdl unlikeResIdl = (UnlikeResIdl) new Wire(new Class[0]).parseFrom(bArr, UnlikeResIdl.class);
        setError(unlikeResIdl.error.errorno.intValue());
        setErrorString(unlikeResIdl.error.usermsg);
        if (getError() == 0 && unlikeResIdl.data != null && unlikeResIdl.data.thread_id != null) {
            this.threadId = unlikeResIdl.data.thread_id.longValue();
        }
    }
}
