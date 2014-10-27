package com.baidu.tieba.bubble;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.adp.lib.guide.b {
    private final /* synthetic */ Activity Ft;
    private final /* synthetic */ boolean ajg;
    private final /* synthetic */ SpannableString ajh;
    private final /* synthetic */ int aji;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Activity activity, boolean z, SpannableString spannableString, int i) {
        this.Ft = activity;
        this.ajg = z;
        this.ajh = spannableString;
        this.aji = i;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        TextView textView = new TextView(this.Ft);
        if (this.ajg) {
            textView.setBackgroundResource(u.pop_float_top);
        } else {
            textView.setBackgroundResource(u.pop_float);
        }
        int dimensionPixelSize = this.Ft.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds32);
        int dimensionPixelSize2 = this.Ft.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds22);
        if (this.ajg) {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
        } else {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
        }
        textView.setGravity(17);
        textView.setText(this.ajh);
        textView.setCompoundDrawablePadding(dimensionPixelSize);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aw.getDrawable(this.aji), (Drawable) null);
        textView.setOnClickListener(new l(this, this.Ft));
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dy() {
        return this.ajg ? 4 : 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dz() {
        return this.ajg ? 32 : 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return this.ajg ? 0 : 20;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 5;
    }
}
