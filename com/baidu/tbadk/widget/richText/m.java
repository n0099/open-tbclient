package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.widget.TextView;
/* loaded from: classes.dex */
class m implements com.baidu.adp.lib.d.c<TextView> {
    private final /* synthetic */ Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Context context) {
        this.a = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    /* renamed from: b */
    public TextView a() {
        return new com.baidu.tbadk.widget.l(this.a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public void a(TextView textView) {
        textView.setText((CharSequence) null);
        textView.setTag(null);
        textView.setSingleLine(false);
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
        textView.setSingleLine(false);
        textView.setBackgroundResource(0);
        return textView;
    }
}
