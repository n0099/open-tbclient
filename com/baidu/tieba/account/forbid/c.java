package com.baidu.tieba.account.forbid;

import android.view.View;
import android.widget.RadioGroup;
import com.baidu.tieba.util.bu;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ ForbidActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ForbidActivity forbidActivity) {
        this.a = forbidActivity;
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
        eVar = this.a.j;
        if (eVar != null) {
            eVar2 = this.a.j;
            if (!bu.c(eVar2.a())) {
                ForbidActivity forbidActivity = this.a;
                radioGroup = this.a.b;
                String str5 = (String) forbidActivity.findViewById(radioGroup.getCheckedRadioButtonId()).getTag();
                str = this.a.c;
                str2 = this.a.d;
                str3 = this.a.e;
                str4 = this.a.g;
                eVar3 = this.a.j;
                h.a(str, str2, str3, str4, str5, eVar3.a(), new d(this));
            }
        }
    }
}
