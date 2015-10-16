package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import android.text.Html;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz implements Html.ImageGetter {
    final /* synthetic */ bs aXd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(bs bsVar) {
        this.aXd = bsVar;
    }

    @Override // android.text.Html.ImageGetter
    public Drawable getDrawable(String str) {
        Drawable drawable = this.aXd.aVf.getResources().getDrawable(Integer.parseInt(str));
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        return drawable;
    }
}
