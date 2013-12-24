package com.baidu.tieba.im.c;

import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends SingleRunnable<LinkedList<GroupNewsPojo>> {
    final /* synthetic */ com.baidu.tieba.im.data.c a;
    final /* synthetic */ int b;
    final /* synthetic */ m c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(m mVar, com.baidu.tieba.im.data.c cVar, int i) {
        this.c = mVar;
        this.a = cVar;
        this.b = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public LinkedList<GroupNewsPojo> b() {
        LinkedList<GroupNewsPojo> b;
        b = this.c.b(this.a, this.b);
        return b;
    }
}
