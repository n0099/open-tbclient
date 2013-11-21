package com.baidu.tieba.account.appeal;

import android.widget.TextView;
import com.baidu.tieba.util.be;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements l {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppealActivity f1045a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AppealActivity appealActivity) {
        this.f1045a = appealActivity;
    }

    @Override // com.baidu.tieba.account.appeal.l
    public void a(ForbidReasonData forbidReasonData) {
        TextView textView;
        String str;
        TextView textView2;
        textView = this.f1045a.b;
        str = this.f1045a.h;
        textView.setText(str);
        textView2 = this.f1045a.c;
        textView2.setText(!be.c(forbidReasonData.reason) ? forbidReasonData.reason : this.f1045a.getString(R.string.default_forbid_reason));
    }

    @Override // com.baidu.tieba.account.appeal.l
    public void b(ForbidReasonData forbidReasonData) {
        this.f1045a.showToast(forbidReasonData.error.b);
    }
}
