package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.GroupMsgPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tieba.im.a<Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1594a;
    final /* synthetic */ GroupMsgPojo b;
    final /* synthetic */ a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar, String str, GroupMsgPojo groupMsgPojo) {
        this.c = aVar;
        this.f1594a = str;
        this.b = groupMsgPojo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r3) {
        if (!TextUtils.isEmpty(this.f1594a) && !TextUtils.isEmpty(com.baidu.tieba.im.pushNotify.l.a().d()) && !this.f1594a.equals(com.baidu.tieba.im.pushNotify.l.a().d())) {
            com.baidu.tieba.im.pushNotify.l.a().a(this.b);
        }
    }
}
