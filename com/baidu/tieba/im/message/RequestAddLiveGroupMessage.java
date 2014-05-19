package com.baidu.tieba.im.message;

import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.AddLiveGroup.AddLiveGroupReqIdl;
import protobuf.AddLiveGroup.DataReq;
/* loaded from: classes.dex */
public class RequestAddLiveGroupMessage extends TbSocketMessage {
    public int forumId;
    public int groupType;
    public String name;
    public int publisherId;
    public String publisherName;

    public RequestAddLiveGroupMessage() {
        super(MessageTypes.CMD_ADD_LIVE_GROUP);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forumId = Integer.valueOf(this.forumId);
        builder.name = this.name;
        builder.groupType = Integer.valueOf(this.groupType);
        builder.publisherName = this.publisherName;
        builder.publisherId = Integer.valueOf(this.publisherId);
        AddLiveGroupReqIdl.Builder builder2 = new AddLiveGroupReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
