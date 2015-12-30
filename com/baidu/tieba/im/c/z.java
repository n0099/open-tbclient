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
public class z implements com.baidu.tbadk.util.d<LinkedHashMap<String, String>> {
    final /* synthetic */ a caF;
    private final /* synthetic */ ad caP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(a aVar, ad adVar) {
        this.caF = aVar;
        this.caP = adVar;
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
                String y = com.baidu.tieba.im.util.h.y(str3, true);
                if (y != null) {
                    linkedHashMap2.put(str2, y);
                }
                String y2 = com.baidu.tieba.im.util.h.y(str3, false);
                if (!TextUtils.isEmpty(y2) && !TextUtils.isEmpty(y)) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = y2;
                    imageUrlData.urlType = 10;
                    hashMap.put(y, imageUrlData);
                }
            }
        }
        this.caP.a(linkedHashMap2, hashMap);
    }
}
