package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.widget.TextView;
/* loaded from: classes.dex */
final class l implements com.baidu.adp.lib.d.c<TextView> {
    private final /* synthetic */ Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Context context) {
        this.a = context;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.adp.lib.d.c
    public final /* synthetic */ TextView a() {
        com.baidu.adp.lib.util.f.e("pool make TextView");
        return new com.baidu.tbadk.widget.l(this.a);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.adp.lib.d.c
    public final /* synthetic */ void a(TextView textView) {
        TextView textView2 = textView;
        textView2.setText((CharSequence) null);
        textView2.setTag(null);
        textView2.setBackgroundResource(0);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.adp.lib.d.c
    public final /* bridge */ /* synthetic */ TextView b(TextView textView) {
        return textView;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.adp.lib.d.c
    public final /* synthetic */ TextView c(TextView textView) {
        TextView textView2 = textView;
        textView2.setText((CharSequence) null);
        textView2.setTag(null);
        textView2.setBackgroundResource(0);
        return textView2;
    }
}
