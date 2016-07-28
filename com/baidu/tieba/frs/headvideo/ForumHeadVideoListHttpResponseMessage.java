package com.baidu.tieba.frs.headvideo;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.ForumHeadVideo.DataRes;
import tbclient.ForumHeadVideo.ForumHeadVideoResIdl;
/* loaded from: classes.dex */
public class ForumHeadVideoListHttpResponseMessage extends TbHttpResponsedMessage {
    private DataRes mData;

    public DataRes getData() {
        return this.mData;
    }

    public ForumHeadVideoListHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
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
