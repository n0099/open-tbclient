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
    final /* synthetic */ a cpJ;
    private final /* synthetic */ ad cpU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(a aVar, ad adVar) {
        this.cpJ = aVar;
        this.cpU = adVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
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
        this.cpU.a(linkedHashMap2, hashMap);
    }
}
