package com.baidu.tieba.home;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1128a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(SearchActivity searchActivity) {
        this.f1128a = searchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        int i;
        String str3;
        str = this.f1128a.A;
        if (str != null) {
            str2 = this.f1128a.A;
            if (str2.trim().length() >= 1) {
                i = this.f1128a.B;
                if (i == 0) {
                    this.f1128a.k();
                    return;
                }
                SearchActivity searchActivity = this.f1128a;
                str3 = this.f1128a.A;
                searchActivity.a(1, str3);
                return;
            }
        }
        this.f1128a.finish();
    }
}
