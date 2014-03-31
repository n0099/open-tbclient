package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements com.baidu.tieba.im.a<Boolean> {
    private final /* synthetic */ GroupMsgData a;
    private final /* synthetic */ String b;
    private final /* synthetic */ CommonMsgPojo c;
    private final /* synthetic */ int d;
    private final /* synthetic */ boolean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(GroupMsgData groupMsgData, String str, CommonMsgPojo commonMsgPojo, int i, boolean z) {
        this.a = groupMsgData;
        this.b = str;
        this.c = commonMsgPojo;
        this.d = i;
        this.e = z;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* bridge */ /* synthetic */ void a(Boolean bool) {
        b.a(this.a, this.b, this.c, this.d, this.e);
    }
}
