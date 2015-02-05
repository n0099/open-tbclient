package com.baidu.tieba.account.forbid;

import android.view.View;
import android.widget.RadioGroup;
import com.baidu.tbadk.core.util.bf;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ ForbidActivity aoz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForbidActivity forbidActivity) {
        this.aoz = forbidActivity;
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
        eVar = this.aoz.aox;
        if (eVar != null) {
            eVar2 = this.aoz.aox;
            if (!bf.isEmpty(eVar2.Bh())) {
                ForbidActivity forbidActivity = this.aoz;
                radioGroup = this.aoz.aou;
                str = this.aoz.mForumId;
                str2 = this.aoz.mForumName;
                str3 = this.aoz.mThreadId;
                str4 = this.aoz.mUserName;
                str5 = this.aoz.mPostId;
                eVar3 = this.aoz.aox;
                h.a(str, str2, str3, str4, str5, (String) forbidActivity.findViewById(radioGroup.getCheckedRadioButtonId()).getTag(), eVar3.Bh(), new b(this));
            }
        }
    }
}
