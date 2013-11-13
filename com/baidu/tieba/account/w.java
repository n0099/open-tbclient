package com.baidu.tieba.account;

import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LoginActivity f1093a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(LoginActivity loginActivity) {
        this.f1093a = loginActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        View view;
        View view2;
        view = this.f1093a.B;
        if (view.getVisibility() != 8 || i != 4) {
            view2 = this.f1093a.B;
            if (view2.getVisibility() != 0 || i != 6) {
                return false;
            }
        }
        this.f1093a.g();
        return true;
    }
}
