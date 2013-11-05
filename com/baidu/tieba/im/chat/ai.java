package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tieba.view.MultiImageView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements z {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgImageActivity f1411a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(MsgImageActivity msgImageActivity) {
        this.f1411a = msgImageActivity;
    }

    @Override // com.baidu.tieba.im.chat.z
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
        this.f1411a.b = arrayList;
        arrayList2 = this.f1411a.b;
        if (arrayList2 == null) {
            this.f1411a.b = new ArrayList();
        }
        arrayList3 = this.f1411a.b;
        if (arrayList3.isEmpty()) {
            str4 = this.f1411a.s;
            if (!TextUtils.isEmpty(str4)) {
                arrayList8 = this.f1411a.b;
                str5 = this.f1411a.s;
                arrayList8.add(str5);
            }
        }
        arrayList4 = this.f1411a.b;
        int size = arrayList4.size();
        if (size == 0) {
            this.f1411a.finish();
            return;
        }
        StringBuilder append = new StringBuilder().append("get img curUrl:");
        str = this.f1411a.s;
        com.baidu.adp.lib.h.d.d(append.append(str).toString());
        str2 = this.f1411a.s;
        str3 = this.f1411a.s;
        String substring = str2.substring(str3.lastIndexOf("/"));
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                z = false;
                break;
            }
            arrayList7 = this.f1411a.b;
            String str6 = (String) arrayList7.get(i3);
            if (!TextUtils.isEmpty(str6)) {
                com.baidu.adp.lib.h.d.d("get img url :" + str6);
                String substring2 = str6.substring(str6.lastIndexOf("/"));
                if (!TextUtils.isEmpty(substring) && !TextUtils.isEmpty(substring2) && substring2.equals(substring)) {
                    com.baidu.adp.lib.h.d.d("get img idx:" + i3);
                    this.f1411a.c = i3;
                    z = true;
                    break;
                }
            }
            i3++;
        }
        MsgImageActivity msgImageActivity = this.f1411a;
        arrayList5 = this.f1411a.b;
        msgImageActivity.r = arrayList5.size();
        if (!z) {
            MsgImageActivity msgImageActivity2 = this.f1411a;
            i2 = this.f1411a.r;
            msgImageActivity2.c = i2 - 1;
        }
        textView = this.f1411a.g;
        textView.setVisibility(0);
        this.f1411a.c();
        multiImageView = this.f1411a.k;
        multiImageView.setLoadFromCDN(true);
        multiImageView2 = this.f1411a.k;
        multiImageView2.setAllowLocalUrl(true);
        multiImageView3 = this.f1411a.k;
        arrayList6 = this.f1411a.b;
        multiImageView3.setUrlData(arrayList6);
        multiImageView4 = this.f1411a.k;
        i = this.f1411a.c;
        multiImageView4.a(i, false);
    }
}
