package com.baidu.tieba.account.appeal;

import android.widget.TextView;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements l {
    final /* synthetic */ AppealActivity awm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AppealActivity appealActivity) {
        this.awm = appealActivity;
    }

    @Override // com.baidu.tieba.account.appeal.l
    public void a(ForbidReasonData forbidReasonData) {
        TextView textView;
        String str;
        TextView textView2;
        String string;
        textView = this.awm.awf;
        str = this.awm.acM;
        textView.setText(str);
        textView2 = this.awm.awg;
        if (!bd.isEmpty(forbidReasonData.reason)) {
            string = forbidReasonData.reason;
        } else {
            string = this.awm.getPageContext().getString(y.default_forbid_reason);
        }
        textView2.setText(string);
    }

    @Override // com.baidu.tieba.account.appeal.l
    public void b(ForbidReasonData forbidReasonData) {
        this.awm.showToast(forbidReasonData.error.errMsg);
    }
}
