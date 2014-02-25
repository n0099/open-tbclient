package com.baidu.tieba.im.message;

import com.baidu.tieba.im.data.GroupActivityData;
import java.util.LinkedList;
import protobuf.AddGroupActivity.AddGroupActivityRes;
/* loaded from: classes.dex */
public class bt extends da implements com.baidu.tieba.im.coder.f {
    private GroupActivityData a;

    public void a(GroupActivityData groupActivityData) {
        this.a = groupActivityData;
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<s> linkedList, byte[] bArr, int i) {
        AddGroupActivityRes.AddGroupActivityResIdl parseFrom = AddGroupActivityRes.AddGroupActivityResIdl.parseFrom(bArr);
        e(i);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!l()) {
            AddGroupActivityRes.DataRes data = parseFrom.getData();
            GroupActivityData groupActivityData = new GroupActivityData();
            groupActivityData.setgActivityArea(data.getGActivityArea());
            groupActivityData.setgActivityTime(data.getGActivityTime());
            groupActivityData.setgActivityTitle(data.getGActivityTitle());
            groupActivityData.setGroupId(data.getGroupId());
            groupActivityData.setGroupName(data.getGroupName());
            a(groupActivityData);
        }
    }
}
