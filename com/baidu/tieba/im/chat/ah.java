package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tieba.view.MultiImageView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements y {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgImageActivity f1503a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(MsgImageActivity msgImageActivity) {
        this.f1503a = msgImageActivity;
    }

    @Override // com.baidu.tieba.im.chat.y
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
        this.f1503a.b = arrayList;
        arrayList2 = this.f1503a.b;
        if (arrayList2 == null) {
            this.f1503a.b = new ArrayList();
        }
        arrayList3 = this.f1503a.b;
        if (arrayList3.isEmpty()) {
            str4 = this.f1503a.q;
            if (!TextUtils.isEmpty(str4)) {
                arrayList8 = this.f1503a.b;
                str5 = this.f1503a.q;
                arrayList8.add(str5);
            }
        }
        arrayList4 = this.f1503a.b;
        int size = arrayList4.size();
        if (size == 0) {
            this.f1503a.finish();
            return;
        }
        StringBuilder append = new StringBuilder().append("get img curUrl:");
        str = this.f1503a.q;
        com.baidu.adp.lib.h.d.d(append.append(str).toString());
        str2 = this.f1503a.q;
        str3 = this.f1503a.q;
        String substring = str2.substring(str3.lastIndexOf("/"));
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                z = false;
                break;
            }
            arrayList7 = this.f1503a.b;
            String str6 = (String) arrayList7.get(i3);
            if (!TextUtils.isEmpty(str6)) {
                com.baidu.adp.lib.h.d.d("get img url :" + str6);
                String substring2 = str6.substring(str6.lastIndexOf("/"));
                if (!TextUtils.isEmpty(substring) && !TextUtils.isEmpty(substring2) && substring2.equals(substring)) {
                    com.baidu.adp.lib.h.d.d("get img idx:" + i3);
                    this.f1503a.c = i3;
                    z = true;
                    break;
                }
            }
            i3++;
        }
        MsgImageActivity msgImageActivity = this.f1503a;
        arrayList5 = this.f1503a.b;
        msgImageActivity.p = arrayList5.size();
        if (!z) {
            MsgImageActivity msgImageActivity2 = this.f1503a;
            i2 = this.f1503a.p;
            msgImageActivity2.c = i2 - 1;
        }
        textView = this.f1503a.g;
        textView.setVisibility(0);
        this.f1503a.b();
        multiImageView = this.f1503a.i;
        multiImageView.setIsFromCDN(true);
        multiImageView2 = this.f1503a.i;
        multiImageView2.setAllowLocalUrl(true);
        multiImageView3 = this.f1503a.i;
        arrayList6 = this.f1503a.b;
        multiImageView3.setUrlData(arrayList6);
        multiImageView4 = this.f1503a.i;
        i = this.f1503a.c;
        multiImageView4.a(i, false);
    }
}
