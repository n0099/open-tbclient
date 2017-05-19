package com.baidu.tieba.im.sendmessage;

import android.text.TextUtils;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
class ab implements com.baidu.tbadk.util.g<LinkedHashMap<String, String>> {
    final /* synthetic */ a daU;
    private final /* synthetic */ ad dbf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(a aVar, ad adVar) {
        this.daU = aVar;
        this.dbf = adVar;
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
                String I = com.baidu.tieba.im.util.h.I(str3, true);
                if (I != null) {
                    linkedHashMap2.put(str2, I);
                }
                String I2 = com.baidu.tieba.im.util.h.I(str3, false);
                if (!TextUtils.isEmpty(I2) && !TextUtils.isEmpty(I)) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = I2;
                    imageUrlData.urlType = 10;
                    hashMap.put(I, imageUrlData);
                }
            }
        }
        this.dbf.a(linkedHashMap2, hashMap);
    }
}
