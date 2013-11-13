package com.baidu.tieba.im.db;

import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends SingleRunnable<LinkedList<GroupNewsPojo>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f1616a;
    final /* synthetic */ int b;
    final /* synthetic */ String c;
    final /* synthetic */ g e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, long j, int i, String str) {
        this.e = gVar;
        this.f1616a = j;
        this.b = i;
        this.c = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public LinkedList<GroupNewsPojo> b() {
        return this.e.a(this.f1616a, this.b, this.c);
    }
}
