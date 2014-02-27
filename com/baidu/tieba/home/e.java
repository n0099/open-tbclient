package com.baidu.tieba.home;

import android.view.View;
/* loaded from: classes.dex */
final class e implements View.OnClickListener {
    final /* synthetic */ CreateBarSuccessActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(CreateBarSuccessActivity createBarSuccessActivity) {
        this.a = createBarSuccessActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.finish();
    }
}
