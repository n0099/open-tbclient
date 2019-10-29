package com.baidu.tieba.im.message;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.QueryGroupUserList.DataReq;
import protobuf.QueryGroupUserList.QueryGroupUserListReqIdl;
/* loaded from: classes5.dex */
public class RequestMembersMessage extends TbSocketMessage {
    private long groupId;
    private int offset;
    private int orderType;
    private int rn;

    public RequestMembersMessage() {
        super(CmdConfigSocket.CMD_REQUEST_MEMBERS_BY_ID);
    }

    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int i) {
        this.offset = i;
    }

    public int getRn() {
        return this.rn;
    }

    public void setRn(int i) {
        this.rn = i;
    }

    public int getOrderType() {
        return this.orderType;
    }

    public void setOrderType(int i) {
        this.orderType = i;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.groupId = Long.valueOf(getGroupId());
        builder.offset = Integer.valueOf(getOffset());
        builder.orderType = Integer.valueOf(getOrderType());
        builder.rn = Integer.valueOf(getRn());
        QueryGroupUserListReqIdl.Builder builder2 = new QueryGroupUserListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
