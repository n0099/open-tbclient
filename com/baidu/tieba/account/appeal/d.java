package com.baidu.tieba.account.appeal;

import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.account.appeal.g;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements g.b {
    final /* synthetic */ AppealActivity aEm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AppealActivity appealActivity) {
        this.aEm = appealActivity;
    }

    @Override // com.baidu.tieba.account.appeal.g.b
    public void a(ForbidReasonData forbidReasonData) {
        TextView textView;
        String str;
        TextView textView2;
        String string;
        textView = this.aEm.aEf;
        str = this.aEm.mUserName;
        textView.setText(str);
        textView2 = this.aEm.aEg;
        if (!as.isEmpty(forbidReasonData.reason)) {
            string = forbidReasonData.reason;
        } else {
            string = this.aEm.getPageContext().getString(i.h.default_forbid_reason);
        }
        textView2.setText(string);
    }

    @Override // com.baidu.tieba.account.appeal.g.b
    public void b(ForbidReasonData forbidReasonData) {
        this.aEm.showToast(forbidReasonData.error.errMsg);
    }
}
