package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.AddGroupInfoData;
import protobuf.AddGroup.AddGroupRes;
import protobuf.Im;
/* loaded from: classes.dex */
public class ResponseAddGroupMessage extends SocketResponsedMessage {
    private AddGroupInfoData a;

    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        AddGroupRes.AddGroupResIdl parseFrom = AddGroupRes.AddGroupResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        e(parseFrom.getError().getUsermsg());
        if (e() == 0) {
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

    public ResponseAddGroupMessage() {
        super(103101);
    }

    public final AddGroupInfoData d() {
        return this.a;
    }
}
