package com.baidu.tieba.account.appeal;

import android.widget.TextView;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements l {
    final /* synthetic */ AppealActivity agb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AppealActivity appealActivity) {
        this.agb = appealActivity;
    }

    @Override // com.baidu.tieba.account.appeal.l
    public void a(ForbidReasonData forbidReasonData) {
        TextView textView;
        String str;
        TextView textView2;
        textView = this.agb.afU;
        str = this.agb.mUserName;
        textView.setText(str);
        textView2 = this.agb.afV;
        textView2.setText(!az.aA(forbidReasonData.reason) ? forbidReasonData.reason : this.agb.getString(y.default_forbid_reason));
    }

    @Override // com.baidu.tieba.account.appeal.l
    public void b(ForbidReasonData forbidReasonData) {
        this.agb.showToast(forbidReasonData.error.errMsg);
    }
}
