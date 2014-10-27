package com.baidu.tieba.im.chat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements com.baidu.tieba.im.a<LinkedHashMap<String, String>> {
    final /* synthetic */ w aNM;
    private final /* synthetic */ bs aNY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(w wVar, bs bsVar) {
        this.aNM = wVar;
        this.aNY = bsVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    /* renamed from: b */
    public void onReturnDataInUI(LinkedHashMap<String, String> linkedHashMap) {
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
                String v = com.baidu.tieba.im.util.i.v(linkedHashMap.get(str2), true);
                if (v != null) {
                    linkedHashMap2.put(str2, v);
                }
            }
        }
        this.aNY.a(linkedHashMap2);
    }
}
