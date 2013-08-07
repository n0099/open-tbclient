package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.widget.TextView;
/* loaded from: classes.dex */
class j implements com.baidu.adp.lib.a.c {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Context f811a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context) {
        this.f811a = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.a.c
    /* renamed from: b */
    public TextView a() {
        com.baidu.adp.lib.e.d.c("pool make TextView");
        return new com.baidu.tbadk.widget.a(this.f811a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.a.c
    public void a(TextView textView) {
        textView.setText((CharSequence) null);
        textView.setTag(null);
        textView.setBackgroundResource(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.a.c
    public TextView b(TextView textView) {
        return textView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.a.c
    public TextView c(TextView textView) {
        textView.setText((CharSequence) null);
        textView.setTag(null);
        textView.setBackgroundResource(0);
        return textView;
    }
}
