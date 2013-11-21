package com.baidu.tieba.im.groupUpdates;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdatesActivity f1699a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(UpdatesActivity updatesActivity) {
        this.f1699a = updatesActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(LinkedList<GroupNewsPojo> linkedList) {
        n nVar;
        n nVar2;
        nVar = this.f1699a.b;
        nVar.a(m.a(linkedList));
        nVar2 = this.f1699a.b;
        nVar2.a(false);
        this.f1699a.e();
    }
}
