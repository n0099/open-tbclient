package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tieba.im.data.UpdateGroupInfoData;
import com.squareup.wire.Wire;
import protobuf.GroupInfo;
import protobuf.UpdateGroup.UpdateGroupResIdl;
/* loaded from: classes.dex */
public class ResponseUpdateGroupMessage extends SocketResponsedMessage {
    private UpdateGroupInfoData groupInfo;

    public ResponseUpdateGroupMessage() {
        super(MessageTypes.CMD_UPDATE_GROUP);
    }

    public ResponseUpdateGroupMessage(int i) {
        super(i);
    }

    public UpdateGroupInfoData getUpdateGroupInfo() {
        return this.groupInfo;
    }

    public void setUpdateGroupInfo(UpdateGroupInfoData updateGroupInfoData) {
        this.groupInfo = updateGroupInfoData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        UpdateGroupResIdl updateGroupResIdl = (UpdateGroupResIdl) new Wire(new Class[0]).parseFrom(bArr, UpdateGroupResIdl.class);
        setError(updateGroupResIdl.error.errorno.intValue());
        setErrorString(updateGroupResIdl.error.usermsg);
        if (getError() == 0) {
            UpdateGroupInfoData updateGroupInfoData = new UpdateGroupInfoData();
            GroupInfo groupInfo = updateGroupResIdl.data.group;
            if (groupInfo != null) {
                updateGroupInfoData.setGroupId(groupInfo.groupId.intValue());
                updateGroupInfoData.setForumId(groupInfo.forumId.intValue());
                updateGroupInfoData.setName(groupInfo.name);
                updateGroupInfoData.setIntro(groupInfo.intro);
                updateGroupInfoData.setPortrait(groupInfo.portrait);
                updateGroupInfoData.setPosition(groupInfo.position);
                updateGroupInfoData.setLng(String.valueOf(groupInfo.lng));
                updateGroupInfoData.setLat(String.valueOf(groupInfo.lat));
                updateGroupInfoData.setNotice(groupInfo.notice);
                updateGroupInfoData.setAlbum(groupInfo.album);
                updateGroupInfoData.setStatus(groupInfo.status.intValue());
                updateGroupInfoData.setAuthorId(groupInfo.authorId.intValue());
                updateGroupInfoData.setAuthorName(groupInfo.authorName);
                updateGroupInfoData.setCreateTime(groupInfo.createTime.intValue());
                updateGroupInfoData.setMaxMemberNum(groupInfo.maxMemberNum.intValue());
                updateGroupInfoData.setMemberNum(groupInfo.memberNum.intValue());
                updateGroupInfoData.setGroupType(groupInfo.groupType.intValue());
                updateGroupInfoData.setFlag(groupInfo.flag.intValue());
                setUpdateGroupInfo(updateGroupInfoData);
            }
        }
    }
}
