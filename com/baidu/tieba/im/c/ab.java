package com.baidu.tieba.im.c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements com.baidu.tieba.im.g<LinkedHashMap<String, String>> {
    final /* synthetic */ a boF;
    private final /* synthetic */ ad boO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(a aVar, ad adVar) {
        this.boF = aVar;
        this.boO = adVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
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
                String s = com.baidu.tieba.im.util.i.s(linkedHashMap.get(str2), true);
                if (s != null) {
                    linkedHashMap2.put(str2, s);
                }
            }
        }
        this.boO.a(linkedHashMap2);
    }
}
