package com.baidu.tbadk.coreExtra.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.lcs.a;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import protobuf.ConfigVersion;
import protobuf.GroupInfo;
import protobuf.MaskInfo;
import protobuf.UpdateClientInfo.UpdateClientInfoResIdl;
import protobuf.UserInfo;
/* loaded from: classes.dex */
public class ResponseOnlineMessage extends SocketResponsedMessage {
    private ConfigVersion configVersion;
    private List<GroupUpdateMessage> groupInfos;
    private boolean isUserAvailable;
    private MaskInfo maskInfo;

    public ResponseOnlineMessage() {
        super(1001);
    }

    public List<GroupUpdateMessage> getGroupInfos() {
        return this.groupInfos;
    }

    public boolean isUserAvailable() {
        return this.isUserAvailable;
    }

    public void setUserAvailable(boolean z) {
        this.isUserAvailable = z;
    }

    public ConfigVersion getConfigVersion() {
        return this.configVersion;
    }

    public MaskInfo getMaskInfo() {
        return this.maskInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        UpdateClientInfoResIdl updateClientInfoResIdl = (UpdateClientInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, UpdateClientInfoResIdl.class);
        setError(updateClientInfoResIdl.error.errorno.intValue());
        setErrorString(updateClientInfoResIdl.error.usermsg);
        if (getError() != 0) {
            a.c(1001, 0, 2, 0, 0);
            return;
        }
        a.c(1001, 0, 1, 0, 0);
        this.groupInfos = new ArrayList();
        if (updateClientInfoResIdl.data != null) {
            int size = updateClientInfoResIdl.data.groupInfo == null ? 0 : updateClientInfoResIdl.data.groupInfo.size();
            for (int i2 = 0; i2 < size; i2++) {
                GroupInfo groupInfo = updateClientInfoResIdl.data.groupInfo.get(i2);
                GroupUpdateMessage groupUpdateMessage = new GroupUpdateMessage();
                groupUpdateMessage.setGroupId(groupInfo.groupId.longValue());
                groupUpdateMessage.setGroupType(groupInfo.groupType.intValue());
                groupUpdateMessage.setLastMsgId(groupInfo.lastMsgId.longValue());
                groupUpdateMessage.setName(groupInfo.name);
                groupUpdateMessage.setNameShow(groupInfo.authorNameShow);
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
            this.maskInfo = updateClientInfoResIdl.data.maskInfo;
            this.configVersion = updateClientInfoResIdl.data.configVersion;
            this.isUserAvailable = updateClientInfoResIdl.data.isUserAvailable.longValue() != 0;
        }
    }
}
