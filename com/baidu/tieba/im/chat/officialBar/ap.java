package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements View.OnClickListener {
    final /* synthetic */ ao aTG;
    private final /* synthetic */ OfficialBarTipActivity aTH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar, OfficialBarTipActivity officialBarTipActivity) {
        this.aTG = aoVar;
        this.aTH = officialBarTipActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aTH.finish();
    }
}
