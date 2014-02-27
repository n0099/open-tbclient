package com.baidu.tieba.im.groupUpdates;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* loaded from: classes.dex */
final class b implements com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> {
    final /* synthetic */ UpdatesActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(UpdatesActivity updatesActivity) {
        this.a = updatesActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(LinkedList<GroupNewsPojo> linkedList) {
        q qVar;
        q qVar2;
        qVar = this.a.b;
        qVar.a(m.a(linkedList));
        qVar2 = this.a.b;
        qVar2.a(false);
        this.a.c();
    }
}
