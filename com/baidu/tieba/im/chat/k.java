package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ com.baidu.tieba.im.data.c a;
    final /* synthetic */ String b;
    final /* synthetic */ CommonMsgPojo c;
    final /* synthetic */ int d;
    final /* synthetic */ a e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar, com.baidu.tieba.im.data.c cVar, String str, CommonMsgPojo commonMsgPojo, int i) {
        this.e = aVar;
        this.a = cVar;
        this.b = str;
        this.c = commonMsgPojo;
        this.d = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        this.e.a(this.a, this.b, this.c, this.d);
    }
}
