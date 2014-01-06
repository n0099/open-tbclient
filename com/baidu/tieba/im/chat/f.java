package com.baidu.tieba.im.chat;

import java.util.ArrayList;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tieba.im.a<LinkedList<String>> {
    final /* synthetic */ ag a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar, ag agVar) {
        this.b = aVar;
        this.a = agVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(LinkedList<String> linkedList) {
        ArrayList<String> arrayList = new ArrayList<>();
        while (!linkedList.isEmpty()) {
            String a = com.baidu.tieba.im.d.d.a(linkedList.removeLast(), true);
            if (a != null) {
                arrayList.add(a);
            }
        }
        this.a.a(arrayList);
    }
}
