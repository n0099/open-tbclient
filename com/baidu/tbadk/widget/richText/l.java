package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l implements com.baidu.adp.lib.d.c<TextView> {
    final /* synthetic */ Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Context context) {
        this.a = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    /* renamed from: b */
    public TextView a() {
        com.baidu.adp.lib.g.e.d("pool make TextView");
        return new com.baidu.tbadk.widget.c(this.a);
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
