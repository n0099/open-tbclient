package com.baidu.tbadk.live.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.live.data.LiveBlackMembersListData;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import protobuf.QueryOwnerSpeakers.QueryOwnerSpeakersResIdl;
import protobuf.UserInfo;
/* loaded from: classes.dex */
public class ResponseLiveAddBlackMembersMessage extends SocketResponsedMessage {
    private LiveBlackMembersListData liveBlackMembersListData;

    public ResponseLiveAddBlackMembersMessage() {
        super(107134);
    }

    public LiveBlackMembersListData getLiveBlackMembersListData() {
        return this.liveBlackMembersListData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        int i2 = 0;
        QueryOwnerSpeakersResIdl queryOwnerSpeakersResIdl = (QueryOwnerSpeakersResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryOwnerSpeakersResIdl.class);
        if (queryOwnerSpeakersResIdl.error != null) {
            setError(queryOwnerSpeakersResIdl.error.errorno.intValue());
            setErrorString(queryOwnerSpeakersResIdl.error.usermsg);
            if (getError() == 0 && queryOwnerSpeakersResIdl.data != null && queryOwnerSpeakersResIdl.data.userList != null) {
                this.liveBlackMembersListData = new LiveBlackMembersListData();
                this.liveBlackMembersListData.setHasMore(queryOwnerSpeakersResIdl.data.hasMore.intValue());
                this.liveBlackMembersListData.setUserDatas(new ArrayList());
                while (true) {
                    int i3 = i2;
                    if (i3 < queryOwnerSpeakersResIdl.data.userList.size()) {
                        UserInfo userInfo = queryOwnerSpeakersResIdl.data.userList.get(i3);
                        UserData userData = new UserData();
                        if (userInfo != null) {
                            userData.setUserId(String.valueOf(userInfo.userId));
                            userData.setUserName(userInfo.userName);
                            userData.setPortrait(userInfo.portrait);
                            userData.setSex(userInfo.sex.intValue());
                            this.liveBlackMembersListData.getUserDatas().add(userData);
                        }
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
