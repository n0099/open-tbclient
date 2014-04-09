package com.baidu.tieba.im.chat;

import java.util.ArrayList;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class au implements com.baidu.tieba.im.a<LinkedList<String>> {
    final /* synthetic */ x a;
    private final /* synthetic */ bv b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(x xVar, bv bvVar) {
        this.a = xVar;
        this.b = bvVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(LinkedList<String> linkedList) {
        LinkedList<String> linkedList2 = linkedList;
        ArrayList<String> arrayList = new ArrayList<>();
        while (!linkedList2.isEmpty()) {
            String a = com.baidu.tieba.im.f.q.a(linkedList2.removeLast(), true);
            if (a != null) {
                arrayList.add(a);
            }
        }
        this.b.a(arrayList);
    }
}
