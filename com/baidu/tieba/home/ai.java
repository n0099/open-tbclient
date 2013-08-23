package com.baidu.tieba.home;

import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ai implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1154a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(SearchActivity searchActivity) {
        this.f1154a = searchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        int i;
        String str3;
        str = this.f1154a.D;
        if (str != null) {
            str2 = this.f1154a.D;
            if (str2.trim().length() >= 1) {
                i = this.f1154a.E;
                if (i == 0) {
                    this.f1154a.k();
                    return;
                }
                SearchActivity searchActivity = this.f1154a;
                str3 = this.f1154a.D;
                searchActivity.a(1, str3);
                return;
            }
        }
        this.f1154a.a(this.f1154a.getResources().getString(R.string.write_keyword));
    }
}
