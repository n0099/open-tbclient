package com.baidu.tieba.account.forbid;

import android.widget.RadioGroup;
/* loaded from: classes.dex */
class a implements RadioGroup.OnCheckedChangeListener {
    final /* synthetic */ ForbidActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForbidActivity forbidActivity) {
        this.a = forbidActivity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        RadioGroup radioGroup2;
        ForbidActivity forbidActivity = this.a;
        radioGroup2 = this.a.b;
        forbidActivity.a(radioGroup2.getCheckedRadioButtonId());
    }
}
