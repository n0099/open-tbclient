package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import com.baidu.tbadk.core.util.bi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ BannerView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BannerView bannerView) {
        this.a = bannerView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        String str;
        c cVar;
        c cVar2;
        String str2;
        String str3;
        Context context;
        String str4;
        String str5;
        String str6;
        c cVar3;
        c cVar4;
        String str7;
        Context context2;
        String str8;
        button = this.a.f;
        if (view != button) {
            str = this.a.c;
            if (!TextUtils.isEmpty(str)) {
                context = this.a.g;
                str4 = this.a.c;
                com.baidu.tbadk.core.g.a(context, str4);
            }
            cVar = this.a.l;
            if (cVar == null) {
                str2 = this.a.k;
                if (!TextUtils.isEmpty(str2)) {
                    bi a = bi.a();
                    Context context3 = this.a.getContext();
                    str3 = this.a.k;
                    a.a(context3, new String[]{str3});
                    return;
                }
                return;
            }
            cVar2 = this.a.l;
            cVar2.a();
            return;
        }
        str5 = this.a.d;
        if (!TextUtils.isEmpty(str5)) {
            context2 = this.a.g;
            str8 = this.a.d;
            com.baidu.tbadk.core.g.a(context2, str8);
        }
        this.a.i = true;
        this.a.setVisibility(8);
        str6 = this.a.e;
        if (!TextUtils.isEmpty(str6)) {
            com.baidu.tbadk.f a2 = com.baidu.tbadk.f.a();
            str7 = this.a.e;
            a2.b(str7, System.currentTimeMillis());
        }
        cVar3 = this.a.l;
        if (cVar3 != null) {
            cVar4 = this.a.l;
            cVar4.b();
        }
    }
}
