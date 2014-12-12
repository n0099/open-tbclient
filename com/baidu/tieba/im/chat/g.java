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
    final /* synthetic */ AbsMsgImageActivity aQe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AbsMsgImageActivity absMsgImageActivity) {
        this.aQe = absMsgImageActivity;
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
        this.aQe.aPQ = linkedHashMap;
        linkedHashMap2 = this.aQe.aPQ;
        if (linkedHashMap2 != null) {
            z2 = this.aQe.aQd;
        }
        this.aQe.aPQ = new LinkedHashMap();
        linkedHashMap3 = this.aQe.aPQ;
        if (linkedHashMap3.isEmpty()) {
            str2 = this.aQe.aPY;
            if (!TextUtils.isEmpty(str2)) {
                linkedHashMap8 = this.aQe.aPQ;
                str3 = this.aQe.aPZ;
                str4 = this.aQe.aPY;
                linkedHashMap8.put(str3, str4);
            }
        }
        linkedHashMap4 = this.aQe.aPQ;
        if (linkedHashMap4.size() != 0) {
            str = this.aQe.aPZ;
            linkedHashMap5 = this.aQe.aPQ;
            Iterator it = linkedHashMap5.keySet().iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                String str5 = (String) it.next();
                if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str5) && str5.equals(str)) {
                    this.aQe.mIndex = i3;
                    z = true;
                    break;
                }
                i3++;
            }
            AbsMsgImageActivity absMsgImageActivity = this.aQe;
            linkedHashMap6 = this.aQe.aPQ;
            absMsgImageActivity.mCount = linkedHashMap6.size();
            if (!z) {
                AbsMsgImageActivity absMsgImageActivity2 = this.aQe;
                i2 = this.aQe.mCount;
                absMsgImageActivity2.mIndex = i2 - 1;
            }
            textView = this.aQe.mTextView;
            textView.setVisibility(0);
            this.aQe.JK();
            multiImageView = this.aQe.aPU;
            multiImageView.setIsFromCDN(true);
            multiImageView2 = this.aQe.aPU;
            multiImageView2.setAllowLocalUrl(true);
            multiImageView3 = this.aQe.aPU;
            linkedHashMap7 = this.aQe.aPQ;
            multiImageView3.setUrlData(new ArrayList<>(linkedHashMap7.values()));
            multiImageView4 = this.aQe.aPU;
            i = this.aQe.mIndex;
            multiImageView4.setCurrentItem(i, false);
            return;
        }
        this.aQe.finish();
    }
}
