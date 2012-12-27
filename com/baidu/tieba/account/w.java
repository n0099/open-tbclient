package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnFocusChangeListener {
    final /* synthetic */ LoginActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        Button button;
        Button button2;
        Button button3;
        Button button4;
        Button button5;
        Button button6;
        Button button7;
        Button button8;
        Button button9;
        if (z) {
            switch (view.getId()) {
                case R.id.login_edit_account /* 2131230743 */:
                    button7 = this.a.E;
                    button7.setVisibility(8);
                    button8 = this.a.D;
                    button8.setVisibility(0);
                    button9 = this.a.F;
                    button9.setVisibility(8);
                    return;
                case R.id.login_edit_password /* 2131230747 */:
                    button = this.a.E;
                    button.setVisibility(0);
                    button2 = this.a.D;
                    button2.setVisibility(8);
                    button3 = this.a.F;
                    button3.setVisibility(8);
                    return;
                case R.id.edit_vcode /* 2131230750 */:
                    button4 = this.a.E;
                    button4.setVisibility(8);
                    button5 = this.a.D;
                    button5.setVisibility(8);
                    button6 = this.a.F;
                    button6.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }
}
