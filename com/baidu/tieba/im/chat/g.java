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
    final /* synthetic */ AbsMsgImageActivity cZt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AbsMsgImageActivity absMsgImageActivity) {
        this.cZt = absMsgImageActivity;
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
            z2 = this.cZt.cZs;
        }
        linkedHashMap = new LinkedHashMap<>();
        if (linkedHashMap.isEmpty()) {
            str2 = this.cZt.cZm;
            if (!TextUtils.isEmpty(str2)) {
                str3 = this.cZt.cZo;
                str4 = this.cZt.cZm;
                linkedHashMap.put(str3, str4);
                if (hashMap == null) {
                    hashMap = new HashMap<>();
                }
                ImageUrlData imageUrlData = new ImageUrlData();
                str5 = this.cZt.cZn;
                imageUrlData.imageUrl = str5;
                imageUrlData.urlType = 10;
                str6 = this.cZt.cZm;
                hashMap.put(str6, imageUrlData);
            }
        }
        if (linkedHashMap.size() != 0) {
            str = this.cZt.cZo;
            Iterator<String> it = linkedHashMap.keySet().iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                String next = it.next();
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(next) && next.equals(str)) {
                    this.cZt.mIndex = i3;
                    z = true;
                    break;
                }
                i3++;
            }
            this.cZt.qh = linkedHashMap.size();
            if (!z) {
                AbsMsgImageActivity absMsgImageActivity = this.cZt;
                i2 = this.cZt.qh;
                absMsgImageActivity.mIndex = i2 - 1;
            }
            textView = this.cZt.WJ;
            textView.setVisibility(0);
            this.cZt.arM();
            multiImageView = this.cZt.cZh;
            multiImageView.setIsFromCDN(true);
            multiImageView2 = this.cZt.cZh;
            multiImageView2.setAllowLocalUrl(true);
            multiImageView3 = this.cZt.cZh;
            multiImageView3.setAssistUrls(hashMap);
            multiImageView4 = this.cZt.cZh;
            multiImageView4.setUrlData(new ArrayList<>(linkedHashMap.values()));
            multiImageView5 = this.cZt.cZh;
            i = this.cZt.mIndex;
            multiImageView5.setCurrentItem(i, false);
            return;
        }
        this.cZt.finish();
    }
}
