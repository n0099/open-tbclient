package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.im.c.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements ad {
    final /* synthetic */ AbsMsgImageActivity bNP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AbsMsgImageActivity absMsgImageActivity) {
        this.bNP = absMsgImageActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000a, code lost:
        if (r0 != false) goto L43;
     */
    @Override // com.baidu.tieba.im.c.ad
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(LinkedHashMap<String, String> linkedHashMap, HashMap<String, ImageUrlData> hashMap) {
        String str;
        boolean z;
        TextView textView;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        MultiImageView multiImageView3;
        MultiImageView multiImageView4;
        MultiImageView multiImageView5;
        int i;
        int i2;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        boolean z2;
        if (linkedHashMap != null) {
            z2 = this.bNP.bNO;
        }
        linkedHashMap = new LinkedHashMap<>();
        if (linkedHashMap.isEmpty()) {
            str2 = this.bNP.bNI;
            if (!TextUtils.isEmpty(str2)) {
                str3 = this.bNP.bNK;
                str4 = this.bNP.bNI;
                linkedHashMap.put(str3, str4);
                if (hashMap == null) {
                    hashMap = new HashMap<>();
                }
                ImageUrlData imageUrlData = new ImageUrlData();
                str5 = this.bNP.bNJ;
                imageUrlData.imageUrl = str5;
                imageUrlData.urlType = 10;
                str6 = this.bNP.bNI;
                hashMap.put(str6, imageUrlData);
            }
        }
        if (linkedHashMap.size() != 0) {
            str = this.bNP.bNK;
            Iterator<String> it = linkedHashMap.keySet().iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                String next = it.next();
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(next) && next.equals(str)) {
                    this.bNP.mIndex = i3;
                    z = true;
                    break;
                }
                i3++;
            }
            this.bNP.wS = linkedHashMap.size();
            if (!z) {
                AbsMsgImageActivity absMsgImageActivity = this.bNP;
                i2 = this.bNP.wS;
                absMsgImageActivity.mIndex = i2 - 1;
            }
            textView = this.bNP.YG;
            textView.setVisibility(0);
            this.bNP.Yl();
            multiImageView = this.bNP.bND;
            multiImageView.setIsFromCDN(true);
            multiImageView2 = this.bNP.bND;
            multiImageView2.setAllowLocalUrl(true);
            multiImageView3 = this.bNP.bND;
            multiImageView3.setAssistUrls(hashMap);
            multiImageView4 = this.bNP.bND;
            multiImageView4.setUrlData(new ArrayList<>(linkedHashMap.values()));
            multiImageView5 = this.bNP.bND;
            i = this.bNP.mIndex;
            multiImageView5.setCurrentItem(i, false);
            return;
        }
        this.bNP.finish();
    }
}
