package com.baidu.tieba;

import android.view.View;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LabelActivity f839a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(LabelActivity labelActivity) {
        this.f839a = labelActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f839a.b();
    }
}
