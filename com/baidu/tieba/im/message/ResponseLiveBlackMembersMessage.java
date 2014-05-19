package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import protobuf.QueryOwnerGagList.QueryOwnerGagListResIdl;
import protobuf.UserInfo;
/* loaded from: classes.dex */
public class ResponseLiveBlackMembersMessage extends SocketResponsedMessage {
    private com.baidu.tieba.im.data.g liveBlackMembersListData;

    public ResponseLiveBlackMembersMessage() {
        super(MessageTypes.CMD_LIVE_BLACK_MEMBERS_LIST);
    }

    public com.baidu.tieba.im.data.g getLiveBlackMembersListData() {
        return this.liveBlackMembersListData;
    }

    public void setLiveBlackMembersListData(com.baidu.tieba.im.data.g gVar) {
        this.liveBlackMembersListData = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        int i2 = 0;
        QueryOwnerGagListResIdl queryOwnerGagListResIdl = (QueryOwnerGagListResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryOwnerGagListResIdl.class);
        if (queryOwnerGagListResIdl.error != null) {
            setError(queryOwnerGagListResIdl.error.errorno.intValue());
            setErrorString(queryOwnerGagListResIdl.error.usermsg);
            if (getError() == 0 && queryOwnerGagListResIdl.data != null && queryOwnerGagListResIdl.data.userList != null) {
                this.liveBlackMembersListData = new com.baidu.tieba.im.data.g();
                this.liveBlackMembersListData.a(queryOwnerGagListResIdl.data.hasMore.intValue());
                this.liveBlackMembersListData.b(queryOwnerGagListResIdl.data.gagers.intValue());
                this.liveBlackMembersListData.a(new ArrayList());
                while (true) {
                    int i3 = i2;
                    if (i3 < queryOwnerGagListResIdl.data.userList.size()) {
                        UserInfo userInfo = queryOwnerGagListResIdl.data.userList.get(i3);
                        UserData userData = new UserData();
                        userData.setUserId(String.valueOf(userInfo.userId));
                        userData.setUserName(userInfo.userName);
                        userData.setPortrait(userInfo.portrait);
                        userData.setSex(userInfo.sex.intValue());
                        this.liveBlackMembersListData.b().add(userData);
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
