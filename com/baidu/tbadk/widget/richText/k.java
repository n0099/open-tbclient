package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k implements com.baidu.adp.lib.d.c<TextView> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f997a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context) {
        this.f997a = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    /* renamed from: b */
    public TextView a() {
        com.baidu.adp.lib.h.e.d("pool make TextView");
        return new com.baidu.tbadk.widget.c(this.f997a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public void a(TextView textView) {
        textView.setText((CharSequence) null);
        textView.setTag(null);
        textView.setBackgroundResource(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public TextView b(TextView textView) {
        return textView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public TextView c(TextView textView) {
        textView.setText((CharSequence) null);
        textView.setTag(null);
        textView.setBackgroundResource(0);
        return textView;
    }
}
