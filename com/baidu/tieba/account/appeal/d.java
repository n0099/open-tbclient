package com.baidu.tieba.account.appeal;

import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements l {
    final /* synthetic */ AppealActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AppealActivity appealActivity) {
        this.a = appealActivity;
    }

    @Override // com.baidu.tieba.account.appeal.l
    public void a(ForbidReasonData forbidReasonData) {
        TextView textView;
        String str;
        TextView textView2;
        textView = this.a.b;
        str = this.a.h;
        textView.setText(str);
        textView2 = this.a.c;
        textView2.setText(!ba.c(forbidReasonData.reason) ? forbidReasonData.reason : this.a.getString(x.default_forbid_reason));
    }

    @Override // com.baidu.tieba.account.appeal.l
    public void b(ForbidReasonData forbidReasonData) {
        this.a.showToast(forbidReasonData.error.b);
    }
}
