package com.baidu.tieba.im.sendmessage;

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
    final /* synthetic */ a dgT;
    private final /* synthetic */ ad dhe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(a aVar, ad adVar) {
        this.dgT = aVar;
        this.dhe = adVar;
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
        this.dhe.a(linkedHashMap2, hashMap);
    }
}
