package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import java.util.LinkedList;
import java.util.List;
import protobuf.JoinLiveGroup.JoinLiveGroupResIdl;
import protobuf.JoinLiveGroup.LikeUserInfo;
import protobuf.JoinLiveGroup.UserPermission;
import protobuf.LiveGroupInfo;
/* loaded from: classes.dex */
public class ResponseJoinLiveGroupMessage extends SocketResponsedMessage {
    private LiveGroupInfo groupInfo;
    private List<LikeUserInfo> likeUserList;
    private UserPermission user;

    public ResponseJoinLiveGroupMessage() {
        super(107103);
    }

    public LiveGroupInfo getLiveGroupInfo() {
        return this.groupInfo;
    }

    public UserPermission getUser() {
        return this.user;
    }

    public List<LikeUserInfo> getLikeUserList() {
        return this.likeUserList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        JoinLiveGroupResIdl joinLiveGroupResIdl = (JoinLiveGroupResIdl) new Wire(new Class[0]).parseFrom(bArr, JoinLiveGroupResIdl.class);
        setError(joinLiveGroupResIdl.error.errorno.intValue());
        setErrorString(joinLiveGroupResIdl.error.usermsg);
        if (getError() == 0) {
            this.user = joinLiveGroupResIdl.data.user;
            this.likeUserList = joinLiveGroupResIdl.data.likeUserList;
            if (this.likeUserList == null) {
                this.likeUserList = new LinkedList();
            }
            this.groupInfo = joinLiveGroupResIdl.data.group;
        }
    }
}
