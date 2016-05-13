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
    final /* synthetic */ AbsMsgImageActivity bYM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AbsMsgImageActivity absMsgImageActivity) {
        this.bYM = absMsgImageActivity;
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
            z2 = this.bYM.bYL;
        }
        linkedHashMap = new LinkedHashMap<>();
        if (linkedHashMap.isEmpty()) {
            str2 = this.bYM.bYF;
            if (!TextUtils.isEmpty(str2)) {
                str3 = this.bYM.bYH;
                str4 = this.bYM.bYF;
                linkedHashMap.put(str3, str4);
                if (hashMap == null) {
                    hashMap = new HashMap<>();
                }
                ImageUrlData imageUrlData = new ImageUrlData();
                str5 = this.bYM.bYG;
                imageUrlData.imageUrl = str5;
                imageUrlData.urlType = 10;
                str6 = this.bYM.bYF;
                hashMap.put(str6, imageUrlData);
            }
        }
        if (linkedHashMap.size() != 0) {
            str = this.bYM.bYH;
            Iterator<String> it = linkedHashMap.keySet().iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                String next = it.next();
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(next) && next.equals(str)) {
                    this.bYM.mIndex = i3;
                    z = true;
                    break;
                }
                i3++;
            }
            this.bYM.ni = linkedHashMap.size();
            if (!z) {
                AbsMsgImageActivity absMsgImageActivity = this.bYM;
                i2 = this.bYM.ni;
                absMsgImageActivity.mIndex = i2 - 1;
            }
            textView = this.bYM.Sm;
            textView.setVisibility(0);
            this.bYM.abF();
            multiImageView = this.bYM.bYA;
            multiImageView.setIsFromCDN(true);
            multiImageView2 = this.bYM.bYA;
            multiImageView2.setAllowLocalUrl(true);
            multiImageView3 = this.bYM.bYA;
            multiImageView3.setAssistUrls(hashMap);
            multiImageView4 = this.bYM.bYA;
            multiImageView4.setUrlData(new ArrayList<>(linkedHashMap.values()));
            multiImageView5 = this.bYM.bYA;
            i = this.bYM.mIndex;
            multiImageView5.setCurrentItem(i, false);
            return;
        }
        this.bYM.finish();
    }
}
