package com.baidu.tieba.im.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class GroupMsgData extends CustomResponsedMessage<Object> {
    private GroupIdTypeData a;
    private LinkedList<com.baidu.tieba.im.message.a.a> b;

    public GroupMsgData(int i) {
        super(i);
        this.a = new GroupIdTypeData();
        this.b = new LinkedList<>();
    }

    public final GroupIdTypeData b() {
        return this.a;
    }

    public final void a(GroupIdTypeData groupIdTypeData) {
        this.a = groupIdTypeData;
    }

    public final LinkedList<com.baidu.tieba.im.message.a.a> c() {
        return this.b;
    }

    public final void a(LinkedList<com.baidu.tieba.im.message.a.a> linkedList) {
        this.b = linkedList;
    }
}
