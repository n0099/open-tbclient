package com.baidu.tieba.im.pushNotify;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ l f1869a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar) {
        this.f1869a = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(LinkedList<GroupNewsPojo> linkedList) {
        this.f1869a.a(linkedList);
        this.f1869a.b(linkedList);
    }
}
