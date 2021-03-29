package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.GetLivableForumList.DataReq;
import protobuf.GetLivableForumList.GetLivableForumListReqIdl;
/* loaded from: classes3.dex */
public class RequestGetLivableForumList extends TbSocketMessage {
    public int filterFlag;
    public int likeForumFlag;
    public int pageNo;
    public int pageSize;
    public long userId;

    public RequestGetLivableForumList() {
        super(107129);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
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

    public void setFilterFlag(int i) {
        this.filterFlag = i;
    }

    public void setGetLikeForum(int i) {
        this.likeForumFlag = i;
    }

    public void setPageNo(int i) {
        this.pageNo = i;
    }

    public void setPageSize(int i) {
        this.pageSize = i;
    }

    public void setUserId(long j) {
        this.userId = j;
    }
}
