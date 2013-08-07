package com.baidu.tieba.home;

import android.view.View;
/* loaded from: classes.dex */
class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CreateBarSuccessActivity f1148a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(CreateBarSuccessActivity createBarSuccessActivity) {
        this.f1148a = createBarSuccessActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1148a.finish();
    }
}
