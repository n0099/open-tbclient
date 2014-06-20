package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import com.baidu.tbadk.core.util.bk;
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
        c cVar3;
        c cVar4;
        Context context2;
        String str6;
        button = this.a.e;
        if (view != button) {
            str = this.a.c;
            if (!TextUtils.isEmpty(str)) {
                context = this.a.f;
                str4 = this.a.c;
                com.baidu.tbadk.core.f.a(context, str4);
            }
            cVar = this.a.k;
            if (cVar == null) {
                str2 = this.a.j;
                if (!TextUtils.isEmpty(str2)) {
                    bk a = bk.a();
                    Context context3 = this.a.getContext();
                    str3 = this.a.j;
                    a.a(context3, new String[]{str3});
                    return;
                }
                return;
            }
            cVar2 = this.a.k;
            cVar2.a();
            return;
        }
        str5 = this.a.d;
        if (!TextUtils.isEmpty(str5)) {
            context2 = this.a.f;
            str6 = this.a.d;
            com.baidu.tbadk.core.f.a(context2, str6);
        }
        this.a.h = true;
        this.a.setVisibility(8);
        cVar3 = this.a.k;
        if (cVar3 != null) {
            cVar4 = this.a.k;
            cVar4.b();
        }
    }
}
