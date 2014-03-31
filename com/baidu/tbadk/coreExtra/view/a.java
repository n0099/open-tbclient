package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import com.baidu.tbadk.core.util.bg;
/* loaded from: classes.dex */
final class a implements View.OnClickListener {
    final /* synthetic */ BannerView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BannerView bannerView) {
        this.a = bannerView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Button button;
        String str;
        String str2;
        Context context;
        String str3;
        String str4;
        String str5;
        String str6;
        Context context2;
        String str7;
        button = this.a.e;
        if (view != button) {
            str = this.a.b;
            if (!TextUtils.isEmpty(str)) {
                context = this.a.f;
                str3 = this.a.b;
                com.baidu.tbadk.core.g.a(context, str3);
            }
            bg a = bg.a();
            Context context3 = this.a.getContext();
            str2 = this.a.j;
            a.a(context3, new String[]{str2});
            return;
        }
        str4 = this.a.c;
        if (!TextUtils.isEmpty(str4)) {
            context2 = this.a.f;
            str7 = this.a.c;
            com.baidu.tbadk.core.g.a(context2, str7);
        }
        this.a.h = true;
        this.a.setVisibility(8);
        str5 = this.a.d;
        if (!TextUtils.isEmpty(str5)) {
            com.baidu.tbadk.s.a();
            str6 = this.a.d;
            com.baidu.tbadk.s.b(str6, System.currentTimeMillis());
        }
    }
}
