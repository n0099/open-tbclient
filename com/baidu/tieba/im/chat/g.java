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
    final /* synthetic */ AbsMsgImageActivity aRj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AbsMsgImageActivity absMsgImageActivity) {
        this.aRj = absMsgImageActivity;
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
        this.aRj.aQV = linkedHashMap;
        linkedHashMap2 = this.aRj.aQV;
        if (linkedHashMap2 != null) {
            z2 = this.aRj.aRi;
        }
        this.aRj.aQV = new LinkedHashMap();
        linkedHashMap3 = this.aRj.aQV;
        if (linkedHashMap3.isEmpty()) {
            str2 = this.aRj.aRd;
            if (!TextUtils.isEmpty(str2)) {
                linkedHashMap8 = this.aRj.aQV;
                str3 = this.aRj.aRe;
                str4 = this.aRj.aRd;
                linkedHashMap8.put(str3, str4);
            }
        }
        linkedHashMap4 = this.aRj.aQV;
        if (linkedHashMap4.size() != 0) {
            str = this.aRj.aRe;
            linkedHashMap5 = this.aRj.aQV;
            Iterator it = linkedHashMap5.keySet().iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                String str5 = (String) it.next();
                if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str5) && str5.equals(str)) {
                    this.aRj.mIndex = i3;
                    z = true;
                    break;
                }
                i3++;
            }
            AbsMsgImageActivity absMsgImageActivity = this.aRj;
            linkedHashMap6 = this.aRj.aQV;
            absMsgImageActivity.mCount = linkedHashMap6.size();
            if (!z) {
                AbsMsgImageActivity absMsgImageActivity2 = this.aRj;
                i2 = this.aRj.mCount;
                absMsgImageActivity2.mIndex = i2 - 1;
            }
            textView = this.aRj.mTextView;
            textView.setVisibility(0);
            this.aRj.Kf();
            multiImageView = this.aRj.aQZ;
            multiImageView.setIsFromCDN(true);
            multiImageView2 = this.aRj.aQZ;
            multiImageView2.setAllowLocalUrl(true);
            multiImageView3 = this.aRj.aQZ;
            linkedHashMap7 = this.aRj.aQV;
            multiImageView3.setUrlData(new ArrayList<>(linkedHashMap7.values()));
            multiImageView4 = this.aRj.aQZ;
            i = this.aRj.mIndex;
            multiImageView4.setCurrentItem(i, false);
            return;
        }
        this.aRj.finish();
    }
}
