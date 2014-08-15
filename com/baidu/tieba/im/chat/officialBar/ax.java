package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
/* loaded from: classes.dex */
class ax implements View.OnClickListener {
    final /* synthetic */ aw a;
    private final /* synthetic */ OfficialBarTipActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(aw awVar, OfficialBarTipActivity officialBarTipActivity) {
        this.a = awVar;
        this.b = officialBarTipActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.b.finish();
    }
}
