package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tieba.im.a<Boolean> {
    private final /* synthetic */ GroupMsgData a;
    private final /* synthetic */ String b;
    private final /* synthetic */ CommonMsgPojo c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(GroupMsgData groupMsgData, String str, CommonMsgPojo commonMsgPojo) {
        this.a = groupMsgData;
        this.b = str;
        this.c = commonMsgPojo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        g.b(this.a, this.b, this.c);
    }
}
