package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.GroupInfo;
import protobuf.UpdateGroup.UpdateGroupReqIdl;
/* loaded from: classes3.dex */
public abstract class RequestUpdateGroupMessage extends TbSocketMessage {
    private int groupId;
    public int type;

    protected abstract void subEncode(GroupInfo.Builder builder);

    public RequestUpdateGroupMessage() {
        super(103102);
    }

    public int getGroupId() {
        return this.groupId;
    }

    public void setGroupId(int i) {
        this.groupId = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        try {
            GroupInfo.Builder builder = new GroupInfo.Builder();
            builder.groupId = Integer.valueOf(getGroupId());
            subEncode(builder);
            UpdateGroupReqIdl.Builder builder2 = new UpdateGroupReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
