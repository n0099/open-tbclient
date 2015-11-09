package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import android.text.Html;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz implements Html.ImageGetter {
    final /* synthetic */ bs aXm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(bs bsVar) {
        this.aXm = bsVar;
    }

    @Override // android.text.Html.ImageGetter
    public Drawable getDrawable(String str) {
        Drawable drawable = this.aXm.aVn.getResources().getDrawable(Integer.parseInt(str));
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        return drawable;
    }
}
