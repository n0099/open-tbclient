package com.baidu.tieba.account.login;

import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements TextView.OnEditorActionListener {
    final /* synthetic */ Login2Activity axg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Login2Activity login2Activity) {
        this.axg = login2Activity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        View view;
        View view2;
        view = this.axg.awU;
        if (view.getVisibility() != 8 || i != 4) {
            view2 = this.axg.awU;
            if (view2.getVisibility() != 0 || i != 6) {
                return false;
            }
        }
        this.axg.EH();
        return true;
    }
}
