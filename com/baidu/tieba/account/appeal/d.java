package com.baidu.tieba.account.appeal;

import android.widget.TextView;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.account.appeal.g;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements g.b {
    final /* synthetic */ AppealActivity aIN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AppealActivity appealActivity) {
        this.aIN = appealActivity;
    }

    @Override // com.baidu.tieba.account.appeal.g.b
    public void a(ForbidReasonData forbidReasonData) {
        TextView textView;
        String str;
        TextView textView2;
        String string;
        textView = this.aIN.aIG;
        str = this.aIN.mUserName;
        textView.setText(str);
        textView2 = this.aIN.aIH;
        if (!ax.isEmpty(forbidReasonData.reason)) {
            string = forbidReasonData.reason;
        } else {
            string = this.aIN.getPageContext().getString(n.j.default_forbid_reason);
        }
        textView2.setText(string);
    }

    @Override // com.baidu.tieba.account.appeal.g.b
    public void b(ForbidReasonData forbidReasonData) {
        this.aIN.showToast(forbidReasonData.error.errMsg);
    }
}
