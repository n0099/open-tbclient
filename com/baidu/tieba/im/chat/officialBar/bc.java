package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements View.OnClickListener {
    final /* synthetic */ bb a;
    private final /* synthetic */ OfficialBarTipActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar, OfficialBarTipActivity officialBarTipActivity) {
        this.a = bbVar;
        this.b = officialBarTipActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.b.finish();
    }
}
