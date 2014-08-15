package com.baidu.tieba.bubble;

import android.app.Activity;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.adp.lib.guide.b {
    private final /* synthetic */ Activity a;
    private final /* synthetic */ boolean b;
    private final /* synthetic */ SpannableString c;
    private final /* synthetic */ int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Activity activity, boolean z, SpannableString spannableString, int i) {
        this.a = activity;
        this.b = z;
        this.c = spannableString;
        this.d = i;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        TextView textView = new TextView(this.a);
        if (this.b) {
            textView.setBackgroundResource(com.baidu.tieba.t.pop_float_top);
        } else {
            textView.setBackgroundResource(com.baidu.tieba.t.pop_float);
        }
        int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.s.ds32);
        int dimensionPixelSize2 = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.s.ds22);
        if (this.b) {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
        } else {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
        }
        textView.setGravity(17);
        textView.setText(this.c);
        textView.setCompoundDrawablePadding(dimensionPixelSize);
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.d, 0);
        textView.setOnClickListener(new l(this, this.a));
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int a() {
        return this.b ? 4 : 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int b() {
        return this.b ? 32 : 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int c() {
        return this.b ? 0 : 20;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int d() {
        return 5;
    }
}
