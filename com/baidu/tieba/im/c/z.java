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
public class z implements com.baidu.tieba.im.g<LinkedHashMap<String, String>> {
    final /* synthetic */ a bDl;
    private final /* synthetic */ ad bDu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(a aVar, ad adVar) {
        this.bDl = aVar;
        this.bDu = adVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
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
                String t = com.baidu.tieba.im.util.h.t(str3, true);
                if (t != null) {
                    linkedHashMap2.put(str2, t);
                }
                String t2 = com.baidu.tieba.im.util.h.t(str3, false);
                if (!TextUtils.isEmpty(t2) && !TextUtils.isEmpty(t)) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = t2;
                    imageUrlData.urlType = 10;
                    hashMap.put(t, imageUrlData);
                }
            }
        }
        this.bDu.a(linkedHashMap2, hashMap);
    }
}
