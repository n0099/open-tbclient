package com.baidu.tieba.home;

import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class af implements View.OnClickListener {
    final /* synthetic */ SearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(SearchActivity searchActivity) {
        this.a = searchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        int i;
        String str3;
        str = this.a.A;
        if (str != null) {
            str2 = this.a.A;
            if (str2.trim().length() >= 1) {
                i = this.a.B;
                if (i == 0) {
                    this.a.d();
                    return;
                }
                SearchActivity searchActivity = this.a;
                str3 = this.a.A;
                searchActivity.a(1, str3);
                return;
            }
        }
        this.a.showToast(this.a.getResources().getString(R.string.write_keyword));
    }
}
