package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements View.OnClickListener {
    final /* synthetic */ ao aUW;
    private final /* synthetic */ OfficialBarTipActivity aUX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar, OfficialBarTipActivity officialBarTipActivity) {
        this.aUW = aoVar;
        this.aUX = officialBarTipActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aUX.finish();
    }
}
