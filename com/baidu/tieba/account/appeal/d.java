package com.baidu.tieba.account.appeal;

import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.account.appeal.g;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements g.b {
    final /* synthetic */ AppealActivity aMv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AppealActivity appealActivity) {
        this.aMv = appealActivity;
    }

    @Override // com.baidu.tieba.account.appeal.g.b
    public void a(ForbidReasonData forbidReasonData) {
        TextView textView;
        String str;
        TextView textView2;
        String string;
        textView = this.aMv.aMo;
        str = this.aMv.mUserName;
        textView.setText(str);
        textView2 = this.aMv.aMp;
        if (!ba.isEmpty(forbidReasonData.reason)) {
            string = forbidReasonData.reason;
        } else {
            string = this.aMv.getPageContext().getString(u.j.default_forbid_reason);
        }
        textView2.setText(string);
    }

    @Override // com.baidu.tieba.account.appeal.g.b
    public void b(ForbidReasonData forbidReasonData) {
        this.aMv.showToast(forbidReasonData.error.errMsg);
    }
}
