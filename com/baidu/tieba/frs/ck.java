package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import android.text.Html;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ck implements Html.ImageGetter {
    final /* synthetic */ cd bdg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(cd cdVar) {
        this.bdg = cdVar;
    }

    @Override // android.text.Html.ImageGetter
    public Drawable getDrawable(String str) {
        Drawable drawable = this.bdg.baC.getResources().getDrawable(Integer.parseInt(str));
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        return drawable;
    }
}
