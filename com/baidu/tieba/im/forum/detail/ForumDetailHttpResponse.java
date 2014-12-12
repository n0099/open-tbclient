package com.baidu.tieba.im.forum.detail;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.GetForumDetail.GetForumDetailResIdl;
import tbclient.RecommendForumInfo;
import tbclient.SimpleThreadInfo;
/* loaded from: classes.dex */
public class ForumDetailHttpResponse extends TbHttpResponsedMessage {
    private RecommendForumInfo forumInfo;
    private List<SimpleThreadInfo> threadInfoList;

    public ForumDetailHttpResponse(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        GetForumDetailResIdl getForumDetailResIdl = (GetForumDetailResIdl) new Wire(new Class[0]).parseFrom(bArr, GetForumDetailResIdl.class);
        if (getForumDetailResIdl != null) {
            if (getForumDetailResIdl.error != null) {
                setError(getForumDetailResIdl.error.errorno.intValue());
                setErrorString(getForumDetailResIdl.error.usermsg);
            }
            if (getForumDetailResIdl.data != null) {
                this.forumInfo = getForumDetailResIdl.data.forum_info;
                this.threadInfoList = getForumDetailResIdl.data.thread_list;
            }
        }
    }

    public RecommendForumInfo getForumInfo() {
        return this.forumInfo;
    }

    public List<SimpleThreadInfo> getThreadInfoList() {
        return this.threadInfoList;
    }
}
