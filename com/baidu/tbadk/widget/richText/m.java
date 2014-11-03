package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.widget.TextView;
/* loaded from: classes.dex */
class m implements com.baidu.adp.lib.e.c<TextView> {
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Context context) {
        this.val$context = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: vY */
    public TextView ee() {
        return new com.baidu.tbadk.widget.q(this.val$context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: c */
    public void i(TextView textView) {
        textView.setText((CharSequence) null);
        textView.setTag(null);
        textView.setSingleLine(false);
        textView.setBackgroundResource(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: d */
    public TextView j(TextView textView) {
        return textView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: e */
    public TextView k(TextView textView) {
        textView.setText((CharSequence) null);
        textView.setTag(null);
        textView.setSingleLine(false);
        textView.setBackgroundResource(0);
        return textView;
    }
}
