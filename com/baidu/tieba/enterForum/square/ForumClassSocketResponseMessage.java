package com.baidu.tieba.enterForum.square;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetForumClassList.DataRes;
import tbclient.GetForumClassList.GetForumClassListResIdl;
/* loaded from: classes.dex */
public class ForumClassSocketResponseMessage extends SocketResponsedMessage {
    private DataRes mData;

    public DataRes getData() {
        return this.mData;
    }

    public ForumClassSocketResponseMessage() {
        super(309089);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        GetForumClassListResIdl getForumClassListResIdl = (GetForumClassListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetForumClassListResIdl.class);
        if (getForumClassListResIdl != null) {
            if (getForumClassListResIdl.error != null) {
                setError(getForumClassListResIdl.error.errorno.intValue());
                setErrorString(getForumClassListResIdl.error.errmsg);
            }
            if (!hasError() && getForumClassListResIdl.data != null) {
                this.mData = getForumClassListResIdl.data;
            }
        }
    }
}
