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
public class x implements com.baidu.tbadk.util.f<LinkedHashMap<String, String>> {
    final /* synthetic */ a drH;
    private final /* synthetic */ ad drS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(a aVar, ad adVar) {
        this.drH = aVar;
        this.drS = adVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
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
                String H = com.baidu.tieba.im.util.h.H(str3, true);
                if (H != null) {
                    linkedHashMap2.put(str2, H);
                }
                String H2 = com.baidu.tieba.im.util.h.H(str3, false);
                if (!TextUtils.isEmpty(H2) && !TextUtils.isEmpty(H)) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = H2;
                    imageUrlData.urlType = 10;
                    hashMap.put(H, imageUrlData);
                }
            }
        }
        this.drS.a(linkedHashMap2, hashMap);
    }
}
