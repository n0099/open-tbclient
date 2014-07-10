package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements com.baidu.tieba.im.a<Boolean> {
    private final /* synthetic */ GroupMsgData a;
    private final /* synthetic */ String b;
    private final /* synthetic */ CommonMsgPojo c;
    private final /* synthetic */ int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(GroupMsgData groupMsgData, String str, CommonMsgPojo commonMsgPojo, int i) {
        this.a = groupMsgData;
        this.b = str;
        this.c = commonMsgPojo;
        this.d = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        SnapChatMsgHelper.b(this.a, this.b, this.c, this.d);
    }
}
