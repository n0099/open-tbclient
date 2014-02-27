package com.baidu.tieba.im.message;

import com.baidu.tieba.im.data.AddGroupInfoData;
import java.util.LinkedList;
import protobuf.AddGroup.AddGroupRes;
import protobuf.Im;
/* loaded from: classes.dex */
public class bm extends da implements com.baidu.tieba.im.coder.f {
    private AddGroupInfoData a;

    public bm() {
        e(103101);
    }

    public final AddGroupInfoData a() {
        return this.a;
    }

    @Override // com.baidu.tieba.im.coder.f
    public final void a(LinkedList<s> linkedList, byte[] bArr, int i) {
        AddGroupRes.AddGroupResIdl parseFrom = AddGroupRes.AddGroupResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!l()) {
            AddGroupInfoData addGroupInfoData = new AddGroupInfoData();
            Im.GroupInfo group = parseFrom.getData().getGroup();
            addGroupInfoData.setGroupId(group.getGroupId());
            addGroupInfoData.setForumId(group.getForumId());
            addGroupInfoData.setName(group.getName());
            addGroupInfoData.setIntro(group.getIntro());
            addGroupInfoData.setPortrait(group.getPortrait());
            addGroupInfoData.setPosition(group.getPosition());
            addGroupInfoData.setLng(String.valueOf(group.getLng()));
            addGroupInfoData.setLat(String.valueOf(group.getLat()));
            addGroupInfoData.setNotice(group.getNotice());
            addGroupInfoData.setAlbum(group.getAlbum());
            addGroupInfoData.setStatus(group.getStatus());
            addGroupInfoData.setAuthorId(group.getAuthorId());
            addGroupInfoData.setAuthorName(group.getAuthorName());
            addGroupInfoData.setCreateTime(group.getCreateTime());
            addGroupInfoData.setMaxMemberNum(group.getMaxMemberNum());
            addGroupInfoData.setMemberNum(group.getMemberNum());
            addGroupInfoData.setGroupType(group.getGroupType());
            this.a = addGroupInfoData;
        }
    }
}
