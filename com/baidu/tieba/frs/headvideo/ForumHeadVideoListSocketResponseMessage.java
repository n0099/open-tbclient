package com.baidu.tieba.frs.headvideo;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.ForumHeadVideo.DataRes;
import tbclient.ForumHeadVideo.ForumHeadVideoResIdl;
/* loaded from: classes.dex */
public class ForumHeadVideoListSocketResponseMessage extends SocketResponsedMessage {
    private DataRes mData;

    public DataRes getData() {
        return this.mData;
    }

    public ForumHeadVideoListSocketResponseMessage() {
        super(309387);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        ForumHeadVideoResIdl forumHeadVideoResIdl = (ForumHeadVideoResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumHeadVideoResIdl.class);
        if (forumHeadVideoResIdl != null) {
            setError(forumHeadVideoResIdl.error.errorno.intValue());
            setErrorString(forumHeadVideoResIdl.error.usermsg);
        }
        if (getError() == 0) {
            this.mData = forumHeadVideoResIdl.data;
        }
    }
}
