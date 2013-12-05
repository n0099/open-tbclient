package com.baidu.tieba.account.appeal;

import android.widget.TextView;
import com.baidu.tieba.util.bb;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements l {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppealActivity f1055a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AppealActivity appealActivity) {
        this.f1055a = appealActivity;
    }

    @Override // com.baidu.tieba.account.appeal.l
    public void a(ForbidReasonData forbidReasonData) {
        TextView textView;
        String str;
        TextView textView2;
        textView = this.f1055a.b;
        str = this.f1055a.h;
        textView.setText(str);
        textView2 = this.f1055a.c;
        textView2.setText(!bb.c(forbidReasonData.reason) ? forbidReasonData.reason : this.f1055a.getString(R.string.default_forbid_reason));
    }

    @Override // com.baidu.tieba.account.appeal.l
    public void b(ForbidReasonData forbidReasonData) {
        this.f1055a.showToast(forbidReasonData.error.b);
    }
}
