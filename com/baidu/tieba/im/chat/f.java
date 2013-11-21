package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.GroupMsgPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tieba.im.a<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GroupMsgData f1540a;
    final /* synthetic */ String b;
    final /* synthetic */ GroupMsgPojo c;
    final /* synthetic */ int d;
    final /* synthetic */ a e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar, GroupMsgData groupMsgData, String str, GroupMsgPojo groupMsgPojo, int i) {
        this.e = aVar;
        this.f1540a = groupMsgData;
        this.b = str;
        this.c = groupMsgPojo;
        this.d = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        this.e.a(this.f1540a, this.b, this.c, this.d);
    }
}
