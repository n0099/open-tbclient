package com.baidu.tieba.account;

import android.view.View;
/* loaded from: classes.dex */
class am implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginActivity f1049a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ReLoginActivity reLoginActivity) {
        this.f1049a = reLoginActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1049a.finish();
    }
}
