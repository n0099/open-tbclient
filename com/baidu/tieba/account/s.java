package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LoginActivity f889a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(LoginActivity loginActivity) {
        this.f889a = loginActivity;
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
                case R.id.login_edit_account /* 2131099714 */:
                    button7 = this.f889a.I;
                    button7.setVisibility(8);
                    button8 = this.f889a.H;
                    button8.setVisibility(0);
                    button9 = this.f889a.J;
                    button9.setVisibility(8);
                    return;
                case R.id.login_edit_password /* 2131099718 */:
                    button = this.f889a.I;
                    button.setVisibility(0);
                    button2 = this.f889a.H;
                    button2.setVisibility(8);
                    button3 = this.f889a.J;
                    button3.setVisibility(8);
                    return;
                case R.id.edit_vcode /* 2131099721 */:
                    button4 = this.f889a.I;
                    button4.setVisibility(8);
                    button5 = this.f889a.H;
                    button5.setVisibility(8);
                    button6 = this.f889a.J;
                    button6.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }
}
