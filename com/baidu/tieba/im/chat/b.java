package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.im.pushNotify.m {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f1520a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f1520a = aVar;
    }

    @Override // com.baidu.tieba.im.pushNotify.m
    public void a(GroupNewsPojo groupNewsPojo) {
        this.f1520a.a(groupNewsPojo);
    }
}
