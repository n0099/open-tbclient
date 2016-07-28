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
public class z implements com.baidu.tbadk.util.g<LinkedHashMap<String, String>> {
    final /* synthetic */ a cYR;
    private final /* synthetic */ ad cZc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(a aVar, ad adVar) {
        this.cYR = aVar;
        this.cZc = adVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    /* renamed from: b */
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
                String C = com.baidu.tieba.im.util.h.C(str3, true);
                if (C != null) {
                    linkedHashMap2.put(str2, C);
                }
                String C2 = com.baidu.tieba.im.util.h.C(str3, false);
                if (!TextUtils.isEmpty(C2) && !TextUtils.isEmpty(C)) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = C2;
                    imageUrlData.urlType = 10;
                    hashMap.put(C, imageUrlData);
                }
            }
        }
        this.cZc.a(linkedHashMap2, hashMap);
    }
}
