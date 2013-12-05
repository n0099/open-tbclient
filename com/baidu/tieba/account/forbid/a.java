package com.baidu.tieba.account.forbid;

import android.widget.RadioGroup;
/* loaded from: classes.dex */
class a implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForbidActivity f1080a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForbidActivity forbidActivity) {
        this.f1080a = forbidActivity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        RadioGroup radioGroup2;
        ForbidActivity forbidActivity = this.f1080a;
        radioGroup2 = this.f1080a.b;
        forbidActivity.a(radioGroup2.getCheckedRadioButtonId());
    }
}
