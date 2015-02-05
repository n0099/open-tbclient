package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.im.c.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements ad {
    final /* synthetic */ AbsMsgImageActivity aRi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AbsMsgImageActivity absMsgImageActivity) {
        this.aRi = absMsgImageActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0015, code lost:
        if (r0 != false) goto L40;
     */
    @Override // com.baidu.tieba.im.c.ad
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(LinkedHashMap<String, String> linkedHashMap) {
        LinkedHashMap linkedHashMap2;
        LinkedHashMap linkedHashMap3;
        LinkedHashMap linkedHashMap4;
        String str;
        LinkedHashMap linkedHashMap5;
        boolean z;
        LinkedHashMap linkedHashMap6;
        TextView textView;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        MultiImageView multiImageView3;
        LinkedHashMap linkedHashMap7;
        MultiImageView multiImageView4;
        int i;
        int i2;
        String str2;
        LinkedHashMap linkedHashMap8;
        String str3;
        String str4;
        boolean z2;
        this.aRi.aQU = linkedHashMap;
        linkedHashMap2 = this.aRi.aQU;
        if (linkedHashMap2 != null) {
            z2 = this.aRi.aRh;
        }
        this.aRi.aQU = new LinkedHashMap();
        linkedHashMap3 = this.aRi.aQU;
        if (linkedHashMap3.isEmpty()) {
            str2 = this.aRi.aRc;
            if (!TextUtils.isEmpty(str2)) {
                linkedHashMap8 = this.aRi.aQU;
                str3 = this.aRi.aRd;
                str4 = this.aRi.aRc;
                linkedHashMap8.put(str3, str4);
            }
        }
        linkedHashMap4 = this.aRi.aQU;
        if (linkedHashMap4.size() != 0) {
            str = this.aRi.aRd;
            linkedHashMap5 = this.aRi.aQU;
            Iterator it = linkedHashMap5.keySet().iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                String str5 = (String) it.next();
                if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str5) && str5.equals(str)) {
                    this.aRi.mIndex = i3;
                    z = true;
                    break;
                }
                i3++;
            }
            AbsMsgImageActivity absMsgImageActivity = this.aRi;
            linkedHashMap6 = this.aRi.aQU;
            absMsgImageActivity.mCount = linkedHashMap6.size();
            if (!z) {
                AbsMsgImageActivity absMsgImageActivity2 = this.aRi;
                i2 = this.aRi.mCount;
                absMsgImageActivity2.mIndex = i2 - 1;
            }
            textView = this.aRi.mTextView;
            textView.setVisibility(0);
            this.aRi.Ka();
            multiImageView = this.aRi.aQY;
            multiImageView.setIsFromCDN(true);
            multiImageView2 = this.aRi.aQY;
            multiImageView2.setAllowLocalUrl(true);
            multiImageView3 = this.aRi.aQY;
            linkedHashMap7 = this.aRi.aQU;
            multiImageView3.setUrlData(new ArrayList<>(linkedHashMap7.values()));
            multiImageView4 = this.aRi.aQY;
            i = this.aRi.mIndex;
            multiImageView4.setCurrentItem(i, false);
            return;
        }
        this.aRi.finish();
    }
}
