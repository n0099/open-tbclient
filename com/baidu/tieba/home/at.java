package com.baidu.tieba.home;

import android.view.KeyEvent;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1165a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(SearchActivity searchActivity) {
        this.f1165a = searchActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        int i2;
        String str;
        if (i == 2) {
            i2 = this.f1165a.E;
            if (i2 == 0) {
                this.f1165a.k();
                return true;
            }
            SearchActivity searchActivity = this.f1165a;
            str = this.f1165a.D;
            searchActivity.a(1, str);
            return true;
        }
        return false;
    }
}
