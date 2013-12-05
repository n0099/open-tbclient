package com.baidu.tieba.im.chat;

import java.util.ArrayList;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.im.a<LinkedList<String>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ab f1558a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, ab abVar) {
        this.b = aVar;
        this.f1558a = abVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(LinkedList<String> linkedList) {
        ArrayList<String> arrayList = new ArrayList<>();
        while (!linkedList.isEmpty()) {
            String a2 = com.baidu.tieba.im.e.d.a(linkedList.removeLast(), true);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        this.f1558a.a(arrayList);
    }
}
