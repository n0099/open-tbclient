package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tieba.view.MultiImageView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements ab {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgImageActivity f1544a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(MsgImageActivity msgImageActivity) {
        this.f1544a = msgImageActivity;
    }

    @Override // com.baidu.tieba.im.chat.ab
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
        this.f1544a.b = arrayList;
        arrayList2 = this.f1544a.b;
        if (arrayList2 == null) {
            this.f1544a.b = new ArrayList();
        }
        arrayList3 = this.f1544a.b;
        if (arrayList3.isEmpty()) {
            str4 = this.f1544a.r;
            if (!TextUtils.isEmpty(str4)) {
                arrayList8 = this.f1544a.b;
                str5 = this.f1544a.r;
                arrayList8.add(str5);
            }
        }
        arrayList4 = this.f1544a.b;
        int size = arrayList4.size();
        if (size == 0) {
            this.f1544a.finish();
            return;
        }
        StringBuilder append = new StringBuilder().append("get img curUrl:");
        str = this.f1544a.r;
        com.baidu.adp.lib.h.e.d(append.append(str).toString());
        str2 = this.f1544a.r;
        str3 = this.f1544a.r;
        String substring = str2.substring(str3.lastIndexOf("/"));
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                z = false;
                break;
            }
            arrayList7 = this.f1544a.b;
            String str6 = (String) arrayList7.get(i3);
            if (!TextUtils.isEmpty(str6)) {
                com.baidu.adp.lib.h.e.d("get img url :" + str6);
                String substring2 = str6.substring(str6.lastIndexOf("/"));
                if (!TextUtils.isEmpty(substring) && !TextUtils.isEmpty(substring2) && substring2.equals(substring)) {
                    com.baidu.adp.lib.h.e.d("get img idx:" + i3);
                    this.f1544a.c = i3;
                    z = true;
                    break;
                }
            }
            i3++;
        }
        MsgImageActivity msgImageActivity = this.f1544a;
        arrayList5 = this.f1544a.b;
        msgImageActivity.q = arrayList5.size();
        if (!z) {
            MsgImageActivity msgImageActivity2 = this.f1544a;
            i2 = this.f1544a.q;
            msgImageActivity2.c = i2 - 1;
        }
        textView = this.f1544a.h;
        textView.setVisibility(0);
        this.f1544a.b();
        multiImageView = this.f1544a.j;
        multiImageView.setIsFromCDN(true);
        multiImageView2 = this.f1544a.j;
        multiImageView2.setAllowLocalUrl(true);
        multiImageView3 = this.f1544a.j;
        arrayList6 = this.f1544a.b;
        multiImageView3.setUrlData(arrayList6);
        multiImageView4 = this.f1544a.j;
        i = this.f1544a.c;
        multiImageView4.a(i, false);
    }
}
