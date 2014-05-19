package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tieba.im.data.GroupActivityData;
import com.squareup.wire.Wire;
import protobuf.DelGroupActivity.DataRes;
import protobuf.DelGroupActivity.DelGroupActivityResIdl;
/* loaded from: classes.dex */
public class ResponseDelGroupActivityMessage extends SocketResponsedMessage {
    private GroupActivityData activityData;

    public ResponseDelGroupActivityMessage() {
        super(MessageTypes.CMD_DEL_GROUP_ACTIVITY);
    }

    public GroupActivityData getActivityData() {
        return this.activityData;
    }

    public void setActivityData(GroupActivityData groupActivityData) {
        this.activityData = groupActivityData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        DelGroupActivityResIdl delGroupActivityResIdl = (DelGroupActivityResIdl) new Wire(new Class[0]).parseFrom(bArr, DelGroupActivityResIdl.class);
        setError(delGroupActivityResIdl.error.errorno.intValue());
        setErrorString(delGroupActivityResIdl.error.usermsg);
        if (getError() == 0) {
            DataRes dataRes = delGroupActivityResIdl.data;
            GroupActivityData groupActivityData = new GroupActivityData();
            groupActivityData.setGroupId(dataRes.groupId.intValue());
            groupActivityData.setGroupName(dataRes.groupName);
            groupActivityData.setActivityId(dataRes.activityId.intValue());
            groupActivityData.setIsEnd(dataRes.isEnd.intValue());
            setActivityData(groupActivityData);
        }
    }
}
