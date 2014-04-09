package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.GroupActivityData;
import protobuf.AddGroupActivity.AddGroupActivityRes;
/* loaded from: classes.dex */
public class ResponseCreateGroupActivityMessage extends SocketResponsedMessage {
    private GroupActivityData a;

    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        AddGroupActivityRes.AddGroupActivityResIdl parseFrom = AddGroupActivityRes.AddGroupActivityResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        d(parseFrom.getError().getUsermsg());
        if (e() == 0) {
            AddGroupActivityRes.DataRes data = parseFrom.getData();
            GroupActivityData groupActivityData = new GroupActivityData();
            groupActivityData.setgActivityArea(data.getGActivityArea());
            groupActivityData.setgActivityTime(data.getGActivityTime());
            groupActivityData.setgActivityTitle(data.getGActivityTitle());
            groupActivityData.setGroupId(data.getGroupId());
            groupActivityData.setGroupName(data.getGroupName());
            this.a = groupActivityData;
        }
    }

    public ResponseCreateGroupActivityMessage() {
        super(103120);
    }
}
