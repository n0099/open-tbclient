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
public class x implements com.baidu.tbadk.util.g<LinkedHashMap<String, String>> {
    final /* synthetic */ a cqG;
    private final /* synthetic */ ad cqR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(a aVar, ad adVar) {
        this.cqG = aVar;
        this.cqR = adVar;
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
                String A = com.baidu.tieba.im.util.h.A(str3, true);
                if (A != null) {
                    linkedHashMap2.put(str2, A);
                }
                String A2 = com.baidu.tieba.im.util.h.A(str3, false);
                if (!TextUtils.isEmpty(A2) && !TextUtils.isEmpty(A)) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = A2;
                    imageUrlData.urlType = 10;
                    hashMap.put(A, imageUrlData);
                }
            }
        }
        this.cqR.a(linkedHashMap2, hashMap);
    }
}
