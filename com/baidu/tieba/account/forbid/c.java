package com.baidu.tieba.account.forbid;

import android.view.View;
import android.widget.RadioGroup;
import com.baidu.tieba.util.bb;
/* loaded from: classes.dex */
class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForbidActivity f1082a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ForbidActivity forbidActivity) {
        this.f1082a = forbidActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e eVar;
        e eVar2;
        RadioGroup radioGroup;
        String str;
        String str2;
        String str3;
        String str4;
        e eVar3;
        eVar = this.f1082a.j;
        if (eVar != null) {
            eVar2 = this.f1082a.j;
            if (!bb.c(eVar2.a())) {
                ForbidActivity forbidActivity = this.f1082a;
                radioGroup = this.f1082a.b;
                String str5 = (String) forbidActivity.findViewById(radioGroup.getCheckedRadioButtonId()).getTag();
                str = this.f1082a.c;
                str2 = this.f1082a.d;
                str3 = this.f1082a.e;
                str4 = this.f1082a.g;
                eVar3 = this.f1082a.j;
                h.a(str, str2, str3, str4, str5, eVar3.a(), new d(this));
            }
        }
    }
}
