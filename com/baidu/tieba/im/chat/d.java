package com.baidu.tieba.im.chat;

import java.util.ArrayList;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.im.a<LinkedList<String>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ y f1547a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, y yVar) {
        this.b = aVar;
        this.f1547a = yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(LinkedList<String> linkedList) {
        ArrayList<String> arrayList = new ArrayList<>();
        while (!linkedList.isEmpty()) {
            String a2 = com.baidu.tieba.im.d.c.a(linkedList.removeLast(), true);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        this.f1547a.a(arrayList);
    }
}
