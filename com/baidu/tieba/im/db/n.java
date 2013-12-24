package com.baidu.tieba.im.db;

import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends SingleRunnable<LinkedList<GroupNewsPojo>> {
    final /* synthetic */ long a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ String e;
    final /* synthetic */ l f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar, long j, int i, int i2, String str) {
        this.f = lVar;
        this.a = j;
        this.b = i;
        this.c = i2;
        this.e = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public LinkedList<GroupNewsPojo> b() {
        return this.f.a(this.a, this.b, this.c, this.e);
    }
}
