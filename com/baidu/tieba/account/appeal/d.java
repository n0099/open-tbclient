package com.baidu.tieba.account.appeal;

import android.widget.TextView;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.account.appeal.g;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements g.b {
    final /* synthetic */ AppealActivity aWa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AppealActivity appealActivity) {
        this.aWa = appealActivity;
    }

    @Override // com.baidu.tieba.account.appeal.g.b
    public void a(ForbidReasonData forbidReasonData) {
        TextView textView;
        String str;
        TextView textView2;
        String string;
        textView = this.aWa.aVT;
        str = this.aWa.mUserName;
        textView.setText(str);
        textView2 = this.aWa.aVU;
        if (!au.isEmpty(forbidReasonData.reason)) {
            string = forbidReasonData.reason;
        } else {
            string = this.aWa.getPageContext().getString(w.l.default_forbid_reason);
        }
        textView2.setText(string);
    }

    @Override // com.baidu.tieba.account.appeal.g.b
    public void b(ForbidReasonData forbidReasonData) {
        this.aWa.showToast(forbidReasonData.error.errMsg);
    }
}
