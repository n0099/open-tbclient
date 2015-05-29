package com.baidu.tbadk.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.AddLiveGroup.AddLiveGroupReqIdl;
import protobuf.AddLiveGroup.DataReq;
/* loaded from: classes.dex */
public class RequestAddLiveGroupMessage extends TbSocketMessage {
    public int forumId;
    public int groupType;
    public int labelId;
    public String name;
    public int publisherId;
    public String publisherName;

    public RequestAddLiveGroupMessage() {
        super(107101);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forumId = Integer.valueOf(this.forumId);
        builder.name = this.name;
        builder.groupType = Integer.valueOf(this.groupType);
        builder.publisherName = this.publisherName;
        builder.publisherId = Integer.valueOf(this.publisherId);
        builder.labelId = Integer.valueOf(this.labelId);
        AddLiveGroupReqIdl.Builder builder2 = new AddLiveGroupReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
