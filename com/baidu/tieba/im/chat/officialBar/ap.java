package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements View.OnClickListener {
    final /* synthetic */ ao aUV;
    private final /* synthetic */ OfficialBarTipActivity aUW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar, OfficialBarTipActivity officialBarTipActivity) {
        this.aUV = aoVar;
        this.aUW = officialBarTipActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aUW.finish();
    }
}
