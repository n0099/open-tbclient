package com.baidu.tieba.im.chat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements com.baidu.tieba.im.a<LinkedHashMap<String, String>> {
    final /* synthetic */ w a;
    private final /* synthetic */ bs b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(w wVar, bs bsVar) {
        this.a = wVar;
        this.b = bsVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(LinkedHashMap<String, String> linkedHashMap) {
        LinkedHashMap<String, String> linkedHashMap2 = new LinkedHashMap<>();
        if (linkedHashMap != null && linkedHashMap.size() > 0) {
            ArrayList arrayList = new ArrayList(linkedHashMap.size());
            for (String str : linkedHashMap.keySet()) {
                arrayList.add(str);
            }
            Collections.reverse(arrayList);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                String a = com.baidu.tieba.im.d.j.a(linkedHashMap.get(str2), true);
                if (a != null) {
                    linkedHashMap2.put(str2, a);
                }
            }
        }
        this.b.a(linkedHashMap2);
    }
}
