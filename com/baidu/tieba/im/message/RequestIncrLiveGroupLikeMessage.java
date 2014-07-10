package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.IncrLiveGroupLike.DataReq;
import protobuf.IncrLiveGroupLike.IncrLiveGroupLikeReqIdl;
/* loaded from: classes.dex */
public class RequestIncrLiveGroupLikeMessage extends TbSocketMessage {
    public int groupId;
    public int type;

    public RequestIncrLiveGroupLikeMessage() {
        super(107108);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.groupId = Integer.valueOf(this.groupId);
        builder.type = Integer.valueOf(this.type);
        IncrLiveGroupLikeReqIdl.Builder builder2 = new IncrLiveGroupLikeReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
