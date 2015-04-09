package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements View.OnClickListener {
    final /* synthetic */ ap aZZ;
    private final /* synthetic */ OfficialBarTipActivity baa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ap apVar, OfficialBarTipActivity officialBarTipActivity) {
        this.aZZ = apVar;
        this.baa = officialBarTipActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.baa.finish();
    }
}
