package com.baidu.tieba.account;

import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements TextView.OnEditorActionListener {
    final /* synthetic */ LoginActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        View view;
        View view2;
        view = this.a.G;
        if (view.getVisibility() != 8 || i != 4) {
            view2 = this.a.G;
            if (view2.getVisibility() != 0 || i != 6) {
                return false;
            }
        }
        this.a.o();
        return true;
    }
}
