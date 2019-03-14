package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.QueryGroupActivity.DataReq;
import protobuf.QueryGroupActivity.QueryGroupActivityReqIdl;
/* loaded from: classes5.dex */
public class RequestGetGroupActivityMessage extends TbSocketMessage {
    private int activityId;
    private int from;

    public RequestGetGroupActivityMessage() {
        super(103015);
    }

    public int getFrom() {
        return this.from;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public int getActivityId() {
        return this.activityId;
    }

    public void setActivityId(int i) {
        this.activityId = i;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.activityId = Integer.valueOf(getActivityId());
        builder.from = Integer.valueOf(getFrom());
        QueryGroupActivityReqIdl.Builder builder2 = new QueryGroupActivityReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
