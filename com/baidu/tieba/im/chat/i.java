package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.GroupMsgPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tieba.im.a<Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1552a;
    final /* synthetic */ GroupMsgPojo b;
    final /* synthetic */ a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar, String str, GroupMsgPojo groupMsgPojo) {
        this.c = aVar;
        this.f1552a = str;
        this.b = groupMsgPojo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r3) {
        if (!TextUtils.isEmpty(this.f1552a) && !TextUtils.isEmpty(com.baidu.tieba.im.pushNotify.n.a().d()) && !this.f1552a.equals(com.baidu.tieba.im.pushNotify.n.a().d())) {
            com.baidu.tieba.im.pushNotify.n.a().a(this.b);
        }
    }
}
