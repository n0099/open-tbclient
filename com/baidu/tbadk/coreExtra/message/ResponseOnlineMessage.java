package com.baidu.tbadk.coreExtra.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import protobuf.Im;
import protobuf.UpdateClientInfo.UpdateClientInfoRes;
/* loaded from: classes.dex */
public class ResponseOnlineMessage extends SocketResponsedMessage {
    private List<GroupUpdateMessage> a;

    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        UpdateClientInfoRes.UpdateClientInfoResIdl parseFrom = UpdateClientInfoRes.UpdateClientInfoResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        e(parseFrom.getError().getUsermsg());
        if (e() == 0) {
            this.a = new ArrayList();
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
                this.a.add(groupUpdateMessage);
            }
            Im.UserInfo userInfo = parseFrom.getData().getUserInfo();
            if (userInfo != null) {
                c cVar = new c();
                if (userInfo != null) {
                    cVar.a((c) userInfo.getPortrait());
                }
            }
        }
    }

    public ResponseOnlineMessage() {
        super(1001);
    }

    public final List<GroupUpdateMessage> d() {
        return this.a;
    }
}
