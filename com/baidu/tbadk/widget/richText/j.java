package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.widget.TextView;
/* loaded from: classes.dex */
final class j implements com.baidu.adp.lib.d.c<TextView> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f975a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context) {
        this.f975a = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    /* renamed from: b */
    public TextView a() {
        com.baidu.adp.lib.h.d.d("pool make TextView");
        return new com.baidu.tbadk.widget.a(this.f975a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public void a(TextView textView) {
        textView.setText((CharSequence) null);
        textView.setTag(null);
        textView.setBackgroundDrawable(null);
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
        textView.setBackgroundDrawable(null);
        return textView;
    }
}
