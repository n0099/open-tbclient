package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.im.a<Boolean> {
    private final /* synthetic */ com.baidu.tieba.im.data.c a;
    private final /* synthetic */ String b;
    private final /* synthetic */ CommonMsgPojo c;
    private final /* synthetic */ int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.baidu.tieba.im.data.c cVar, String str, CommonMsgPojo commonMsgPojo, int i) {
        this.a = cVar;
        this.b = str;
        this.c = commonMsgPojo;
        this.d = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        a.b(this.a, this.b, this.c, this.d);
    }
}
