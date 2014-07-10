package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.UpgradeMemberGroup.DataReq;
import protobuf.UpgradeMemberGroup.UpgradeMemberGroupReqIdl;
/* loaded from: classes.dex */
public class RequestUpgradeMemberGroupMessage extends TbSocketMessage {
    private int flag;
    private long groupId;

    public RequestUpgradeMemberGroupMessage() {
        super(103105);
        this.flag = 1;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public void setUpOrDown(boolean z) {
        if (z) {
            this.flag = 1;
        } else {
            this.flag = 0;
        }
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.groupId = Integer.valueOf((int) this.groupId);
            builder.flag = Integer.valueOf(this.flag);
            UpgradeMemberGroupReqIdl.Builder builder2 = new UpgradeMemberGroupReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
