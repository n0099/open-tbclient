package com.baidu.tieba.account.appeal;

import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements l {
    final /* synthetic */ AppealActivity ans;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AppealActivity appealActivity) {
        this.ans = appealActivity;
    }

    @Override // com.baidu.tieba.account.appeal.l
    public void a(ForbidReasonData forbidReasonData) {
        TextView textView;
        String str;
        TextView textView2;
        textView = this.ans.anl;
        str = this.ans.mUserName;
        textView.setText(str);
        textView2 = this.ans.anm;
        textView2.setText(!ba.isEmpty(forbidReasonData.reason) ? forbidReasonData.reason : this.ans.getPageContext().getString(z.default_forbid_reason));
    }

    @Override // com.baidu.tieba.account.appeal.l
    public void b(ForbidReasonData forbidReasonData) {
        this.ans.showToast(forbidReasonData.error.errMsg);
    }
}
