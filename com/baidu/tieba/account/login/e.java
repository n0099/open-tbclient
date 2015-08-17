package com.baidu.tieba.account.login;

import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements TextView.OnEditorActionListener {
    final /* synthetic */ Login2Activity aGf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Login2Activity login2Activity) {
        this.aGf = login2Activity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        View view;
        View view2;
        view = this.aGf.aFS;
        if (view.getVisibility() != 8 || i != 4) {
            view2 = this.aGf.aFS;
            if (view2.getVisibility() != 0 || i != 6) {
                return false;
            }
        }
        this.aGf.Go();
        return true;
    }
}
