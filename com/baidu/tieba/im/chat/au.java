package com.baidu.tieba.im.chat;

import java.util.ArrayList;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements com.baidu.tieba.im.a<LinkedList<String>> {
    final /* synthetic */ x a;
    private final /* synthetic */ bv b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(x xVar, bv bvVar) {
        this.a = xVar;
        this.b = bvVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(LinkedList<String> linkedList) {
        ArrayList<String> arrayList = new ArrayList<>();
        while (!linkedList.isEmpty()) {
            String a = com.baidu.tieba.im.f.r.a(linkedList.removeLast(), true);
            if (a != null) {
                arrayList.add(a);
            }
        }
        this.b.a(arrayList);
    }
}
