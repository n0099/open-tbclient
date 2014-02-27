package com.baidu.tieba.im.message;

import com.baidu.tieba.im.data.GroupActivityData;
import java.util.LinkedList;
import protobuf.DelGroupActivity.DelGroupActivityRes;
/* loaded from: classes.dex */
public class bu extends da implements com.baidu.tieba.im.coder.f {
    private GroupActivityData a;

    @Override // com.baidu.tieba.im.coder.f
    public final void a(LinkedList<s> linkedList, byte[] bArr, int i) {
        DelGroupActivityRes.DelGroupActivityResIdl parseFrom = DelGroupActivityRes.DelGroupActivityResIdl.parseFrom(bArr);
        e(i);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!l()) {
            DelGroupActivityRes.DataRes data = parseFrom.getData();
            GroupActivityData groupActivityData = new GroupActivityData();
            groupActivityData.setGroupId(data.getGroupId());
            groupActivityData.setGroupName(data.getGroupName());
            groupActivityData.setActivityId(data.getActivityId());
            groupActivityData.setIsEnd(data.getIsEnd());
            this.a = groupActivityData;
        }
    }
}
