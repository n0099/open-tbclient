package com.baidu.tbadk.coreExtra.act;

import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
final class q implements TextView.OnEditorActionListener {
    final /* synthetic */ LoginActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        View view;
        View view2;
        view = this.a.B;
        if (view.getVisibility() != 8 || i != 4) {
            view2 = this.a.B;
            if (view2.getVisibility() != 0 || i != 6) {
                return false;
            }
        }
        LoginActivity.t(this.a);
        return true;
    }
}
