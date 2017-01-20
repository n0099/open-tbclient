package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbListTextView;
/* loaded from: classes.dex */
class l implements com.baidu.adp.lib.e.c<TextView> {
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Context context) {
        this.val$context = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: Ig */
    public TextView ex() {
        return new TbListTextView(this.val$context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: c */
    public void o(TextView textView) {
        textView.setText((CharSequence) null);
        textView.setTag(null);
        textView.setSingleLine(false);
        textView.setEllipsize(null);
        textView.setBackgroundResource(0);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setTextColor(0);
        textView.setGravity(3);
        textView.setOnClickListener(null);
        textView.setOnTouchListener(null);
        if (textView instanceof TbListTextView) {
            ((TbListTextView) textView).setCheckSelection(true);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: d */
    public TextView p(TextView textView) {
        return textView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: e */
    public TextView q(TextView textView) {
        textView.setText((CharSequence) null);
        textView.setTag(null);
        textView.setSingleLine(false);
        textView.setEllipsize(null);
        textView.setBackgroundResource(0);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setTextColor(0);
        textView.setGravity(3);
        textView.setOnClickListener(null);
        textView.setOnTouchListener(null);
        if (textView instanceof TbListTextView) {
            ((TbListTextView) textView).setCheckSelection(true);
        }
        return textView;
    }
}
