package com.baidu.tieba.account.forbid;

import android.view.View;
import android.widget.RadioGroup;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ ForbidActivity anH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForbidActivity forbidActivity) {
        this.anH = forbidActivity;
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
        eVar = this.anH.anF;
        if (eVar != null) {
            eVar2 = this.anH.anF;
            if (!ba.isEmpty(eVar2.AN())) {
                ForbidActivity forbidActivity = this.anH;
                radioGroup = this.anH.anC;
                str = this.anH.mForumId;
                str2 = this.anH.mForumName;
                str3 = this.anH.mThreadId;
                str4 = this.anH.mUserName;
                eVar3 = this.anH.anF;
                h.a(str, str2, str3, str4, (String) forbidActivity.findViewById(radioGroup.getCheckedRadioButtonId()).getTag(), eVar3.AN(), new b(this));
            }
        }
    }
}
