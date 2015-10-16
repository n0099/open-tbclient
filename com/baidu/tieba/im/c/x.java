package com.baidu.tieba.im.c;

import android.text.TextUtils;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements com.baidu.tbadk.util.d<LinkedHashMap<String, String>> {
    final /* synthetic */ a bHf;
    private final /* synthetic */ ad bHp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(a aVar, ad adVar) {
        this.bHf = aVar;
        this.bHp = adVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    /* renamed from: a */
    public void onReturnDataInUI(LinkedHashMap<String, String> linkedHashMap) {
        LinkedHashMap<String, String> linkedHashMap2 = new LinkedHashMap<>();
        HashMap<String, ImageUrlData> hashMap = new HashMap<>();
        if (linkedHashMap != null && linkedHashMap.size() > 0) {
            ArrayList arrayList = new ArrayList(linkedHashMap.size());
            for (String str : linkedHashMap.keySet()) {
                arrayList.add(str);
            }
            Collections.reverse(arrayList);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                String str3 = linkedHashMap.get(str2);
                String x = com.baidu.tieba.im.util.h.x(str3, true);
                if (x != null) {
                    linkedHashMap2.put(str2, x);
                }
                String x2 = com.baidu.tieba.im.util.h.x(str3, false);
                if (!TextUtils.isEmpty(x2) && !TextUtils.isEmpty(x)) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = x2;
                    imageUrlData.urlType = 10;
                    hashMap.put(x, imageUrlData);
                }
            }
        }
        this.bHp.a(linkedHashMap2, hashMap);
    }
}
