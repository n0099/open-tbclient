package com.baidu.tieba.im.message;

import com.baidu.tieba.im.data.UpdateGroupInfoData;
import java.util.LinkedList;
import protobuf.Im;
import protobuf.UpdateGroup.UpdateGroupRes;
/* loaded from: classes.dex */
public class cn extends cr implements com.baidu.tieba.im.coder.f {
    private UpdateGroupInfoData a;

    public cn() {
        super(103102);
    }

    public UpdateGroupInfoData a() {
        return this.a;
    }

    public void a(UpdateGroupInfoData updateGroupInfoData) {
        this.a = updateGroupInfoData;
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<q> linkedList, byte[] bArr, int i) {
        UpdateGroupRes.UpdateGroupResIdl parseFrom = UpdateGroupRes.UpdateGroupResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!k()) {
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
                a(updateGroupInfoData);
            }
        }
    }
}
