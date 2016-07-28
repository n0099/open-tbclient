package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.UpdateGroupInfoData;
import com.squareup.wire.Wire;
import protobuf.GroupInfo;
import protobuf.UpdateGroup.UpdateGroupResIdl;
/* loaded from: classes.dex */
public class ResponseUpdateGroupMessage extends SocketResponsedMessage {
    private UpdateGroupInfoData groupInfo;

    public ResponseUpdateGroupMessage() {
        super(103102);
    }

    public ResponseUpdateGroupMessage(int i) {
        super(i);
    }

    public UpdateGroupInfoData getUpdateGroupInfo() {
        return this.groupInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
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
                updateGroupInfoData.setAuthorId(groupInfo.authorId.longValue());
                updateGroupInfoData.setAuthorName(groupInfo.authorName);
                updateGroupInfoData.setCreateTime(groupInfo.createTime.intValue());
                updateGroupInfoData.setMaxMemberNum(groupInfo.maxMemberNum.intValue());
                updateGroupInfoData.setMemberNum(groupInfo.memberNum.intValue());
                updateGroupInfoData.setGroupType(groupInfo.groupType.intValue());
                updateGroupInfoData.setFlag(groupInfo.flag.intValue());
                this.groupInfo = updateGroupInfoData;
            }
        }
    }
}
