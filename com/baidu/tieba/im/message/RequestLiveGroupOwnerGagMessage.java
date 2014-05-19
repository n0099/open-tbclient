package com.baidu.tieba.im.message;

import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.LivegroupOwnerGag.DataReq;
import protobuf.LivegroupOwnerGag.LivegroupOwnerGagReqIdl;
/* loaded from: classes.dex */
public class RequestLiveGroupOwnerGagMessage extends TbSocketMessage {
    private int groupId;
    private int type;
    private String userIds;
    private String userNames;

    public RequestLiveGroupOwnerGagMessage() {
        super(MessageTypes.CMD_LIVE_GROUP_OWNER_GAG);
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

    public String getUserIds() {
        return this.userIds;
    }

    public void setUserIds(String str) {
        this.userIds = str;
    }

    public String getUserNames() {
        return this.userNames;
    }

    public void setUserNames(String str) {
        this.userNames = str;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.groupId = Integer.valueOf(getGroupId());
        builder.type = Integer.valueOf(getType());
        builder.userIds = getUserIds();
        LivegroupOwnerGagReqIdl.Builder builder2 = new LivegroupOwnerGagReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
