package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements bs {
    final /* synthetic */ AbsMsgImageActivity aNA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AbsMsgImageActivity absMsgImageActivity) {
        this.aNA = absMsgImageActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0015, code lost:
        if (r0 != false) goto L40;
     */
    @Override // com.baidu.tieba.im.chat.bs
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
        this.aNA.aNo = linkedHashMap;
        linkedHashMap2 = this.aNA.aNo;
        if (linkedHashMap2 != null) {
            z2 = this.aNA.aNz;
        }
        this.aNA.aNo = new LinkedHashMap();
        linkedHashMap3 = this.aNA.aNo;
        if (linkedHashMap3.isEmpty()) {
            str2 = this.aNA.aNu;
            if (!TextUtils.isEmpty(str2)) {
                linkedHashMap8 = this.aNA.aNo;
                str3 = this.aNA.aNv;
                str4 = this.aNA.aNu;
                linkedHashMap8.put(str3, str4);
            }
        }
        linkedHashMap4 = this.aNA.aNo;
        if (linkedHashMap4.size() != 0) {
            str = this.aNA.aNv;
            linkedHashMap5 = this.aNA.aNo;
            Iterator it = linkedHashMap5.keySet().iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                String str5 = (String) it.next();
                if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str5) && str5.equals(str)) {
                    this.aNA.mIndex = i3;
                    z = true;
                    break;
                }
                i3++;
            }
            AbsMsgImageActivity absMsgImageActivity = this.aNA;
            linkedHashMap6 = this.aNA.aNo;
            absMsgImageActivity.mq = linkedHashMap6.size();
            if (!z) {
                AbsMsgImageActivity absMsgImageActivity2 = this.aNA;
                i2 = this.aNA.mq;
                absMsgImageActivity2.mIndex = i2 - 1;
            }
            this.aNA.Jl();
            multiImageView = this.aNA.aNr;
            multiImageView.setIsFromCDN(true);
            multiImageView2 = this.aNA.aNr;
            multiImageView2.setAllowLocalUrl(true);
            multiImageView3 = this.aNA.aNr;
            linkedHashMap7 = this.aNA.aNo;
            multiImageView3.setUrlData(new ArrayList<>(linkedHashMap7.values()));
            multiImageView4 = this.aNA.aNr;
            i = this.aNA.mIndex;
            multiImageView4.setCurrentItem(i, false);
            return;
        }
        this.aNA.finish();
    }
}
