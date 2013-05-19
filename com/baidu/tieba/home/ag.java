package com.baidu.tieba.home;

import android.view.KeyEvent;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements TextView.OnEditorActionListener {
    final /* synthetic */ SearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(SearchActivity searchActivity) {
        this.a = searchActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        int i2;
        String str;
        if (i == 2) {
            i2 = this.a.B;
            if (i2 == 0) {
                this.a.m();
                return true;
            }
            SearchActivity searchActivity = this.a;
            str = this.a.A;
            searchActivity.a(1, str);
            return true;
        }
        return false;
    }
}
