package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.GroupActivityData;
import com.squareup.wire.Wire;
import protobuf.AddGroupActivity.AddGroupActivityResIdl;
import protobuf.AddGroupActivity.DataRes;
/* loaded from: classes5.dex */
public class ResponseCreateGroupActivityMessage extends SocketResponsedMessage {
    private GroupActivityData activityData;

    public ResponseCreateGroupActivityMessage() {
        super(103120);
    }

    public GroupActivityData getActivityData() {
        return this.activityData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        AddGroupActivityResIdl addGroupActivityResIdl = (AddGroupActivityResIdl) new Wire(new Class[0]).parseFrom(bArr, AddGroupActivityResIdl.class);
        setError(addGroupActivityResIdl.error.errorno.intValue());
        setErrorString(addGroupActivityResIdl.error.usermsg);
        if (getError() == 0) {
            DataRes dataRes = addGroupActivityResIdl.data;
            GroupActivityData groupActivityData = new GroupActivityData();
            groupActivityData.setgActivityArea(dataRes.gActivityArea);
            groupActivityData.setgActivityTime(dataRes.gActivityTime.longValue());
            groupActivityData.setgActivityTitle(dataRes.gActivityTitle);
            groupActivityData.setGroupId(dataRes.groupId.longValue());
            groupActivityData.setGroupName(dataRes.groupName);
            this.activityData = groupActivityData;
        }
    }
}
