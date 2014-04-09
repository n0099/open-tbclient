package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.GroupActivityData;
import protobuf.DelGroupActivity.DelGroupActivityRes;
/* loaded from: classes.dex */
public class ResponseDelGroupActivityMessage extends SocketResponsedMessage {
    private GroupActivityData a;

    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        DelGroupActivityRes.DelGroupActivityResIdl parseFrom = DelGroupActivityRes.DelGroupActivityResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        d(parseFrom.getError().getUsermsg());
        if (e() == 0) {
            DelGroupActivityRes.DataRes data = parseFrom.getData();
            GroupActivityData groupActivityData = new GroupActivityData();
            groupActivityData.setGroupId(data.getGroupId());
            groupActivityData.setGroupName(data.getGroupName());
            groupActivityData.setActivityId(data.getActivityId());
            groupActivityData.setIsEnd(data.getIsEnd());
            this.a = groupActivityData;
        }
    }

    public ResponseDelGroupActivityMessage() {
        super(103121);
    }
}
