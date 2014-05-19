package com.baidu.tieba.im.message;

import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.ForumOwnerManageLivegroup.DataReq;
import protobuf.ForumOwnerManageLivegroup.ForumOwnerManageLivegroupReqIdl;
/* loaded from: classes.dex */
public class RequestOperateFrsLiveListMessage extends TbSocketMessage {
    private int forumId;
    private int groupId;
    private int oldType;
    private int type;

    public RequestOperateFrsLiveListMessage() {
        super(MessageTypes.CMD_LIVE_OPERATE_FRSLIVE_LIST);
    }

    public int getForumId() {
        return this.forumId;
    }

    public void setForumId(int i) {
        this.forumId = i;
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

    public int getOldType() {
        return this.oldType;
    }

    public void setOldType(int i) {
        this.oldType = i;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forumId = Integer.valueOf(getForumId());
        builder.type = Integer.valueOf(getType());
        builder.groupId = Integer.valueOf(getGroupId());
        ForumOwnerManageLivegroupReqIdl.Builder builder2 = new ForumOwnerManageLivegroupReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
