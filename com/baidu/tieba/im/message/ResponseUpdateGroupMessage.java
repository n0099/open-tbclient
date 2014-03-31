package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.UpdateGroupInfoData;
import protobuf.Im;
import protobuf.UpdateGroup.UpdateGroupRes;
/* loaded from: classes.dex */
public class ResponseUpdateGroupMessage extends SocketResponsedMessage {
    private UpdateGroupInfoData a;

    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        UpdateGroupRes.UpdateGroupResIdl parseFrom = UpdateGroupRes.UpdateGroupResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        e(parseFrom.getError().getUsermsg());
        if (e() == 0) {
            UpdateGroupInfoData updateGroupInfoData = new UpdateGroupInfoData();
            Im.GroupInfo group = parseFrom.getData().getGroup();
            if (group != null) {
                updateGroupInfoData.setGroupId(group.getGroupId());
                updateGroupInfoData.setForumId(group.getForumId());
                updateGroupInfoData.setName(group.getName());
                updateGroupInfoData.setIntro(group.getIntro());
                updateGroupInfoData.setPortrait(group.getPortrait());
                updateGroupInfoData.setPosition(group.getPosition());
                updateGroupInfoData.setLng(String.valueOf(group.getLng()));
                updateGroupInfoData.setLat(String.valueOf(group.getLat()));
                updateGroupInfoData.setNotice(group.getNotice());
                updateGroupInfoData.setAlbum(group.getAlbum());
                updateGroupInfoData.setStatus(group.getStatus());
                updateGroupInfoData.setAuthorId(group.getAuthorId());
                updateGroupInfoData.setAuthorName(group.getAuthorName());
                updateGroupInfoData.setCreateTime(group.getCreateTime());
                updateGroupInfoData.setMaxMemberNum(group.getMaxMemberNum());
                updateGroupInfoData.setMemberNum(group.getMemberNum());
                updateGroupInfoData.setGroupType(group.getGroupType());
                updateGroupInfoData.setFlag(group.getFlag());
                this.a = updateGroupInfoData;
            }
        }
    }

    public ResponseUpdateGroupMessage() {
        super(103102);
    }

    public ResponseUpdateGroupMessage(int i) {
        super(i);
    }

    public final UpdateGroupInfoData d() {
        return this.a;
    }
}
