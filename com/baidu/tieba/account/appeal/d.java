package com.baidu.tieba.account.appeal;

import android.widget.TextView;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes.dex */
final class d implements l {
    final /* synthetic */ AppealActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AppealActivity appealActivity) {
        this.a = appealActivity;
    }

    @Override // com.baidu.tieba.account.appeal.l
    public final void a(ForbidReasonData forbidReasonData) {
        TextView textView;
        String str;
        TextView textView2;
        textView = this.a.b;
        str = this.a.h;
        textView.setText(str);
        textView2 = this.a.c;
        textView2.setText(!bc.c(forbidReasonData.reason) ? forbidReasonData.reason : this.a.getString(com.baidu.tieba.a.k.default_forbid_reason));
    }

    @Override // com.baidu.tieba.account.appeal.l
    public final void b(ForbidReasonData forbidReasonData) {
        this.a.showToast(forbidReasonData.error.b);
    }
}
