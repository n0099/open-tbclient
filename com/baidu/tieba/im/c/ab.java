package com.baidu.tieba.im.c;

import android.text.TextUtils;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
class ab implements com.baidu.tbadk.util.d<LinkedHashMap<String, String>> {
    final /* synthetic */ a bWG;
    private final /* synthetic */ ad bWQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(a aVar, ad adVar) {
        this.bWG = aVar;
        this.bWQ = adVar;
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
                String z = com.baidu.tieba.im.util.h.z(str3, true);
                if (z != null) {
                    linkedHashMap2.put(str2, z);
                }
                String z2 = com.baidu.tieba.im.util.h.z(str3, false);
                if (!TextUtils.isEmpty(z2) && !TextUtils.isEmpty(z)) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = z2;
                    imageUrlData.urlType = 10;
                    hashMap.put(z, imageUrlData);
                }
            }
        }
        this.bWQ.a(linkedHashMap2, hashMap);
    }
}
