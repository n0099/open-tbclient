package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.im.sendmessage.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements ad {
    final /* synthetic */ AbsMsgImageActivity cLO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AbsMsgImageActivity absMsgImageActivity) {
        this.cLO = absMsgImageActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000a, code lost:
        if (r0 != false) goto L43;
     */
    @Override // com.baidu.tieba.im.sendmessage.ad
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
            z2 = this.cLO.cLN;
        }
        linkedHashMap = new LinkedHashMap<>();
        if (linkedHashMap.isEmpty()) {
            str2 = this.cLO.cLH;
            if (!TextUtils.isEmpty(str2)) {
                str3 = this.cLO.cLJ;
                str4 = this.cLO.cLH;
                linkedHashMap.put(str3, str4);
                if (hashMap == null) {
                    hashMap = new HashMap<>();
                }
                ImageUrlData imageUrlData = new ImageUrlData();
                str5 = this.cLO.cLI;
                imageUrlData.imageUrl = str5;
                imageUrlData.urlType = 10;
                str6 = this.cLO.cLH;
                hashMap.put(str6, imageUrlData);
            }
        }
        if (linkedHashMap.size() != 0) {
            str = this.cLO.cLJ;
            Iterator<String> it = linkedHashMap.keySet().iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                String next = it.next();
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(next) && next.equals(str)) {
                    this.cLO.mIndex = i3;
                    z = true;
                    break;
                }
                i3++;
            }
            this.cLO.mCount = linkedHashMap.size();
            if (!z) {
                AbsMsgImageActivity absMsgImageActivity = this.cLO;
                i2 = this.cLO.mCount;
                absMsgImageActivity.mIndex = i2 - 1;
            }
            textView = this.cLO.Vt;
            textView.setVisibility(0);
            this.cLO.anx();
            multiImageView = this.cLO.cLC;
            multiImageView.setIsFromCDN(true);
            multiImageView2 = this.cLO.cLC;
            multiImageView2.setAllowLocalUrl(true);
            multiImageView3 = this.cLO.cLC;
            multiImageView3.setAssistUrls(hashMap);
            multiImageView4 = this.cLO.cLC;
            multiImageView4.setUrlData(new ArrayList<>(linkedHashMap.values()));
            multiImageView5 = this.cLO.cLC;
            i = this.cLO.mIndex;
            multiImageView5.setCurrentItem(i, false);
            return;
        }
        this.cLO.finish();
    }
}
