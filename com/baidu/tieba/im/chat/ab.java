package com.baidu.tieba.im.chat;

import java.util.ArrayList;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements com.baidu.tieba.im.a<LinkedList<String>> {
    final /* synthetic */ q a;
    private final /* synthetic */ bd b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(q qVar, bd bdVar) {
        this.a = qVar;
        this.b = bdVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(LinkedList<String> linkedList) {
        ArrayList<String> arrayList = new ArrayList<>();
        while (!linkedList.isEmpty()) {
            String a = com.baidu.tieba.im.util.l.a(linkedList.removeLast(), true);
            if (a != null) {
                arrayList.add(a);
            }
        }
        this.b.a(arrayList);
    }
}
