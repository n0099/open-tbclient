package com.baidu.tieba.home;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {
    final /* synthetic */ SearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(SearchActivity searchActivity) {
        this.a = searchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        int i;
        String str3;
        str = this.a.x;
        if (str != null) {
            str2 = this.a.x;
            if (str2.trim().length() >= 1) {
                i = this.a.D;
                if (i == 0) {
                    this.a.l();
                    return;
                }
                SearchActivity searchActivity = this.a;
                str3 = this.a.x;
                searchActivity.a(1, str3);
                return;
            }
        }
        this.a.finish();
    }
}
