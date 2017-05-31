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
    final /* synthetic */ AbsMsgImageActivity cOr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AbsMsgImageActivity absMsgImageActivity) {
        this.cOr = absMsgImageActivity;
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
            z2 = this.cOr.cOq;
        }
        linkedHashMap = new LinkedHashMap<>();
        if (linkedHashMap.isEmpty()) {
            str2 = this.cOr.cOk;
            if (!TextUtils.isEmpty(str2)) {
                str3 = this.cOr.cOm;
                str4 = this.cOr.cOk;
                linkedHashMap.put(str3, str4);
                if (hashMap == null) {
                    hashMap = new HashMap<>();
                }
                ImageUrlData imageUrlData = new ImageUrlData();
                str5 = this.cOr.cOl;
                imageUrlData.imageUrl = str5;
                imageUrlData.urlType = 10;
                str6 = this.cOr.cOk;
                hashMap.put(str6, imageUrlData);
            }
        }
        if (linkedHashMap.size() != 0) {
            str = this.cOr.cOm;
            Iterator<String> it = linkedHashMap.keySet().iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                String next = it.next();
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(next) && next.equals(str)) {
                    this.cOr.mIndex = i3;
                    z = true;
                    break;
                }
                i3++;
            }
            this.cOr.mCount = linkedHashMap.size();
            if (!z) {
                AbsMsgImageActivity absMsgImageActivity = this.cOr;
                i2 = this.cOr.mCount;
                absMsgImageActivity.mIndex = i2 - 1;
            }
            textView = this.cOr.mTextView;
            textView.setVisibility(0);
            this.cOr.alF();
            multiImageView = this.cOr.cOf;
            multiImageView.setIsFromCDN(true);
            multiImageView2 = this.cOr.cOf;
            multiImageView2.setAllowLocalUrl(true);
            multiImageView3 = this.cOr.cOf;
            multiImageView3.setAssistUrls(hashMap);
            multiImageView4 = this.cOr.cOf;
            multiImageView4.setUrlData(new ArrayList<>(linkedHashMap.values()));
            multiImageView5 = this.cOr.cOf;
            i = this.cOr.mIndex;
            multiImageView5.setCurrentItem(i, false);
            return;
        }
        this.cOr.finish();
    }
}
