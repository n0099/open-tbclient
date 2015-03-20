package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tieba.im.c.ad {
    final /* synthetic */ AbsMsgImageActivity aWp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AbsMsgImageActivity absMsgImageActivity) {
        this.aWp = absMsgImageActivity;
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
            z2 = this.aWp.aWo;
        }
        linkedHashMap = new LinkedHashMap<>();
        if (linkedHashMap.isEmpty()) {
            str2 = this.aWp.aWi;
            if (!TextUtils.isEmpty(str2)) {
                str3 = this.aWp.aWk;
                str4 = this.aWp.aWi;
                linkedHashMap.put(str3, str4);
                if (hashMap == null) {
                    hashMap = new HashMap<>();
                }
                ImageUrlData imageUrlData = new ImageUrlData();
                str5 = this.aWp.aWj;
                imageUrlData.imageUrl = str5;
                imageUrlData.urlType = 10;
                str6 = this.aWp.aWi;
                hashMap.put(str6, imageUrlData);
            }
        }
        if (linkedHashMap.size() != 0) {
            str = this.aWp.aWk;
            Iterator<String> it = linkedHashMap.keySet().iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                String next = it.next();
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(next) && next.equals(str)) {
                    this.aWp.mIndex = i3;
                    z = true;
                    break;
                }
                i3++;
            }
            this.aWp.mCount = linkedHashMap.size();
            if (!z) {
                AbsMsgImageActivity absMsgImageActivity = this.aWp;
                i2 = this.aWp.mCount;
                absMsgImageActivity.mIndex = i2 - 1;
            }
            textView = this.aWp.mTextView;
            textView.setVisibility(0);
            this.aWp.Nq();
            multiImageView = this.aWp.aWe;
            multiImageView.setIsFromCDN(true);
            multiImageView2 = this.aWp.aWe;
            multiImageView2.setAllowLocalUrl(true);
            multiImageView3 = this.aWp.aWe;
            multiImageView3.setAssistUrls(hashMap);
            multiImageView4 = this.aWp.aWe;
            multiImageView4.setUrlData(new ArrayList<>(linkedHashMap.values()));
            multiImageView5 = this.aWp.aWe;
            i = this.aWp.mIndex;
            multiImageView5.setCurrentItem(i, false);
            return;
        }
        this.aWp.finish();
    }
}
