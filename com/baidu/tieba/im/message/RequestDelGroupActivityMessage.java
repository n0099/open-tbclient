package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.DelGroupActivity.DataReq;
import protobuf.DelGroupActivity.DelGroupActivityReqIdl;
/* loaded from: classes5.dex */
public class RequestDelGroupActivityMessage extends TbSocketMessage {
    private int activityId;
    private long groupId;

    public RequestDelGroupActivityMessage() {
        super(103121);
    }

    public int getActivityId() {
        return this.activityId;
    }

    public void setActivityId(int i) {
        this.activityId = i;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.activityId = Integer.valueOf(getActivityId());
        builder.groupId = Long.valueOf(getGroupId());
        DelGroupActivityReqIdl.Builder builder2 = new DelGroupActivityReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
