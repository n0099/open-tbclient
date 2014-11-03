package com.baidu.tieba.account.forbid;

import android.view.View;
import android.widget.RadioGroup;
import com.baidu.tbadk.core.util.az;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ ForbidActivity agq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForbidActivity forbidActivity) {
        this.agq = forbidActivity;
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
        eVar = this.agq.ago;
        if (eVar != null) {
            eVar2 = this.agq.ago;
            if (!az.aA(eVar2.xu())) {
                ForbidActivity forbidActivity = this.agq;
                radioGroup = this.agq.agl;
                str = this.agq.mForumId;
                str2 = this.agq.mForumName;
                str3 = this.agq.mThreadId;
                str4 = this.agq.mUserName;
                eVar3 = this.agq.ago;
                h.a(str, str2, str3, str4, (String) forbidActivity.findViewById(radioGroup.getCheckedRadioButtonId()).getTag(), eVar3.xu(), new b(this));
            }
        }
    }
}
