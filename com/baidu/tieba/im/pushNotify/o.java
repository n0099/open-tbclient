package com.baidu.tieba.im.pushNotify;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ l f1868a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar) {
        this.f1868a = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(LinkedList<GroupNewsPojo> linkedList) {
        this.f1868a.a(linkedList);
        this.f1868a.b(linkedList);
    }
}
