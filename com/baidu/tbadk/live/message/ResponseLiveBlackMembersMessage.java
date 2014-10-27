package com.baidu.tbadk.live.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.live.data.LiveBlackMembersListData;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import protobuf.QueryOwnerGagList.QueryOwnerGagListResIdl;
import protobuf.UserInfo;
/* loaded from: classes.dex */
public class ResponseLiveBlackMembersMessage extends SocketResponsedMessage {
    private LiveBlackMembersListData liveBlackMembersListData;

    public ResponseLiveBlackMembersMessage() {
        super(107009);
    }

    public LiveBlackMembersListData getLiveBlackMembersListData() {
        return this.liveBlackMembersListData;
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
                this.liveBlackMembersListData = new LiveBlackMembersListData();
                this.liveBlackMembersListData.setHasMore(queryOwnerGagListResIdl.data.hasMore.intValue());
                this.liveBlackMembersListData.setTotalMembers(queryOwnerGagListResIdl.data.gagers.intValue());
                this.liveBlackMembersListData.setUserDatas(new ArrayList());
                while (true) {
                    int i3 = i2;
                    if (i3 < queryOwnerGagListResIdl.data.userList.size()) {
                        UserInfo userInfo = queryOwnerGagListResIdl.data.userList.get(i3);
                        UserData userData = new UserData();
                        userData.setUserId(String.valueOf(userInfo.userId));
                        userData.setUserName(userInfo.userName);
                        userData.setPortrait(userInfo.portrait);
                        userData.setSex(userInfo.sex.intValue());
                        this.liveBlackMembersListData.getUserDatas().add(userData);
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
