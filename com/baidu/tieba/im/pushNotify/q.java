package com.baidu.tieba.im.pushNotify;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f1782a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(n nVar) {
        this.f1782a = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(LinkedList<GroupNewsPojo> linkedList) {
        this.f1782a.a(linkedList);
        this.f1782a.b(linkedList);
    }
}
