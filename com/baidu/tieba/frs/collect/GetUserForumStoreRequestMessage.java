package com.baidu.tieba.frs.collect;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.GetUserForumStore.DataReq;
import tbclient.GetUserForumStore.GetUserForumStoreReqIdl;
/* loaded from: classes.dex */
public class GetUserForumStoreRequestMessage extends NetMessage {
    public static final int DEF_COUNT = 30;
    public static final int TYPE_LOAD_MORE = 1;
    public static final int TYPE_REFRESH = 0;
    private int count;
    private long forumId;
    private int offset;
    private int type;
    private long userId;

    public GetUserForumStoreRequestMessage() {
        super(CmdConfigHttp.CMD_GET_USER_FORUM_STORE, 309112);
        this.count = 30;
        this.type = -1;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setOffset(int i) {
        this.offset = i;
    }

    public void setForumId(long j) {
        this.forumId = j;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forum_id = Long.valueOf(this.forumId);
        builder.count = Integer.valueOf(this.count);
        builder.user_id = Long.valueOf(this.userId);
        builder.offset = Integer.valueOf(this.offset);
        if (z) {
            com.baidu.tbadk.util.i.a(builder, true);
        }
        GetUserForumStoreReqIdl.Builder builder2 = new GetUserForumStoreReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
