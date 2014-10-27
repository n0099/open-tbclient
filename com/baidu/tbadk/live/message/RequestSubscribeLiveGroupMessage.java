package com.baidu.tbadk.live.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.SubscribeLiveGroup.DataReq;
import protobuf.SubscribeLiveGroup.SubscribeLiveGroupReqIdl;
/* loaded from: classes.dex */
public class RequestSubscribeLiveGroupMessage extends TbSocketMessage {
    private int mGroupId;
    private int mSubscribe;

    public RequestSubscribeLiveGroupMessage() {
        super(107105);
        this.mGroupId = 0;
        this.mSubscribe = 0;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.groupId = Integer.valueOf(getGroupId());
        builder.flag = Integer.valueOf(getSubscribe());
        SubscribeLiveGroupReqIdl.Builder builder2 = new SubscribeLiveGroupReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setGroupId(int i) {
        this.mGroupId = i;
    }

    public int getGroupId() {
        return this.mGroupId;
    }

    public void setSubscribe(int i) {
        this.mSubscribe = i;
    }

    public int getSubscribe() {
        return this.mSubscribe;
    }
}
