package com.baidu.tieba.home;

import android.view.View;
/* loaded from: classes.dex */
class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CreateBarSuccessActivity f1182a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(CreateBarSuccessActivity createBarSuccessActivity) {
        this.f1182a = createBarSuccessActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1182a.finish();
    }
}
