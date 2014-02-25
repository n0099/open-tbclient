package com.baidu.tieba.im.groupUpdates;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> {
    final /* synthetic */ UpdatesActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(UpdatesActivity updatesActivity) {
        this.a = updatesActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(LinkedList<GroupNewsPojo> linkedList) {
        q qVar;
        q qVar2;
        qVar = this.a.b;
        qVar.a(m.a(linkedList));
        qVar2 = this.a.b;
        qVar2.a(false);
        this.a.e();
    }
}
