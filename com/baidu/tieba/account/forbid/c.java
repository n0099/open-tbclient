package com.baidu.tieba.account.forbid;

import android.widget.RadioGroup;
/* loaded from: classes.dex */
final class c implements RadioGroup.OnCheckedChangeListener {
    final /* synthetic */ ForbidActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ForbidActivity forbidActivity) {
        this.a = forbidActivity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        RadioGroup radioGroup2;
        ForbidActivity forbidActivity = this.a;
        radioGroup2 = this.a.b;
        ForbidActivity.a(forbidActivity, radioGroup2.getCheckedRadioButtonId());
    }
}
