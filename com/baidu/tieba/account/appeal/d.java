package com.baidu.tieba.account.appeal;

import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.account.appeal.g;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements g.b {
    final /* synthetic */ AppealActivity aFh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AppealActivity appealActivity) {
        this.aFh = appealActivity;
    }

    @Override // com.baidu.tieba.account.appeal.g.b
    public void a(ForbidReasonData forbidReasonData) {
        TextView textView;
        String str;
        TextView textView2;
        String string;
        textView = this.aFh.aFa;
        str = this.aFh.aiq;
        textView.setText(str);
        textView2 = this.aFh.aFb;
        if (!ar.isEmpty(forbidReasonData.reason)) {
            string = forbidReasonData.reason;
        } else {
            string = this.aFh.getPageContext().getString(i.h.default_forbid_reason);
        }
        textView2.setText(string);
    }

    @Override // com.baidu.tieba.account.appeal.g.b
    public void b(ForbidReasonData forbidReasonData) {
        this.aFh.showToast(forbidReasonData.error.errMsg);
    }
}
