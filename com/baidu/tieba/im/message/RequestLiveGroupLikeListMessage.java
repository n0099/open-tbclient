package com.baidu.tieba.im.message;

import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.QueryLiveGroupLikeList.DataReq;
import protobuf.QueryLiveGroupLikeList.QueryLiveGroupLikeListReqIdl;
/* loaded from: classes.dex */
public class RequestLiveGroupLikeListMessage extends TbSocketMessage {
    public int mGroupId;
    public int mOffset;
    public int mRn;

    public RequestLiveGroupLikeListMessage() {
        super(MessageTypes.CMD_LIVE_LIKE_LIST);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.groupId = Integer.valueOf(this.mGroupId);
        builder.offset = Integer.valueOf(this.mOffset);
        builder.rn = Integer.valueOf(this.mRn);
        QueryLiveGroupLikeListReqIdl.Builder builder2 = new QueryLiveGroupLikeListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
