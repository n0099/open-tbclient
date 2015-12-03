package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbListTextView;
/* loaded from: classes.dex */
class q implements com.baidu.adp.lib.f.c<TextView> {
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(Context context) {
        this.val$context = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: Gr */
    public TextView hc() {
        return new TbListTextView(this.val$context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: d */
    public void l(TextView textView) {
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
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: e */
    public TextView m(TextView textView) {
        return textView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: f */
    public TextView n(TextView textView) {
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
