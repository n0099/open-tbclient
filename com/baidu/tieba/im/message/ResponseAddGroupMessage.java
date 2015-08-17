package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.AddGroupInfoData;
import com.squareup.wire.Wire;
import protobuf.AddGroup.AddGroupResIdl;
import protobuf.GroupInfo;
/* loaded from: classes.dex */
public class ResponseAddGroupMessage extends SocketResponsedMessage {
    private AddGroupInfoData groupInfo;

    public ResponseAddGroupMessage() {
        super(103101);
    }

    public AddGroupInfoData getAddGroupInfo() {
        return this.groupInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        AddGroupResIdl addGroupResIdl = (AddGroupResIdl) new Wire(new Class[0]).parseFrom(bArr, AddGroupResIdl.class);
        setError(addGroupResIdl.error.errorno.intValue());
        setErrorString(addGroupResIdl.error.usermsg);
        if (getError() == 0) {
            AddGroupInfoData addGroupInfoData = new AddGroupInfoData();
            GroupInfo groupInfo = addGroupResIdl.data.group;
            addGroupInfoData.setGroupId(groupInfo.groupId.intValue());
            addGroupInfoData.setForumId(groupInfo.forumId.intValue());
            addGroupInfoData.setName(groupInfo.name);
            addGroupInfoData.setIntro(groupInfo.intro);
            addGroupInfoData.setPortrait(groupInfo.portrait);
            addGroupInfoData.setPosition(groupInfo.position);
            addGroupInfoData.setLng(String.valueOf(groupInfo.lng));
            addGroupInfoData.setLat(String.valueOf(groupInfo.lat));
            addGroupInfoData.setNotice(groupInfo.notice);
            addGroupInfoData.setAlbum(groupInfo.album);
            addGroupInfoData.setStatus(groupInfo.status.intValue());
            addGroupInfoData.setAuthorId(groupInfo.authorId.longValue());
            addGroupInfoData.setAuthorName(groupInfo.authorName);
            addGroupInfoData.setCreateTime(groupInfo.createTime.intValue());
            addGroupInfoData.setMaxMemberNum(groupInfo.maxMemberNum.intValue());
            addGroupInfoData.setMemberNum(groupInfo.memberNum.intValue());
            addGroupInfoData.setGroupType(groupInfo.groupType.intValue());
            this.groupInfo = addGroupInfoData;
        }
    }
}
