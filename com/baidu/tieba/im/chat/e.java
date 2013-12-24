package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ String a;
    final /* synthetic */ CommonMsgPojo b;
    final /* synthetic */ a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, String str, CommonMsgPojo commonMsgPojo) {
        this.c = aVar;
        this.a = str;
        this.b = commonMsgPojo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r3) {
        if (!TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(com.baidu.tieba.im.c.m.a().d()) && !this.a.equals(com.baidu.tieba.im.c.m.a().d())) {
            com.baidu.tieba.im.c.m.a().a(this.b);
        }
    }
}
