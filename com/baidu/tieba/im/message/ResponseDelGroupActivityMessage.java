package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tieba.im.data.GroupActivityData;
import com.squareup.wire.Wire;
import protobuf.DelGroupActivity.DataRes;
import protobuf.DelGroupActivity.DelGroupActivityResIdl;
/* loaded from: classes10.dex */
public class ResponseDelGroupActivityMessage extends SocketResponsedMessage {
    private GroupActivityData activityData;

    public ResponseDelGroupActivityMessage() {
        super(CmdConfigSocket.CMD_DEL_GROUP_ACTIVITY);
    }

    public GroupActivityData getActivityData() {
        return this.activityData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        DelGroupActivityResIdl delGroupActivityResIdl = (DelGroupActivityResIdl) new Wire(new Class[0]).parseFrom(bArr, DelGroupActivityResIdl.class);
        setError(delGroupActivityResIdl.error.errorno.intValue());
        setErrorString(delGroupActivityResIdl.error.usermsg);
        if (getError() == 0) {
            DataRes dataRes = delGroupActivityResIdl.data;
            GroupActivityData groupActivityData = new GroupActivityData();
            groupActivityData.setGroupId(dataRes.groupId.longValue());
            groupActivityData.setGroupName(dataRes.groupName);
            groupActivityData.setActivityId(dataRes.activityId.intValue());
            groupActivityData.setIsEnd(dataRes.isEnd.intValue());
            this.activityData = groupActivityData;
        }
    }
}
