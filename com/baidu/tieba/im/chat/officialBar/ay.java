package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements View.OnClickListener {
    final /* synthetic */ ax a;
    private final /* synthetic */ OfficialBarTipActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ax axVar, OfficialBarTipActivity officialBarTipActivity) {
        this.a = axVar;
        this.b = officialBarTipActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.b.finish();
    }
}
