package com.baidu.tbadk.coreExtra.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import protobuf.GroupInfo;
import protobuf.UpdateClientInfo.UpdateClientInfoResIdl;
import protobuf.UserInfo;
/* loaded from: classes.dex */
public class ResponseOnlineMessage extends SocketResponsedMessage {
    private List<GroupUpdateMessage> groupInfos;

    public ResponseOnlineMessage() {
        super(MessageTypes.CMD_UPDATE_CLIENT_INFO);
    }

    public List<GroupUpdateMessage> getGroupInfos() {
        return this.groupInfos;
    }

    public void setGroupInfos(List<GroupUpdateMessage> list) {
        this.groupInfos = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        UpdateClientInfoResIdl updateClientInfoResIdl = (UpdateClientInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, UpdateClientInfoResIdl.class);
        setError(updateClientInfoResIdl.error.errorno.intValue());
        setErrorString(updateClientInfoResIdl.error.usermsg);
        if (getError() == 0) {
            setGroupInfos(new ArrayList());
            int size = updateClientInfoResIdl.data.groupInfo == null ? 0 : updateClientInfoResIdl.data.groupInfo.size();
            for (int i2 = 0; i2 < size; i2++) {
                GroupInfo groupInfo = updateClientInfoResIdl.data.groupInfo.get(i2);
                GroupUpdateMessage groupUpdateMessage = new GroupUpdateMessage();
                groupUpdateMessage.setGroupId(groupInfo.groupId.intValue());
                groupUpdateMessage.setGroupType(groupInfo.groupType.intValue());
                groupUpdateMessage.setLastMsgId(groupInfo.lastMsgId.longValue());
                groupUpdateMessage.setName(groupInfo.name);
                groupUpdateMessage.setPortrait(groupInfo.portrait);
                groupUpdateMessage.setGrade(groupInfo.grade.intValue());
                groupUpdateMessage.setAuthorId(String.valueOf(groupInfo.authorId));
                groupUpdateMessage.setAuthorName(groupInfo.authorName);
                groupUpdateMessage.setForumId(String.valueOf(groupInfo.forumId));
                getGroupInfos().add(groupUpdateMessage);
            }
            UserInfo userInfo = updateClientInfoResIdl.data.userInfo;
            if (userInfo != null) {
                SettingsSyncMessage settingsSyncMessage = new SettingsSyncMessage();
                if (userInfo != null) {
                    settingsSyncMessage.setData(userInfo.portrait);
                }
            }
        }
    }
}
