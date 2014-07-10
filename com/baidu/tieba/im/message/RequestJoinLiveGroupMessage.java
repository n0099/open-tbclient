package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.JoinLiveGroup.DataReq;
import protobuf.JoinLiveGroup.JoinLiveGroupReqIdl;
/* loaded from: classes.dex */
public class RequestJoinLiveGroupMessage extends TbSocketMessage {
    public int groupId;

    public RequestJoinLiveGroupMessage() {
        super(107103);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.groupId = Integer.valueOf(this.groupId);
        JoinLiveGroupReqIdl.Builder builder2 = new JoinLiveGroupReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
