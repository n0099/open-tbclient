package com.baidu.tieba.account.forbid;

import android.view.View;
import android.widget.RadioGroup;
import com.baidu.tbadk.core.util.bf;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ ForbidActivity aoC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForbidActivity forbidActivity) {
        this.aoC = forbidActivity;
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
        String str5;
        e eVar3;
        eVar = this.aoC.aoA;
        if (eVar != null) {
            eVar2 = this.aoC.aoA;
            if (!bf.isEmpty(eVar2.Bn())) {
                ForbidActivity forbidActivity = this.aoC;
                radioGroup = this.aoC.aox;
                str = this.aoC.mForumId;
                str2 = this.aoC.mForumName;
                str3 = this.aoC.mThreadId;
                str4 = this.aoC.mUserName;
                str5 = this.aoC.mPostId;
                eVar3 = this.aoC.aoA;
                h.a(str, str2, str3, str4, str5, (String) forbidActivity.findViewById(radioGroup.getCheckedRadioButtonId()).getTag(), eVar3.Bn(), new b(this));
            }
        }
    }
}
