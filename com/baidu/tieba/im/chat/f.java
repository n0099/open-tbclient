package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements bs {
    final /* synthetic */ AbsMsgImageActivity aNO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AbsMsgImageActivity absMsgImageActivity) {
        this.aNO = absMsgImageActivity;
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
        this.aNO.aNC = linkedHashMap;
        linkedHashMap2 = this.aNO.aNC;
        if (linkedHashMap2 != null) {
            z2 = this.aNO.aNN;
        }
        this.aNO.aNC = new LinkedHashMap();
        linkedHashMap3 = this.aNO.aNC;
        if (linkedHashMap3.isEmpty()) {
            str2 = this.aNO.aNI;
            if (!TextUtils.isEmpty(str2)) {
                linkedHashMap8 = this.aNO.aNC;
                str3 = this.aNO.aNJ;
                str4 = this.aNO.aNI;
                linkedHashMap8.put(str3, str4);
            }
        }
        linkedHashMap4 = this.aNO.aNC;
        if (linkedHashMap4.size() != 0) {
            str = this.aNO.aNJ;
            linkedHashMap5 = this.aNO.aNC;
            Iterator it = linkedHashMap5.keySet().iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                String str5 = (String) it.next();
                if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str5) && str5.equals(str)) {
                    this.aNO.mIndex = i3;
                    z = true;
                    break;
                }
                i3++;
            }
            AbsMsgImageActivity absMsgImageActivity = this.aNO;
            linkedHashMap6 = this.aNO.aNC;
            absMsgImageActivity.mq = linkedHashMap6.size();
            if (!z) {
                AbsMsgImageActivity absMsgImageActivity2 = this.aNO;
                i2 = this.aNO.mq;
                absMsgImageActivity2.mIndex = i2 - 1;
            }
            this.aNO.Jp();
            multiImageView = this.aNO.aNF;
            multiImageView.setIsFromCDN(true);
            multiImageView2 = this.aNO.aNF;
            multiImageView2.setAllowLocalUrl(true);
            multiImageView3 = this.aNO.aNF;
            linkedHashMap7 = this.aNO.aNC;
            multiImageView3.setUrlData(new ArrayList<>(linkedHashMap7.values()));
            multiImageView4 = this.aNO.aNF;
            i = this.aNO.mIndex;
            multiImageView4.setCurrentItem(i, false);
            return;
        }
        this.aNO.finish();
    }
}
