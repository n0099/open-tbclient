package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tieba.view.MultiImageView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements bd {
    final /* synthetic */ MsgImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(MsgImageActivity msgImageActivity) {
        this.a = msgImageActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0015, code lost:
        if (r0 != false) goto L39;
     */
    @Override // com.baidu.tieba.im.chat.bd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(ArrayList<String> arrayList) {
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        String str;
        String str2;
        String str3;
        boolean z;
        ArrayList arrayList5;
        TextView textView;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        MultiImageView multiImageView3;
        ArrayList<String> arrayList6;
        MultiImageView multiImageView4;
        int i;
        int i2;
        ArrayList arrayList7;
        String str4;
        ArrayList arrayList8;
        String str5;
        boolean z2;
        this.a.b = arrayList;
        arrayList2 = this.a.b;
        if (arrayList2 != null) {
            z2 = this.a.w;
        }
        this.a.b = new ArrayList();
        arrayList3 = this.a.b;
        if (arrayList3.isEmpty()) {
            str4 = this.a.r;
            if (!TextUtils.isEmpty(str4)) {
                arrayList8 = this.a.b;
                str5 = this.a.r;
                arrayList8.add(str5);
            }
        }
        arrayList4 = this.a.b;
        int size = arrayList4.size();
        if (size == 0) {
            this.a.finish();
            return;
        }
        StringBuilder sb = new StringBuilder("get img curUrl:");
        str = this.a.r;
        com.baidu.adp.lib.util.f.e(sb.append(str).toString());
        str2 = this.a.r;
        str3 = this.a.r;
        String substring = str2.substring(str3.lastIndexOf("/"));
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                z = false;
                break;
            }
            arrayList7 = this.a.b;
            String str6 = (String) arrayList7.get(i3);
            if (!TextUtils.isEmpty(str6)) {
                com.baidu.adp.lib.util.f.e("get img url :" + str6);
                String substring2 = str6.substring(str6.lastIndexOf("/"));
                if (!TextUtils.isEmpty(substring) && !TextUtils.isEmpty(substring2) && substring2.equals(substring)) {
                    com.baidu.adp.lib.util.f.e("get img idx:" + i3);
                    this.a.c = i3;
                    z = true;
                    break;
                }
            }
            i3++;
        }
        MsgImageActivity msgImageActivity = this.a;
        arrayList5 = this.a.b;
        msgImageActivity.q = arrayList5.size();
        if (!z) {
            MsgImageActivity msgImageActivity2 = this.a;
            i2 = this.a.q;
            msgImageActivity2.c = i2 - 1;
        }
        textView = this.a.h;
        textView.setVisibility(0);
        this.a.b();
        multiImageView = this.a.j;
        multiImageView.setIsFromCDN(true);
        multiImageView2 = this.a.j;
        multiImageView2.setAllowLocalUrl(true);
        multiImageView3 = this.a.j;
        arrayList6 = this.a.b;
        multiImageView3.setUrlData(arrayList6);
        multiImageView4 = this.a.j;
        i = this.a.c;
        multiImageView4.a(i, false);
    }
}
