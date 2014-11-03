package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnClickListener {
    final /* synthetic */ au aSn;
    private final /* synthetic */ OfficialBarTipActivity aSo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(au auVar, OfficialBarTipActivity officialBarTipActivity) {
        this.aSn = auVar;
        this.aSo = officialBarTipActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aSo.finish();
    }
}
