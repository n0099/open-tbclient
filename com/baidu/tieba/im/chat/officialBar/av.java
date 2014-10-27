package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnClickListener {
    final /* synthetic */ au aRZ;
    private final /* synthetic */ OfficialBarTipActivity aSa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(au auVar, OfficialBarTipActivity officialBarTipActivity) {
        this.aRZ = auVar;
        this.aSa = officialBarTipActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aSa.finish();
    }
}
