package com.baidu.tieba.im.message;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.GetLivableForumList.DataReq;
import protobuf.GetLivableForumList.GetLivableForumListReqIdl;
/* loaded from: classes2.dex */
public class RequestGetLivableForumList extends TbSocketMessage {
    int filterFlag;
    int likeForumFlag;
    int pageNo;
    int pageSize;
    long userId;

    public RequestGetLivableForumList() {
        super(CmdConfigSocket.CMD_GET_LIVABLE_FORUM_LIST);
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public void setFilterFlag(int i) {
        this.filterFlag = i;
    }

    public void setPageSize(int i) {
        this.pageSize = i;
    }

    public void setPageNo(int i) {
        this.pageNo = i;
    }

    public void setGetLikeForum(int i) {
        this.likeForumFlag = i;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    protected Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.userId = Long.valueOf(this.userId);
        if (this.likeForumFlag == 1) {
            builder.pageNo = Integer.valueOf(this.pageNo);
            builder.pageSize = Integer.valueOf(this.pageSize);
        }
        builder.likeForumFlag = Integer.valueOf(this.likeForumFlag);
        GetLivableForumListReqIdl.Builder builder2 = new GetLivableForumListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
