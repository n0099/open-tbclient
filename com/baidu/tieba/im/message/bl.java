package com.baidu.tieba.im.message;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import protobuf.Im;
import protobuf.UpdateClientInfo.UpdateClientInfoRes;
/* loaded from: classes.dex */
public class bl extends bz implements com.baidu.tieba.im.coder.f {
    private List<GroupUpdateMessage> a;

    public bl() {
        super(1001);
    }

    public List<GroupUpdateMessage> a() {
        return this.a;
    }

    public void a(List<GroupUpdateMessage> list) {
        this.a = list;
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<n> linkedList, byte[] bArr, int i) {
        UpdateClientInfoRes.UpdateClientInfoResIdl parseFrom = UpdateClientInfoRes.UpdateClientInfoResIdl.parseFrom(bArr);
        c(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!i()) {
            a(new ArrayList());
            int groupInfoCount = parseFrom.getData().getGroupInfoCount();
            for (int i2 = 0; i2 < groupInfoCount; i2++) {
                Im.GroupInfo groupInfo = parseFrom.getData().getGroupInfo(i2);
                GroupUpdateMessage groupUpdateMessage = new GroupUpdateMessage();
                groupUpdateMessage.setGroupId(groupInfo.getGroupId());
                groupUpdateMessage.setGroupType(groupInfo.getGroupType());
                groupUpdateMessage.setLastMsgId(groupInfo.getLastMsgId());
                groupUpdateMessage.setName(groupInfo.getName());
                groupUpdateMessage.setPortrait(groupInfo.getPortrait());
                groupUpdateMessage.setGrade(groupInfo.getGrade());
                groupUpdateMessage.setAuthorId(String.valueOf(groupInfo.getAuthorId()));
                groupUpdateMessage.setAuthorName(groupInfo.getAuthorName());
                groupUpdateMessage.setForumId(String.valueOf(groupInfo.getForumId()));
                a().add(groupUpdateMessage);
            }
            Im.UserInfo userInfo = parseFrom.getData().getUserInfo();
            if (userInfo != null) {
                cb cbVar = new cb();
                if (userInfo != null) {
                    cbVar.a(userInfo.getPortrait());
                }
                linkedList.add(cbVar);
            }
        }
    }
}
