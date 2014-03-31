package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ba implements View.OnClickListener {
    final /* synthetic */ az a;
    private final /* synthetic */ OfficialBarTipActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(az azVar, OfficialBarTipActivity officialBarTipActivity) {
        this.a = azVar;
        this.b = officialBarTipActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.b.finish();
    }
}
