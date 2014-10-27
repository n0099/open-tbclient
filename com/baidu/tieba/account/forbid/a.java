package com.baidu.tieba.account.forbid;

import android.view.View;
import android.widget.RadioGroup;
import com.baidu.tbadk.core.util.ay;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ ForbidActivity agi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForbidActivity forbidActivity) {
        this.agi = forbidActivity;
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
        eVar = this.agi.agg;
        if (eVar != null) {
            eVar2 = this.agi.agg;
            if (!ay.aA(eVar2.xs())) {
                ForbidActivity forbidActivity = this.agi;
                radioGroup = this.agi.agd;
                str = this.agi.mForumId;
                str2 = this.agi.mForumName;
                str3 = this.agi.mThreadId;
                str4 = this.agi.mUserName;
                eVar3 = this.agi.agg;
                h.a(str, str2, str3, str4, (String) forbidActivity.findViewById(radioGroup.getCheckedRadioButtonId()).getTag(), eVar3.xs(), new b(this));
            }
        }
    }
}
