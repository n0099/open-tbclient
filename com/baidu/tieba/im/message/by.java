package com.baidu.tieba.im.message;

import com.baidu.tieba.im.data.GroupActivityData;
import java.util.LinkedList;
import protobuf.QueryGroupActivity.QueryGroupActivityRes;
/* loaded from: classes.dex */
public class by extends da implements com.baidu.tieba.im.coder.f {
    private GroupActivityData a;

    public GroupActivityData a() {
        return this.a;
    }

    public void a(GroupActivityData groupActivityData) {
        this.a = groupActivityData;
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<s> linkedList, byte[] bArr, int i) {
        QueryGroupActivityRes.QueryGroupActivityResIdl parseFrom = QueryGroupActivityRes.QueryGroupActivityResIdl.parseFrom(bArr);
        e(i);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!l()) {
            QueryGroupActivityRes.DataRes data = parseFrom.getData();
            GroupActivityData groupActivityData = new GroupActivityData();
            groupActivityData.setActivityPortrait(data.getActivityPortrait());
            groupActivityData.setgActivityArea(data.getGActivityArea());
            groupActivityData.setgActivityContent(data.getGActivityContent());
            groupActivityData.setgActivityTime(data.getGActivityTime());
            groupActivityData.setgActivityTitle(data.getGActivityTitle());
            groupActivityData.setGroupId(data.getGroupId());
            groupActivityData.setActivityId(data.getActivityId());
            groupActivityData.setUserId(data.getUserId());
            groupActivityData.setUserName(data.getUserName());
            groupActivityData.setIsEnd(data.getIsEnd());
            a(groupActivityData);
        }
    }
}
