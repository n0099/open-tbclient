package com.baidu.tieba.im.c;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(m mVar) {
        this.a = mVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(LinkedList<GroupNewsPojo> linkedList) {
        this.a.a(linkedList);
        this.a.b(linkedList);
    }
}
