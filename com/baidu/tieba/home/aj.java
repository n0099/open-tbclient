package com.baidu.tieba.home;

import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class aj implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1403a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(SearchActivity searchActivity) {
        this.f1403a = searchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        int i;
        String str3;
        str = this.f1403a.A;
        if (str != null) {
            str2 = this.f1403a.A;
            if (str2.trim().length() >= 1) {
                i = this.f1403a.B;
                if (i == 0) {
                    this.f1403a.d();
                    return;
                }
                SearchActivity searchActivity = this.f1403a;
                str3 = this.f1403a.A;
                searchActivity.a(1, str3);
                return;
            }
        }
        this.f1403a.showToast(this.f1403a.getResources().getString(R.string.write_keyword));
    }
}
