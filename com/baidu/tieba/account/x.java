package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LoginActivity f1107a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(LoginActivity loginActivity) {
        this.f1107a = loginActivity;
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
                case R.id.login_edit_account /* 2131099746 */:
                    button7 = this.f1107a.D;
                    button7.setVisibility(8);
                    button8 = this.f1107a.C;
                    button8.setVisibility(0);
                    button9 = this.f1107a.E;
                    button9.setVisibility(8);
                    return;
                case R.id.login_edit_password /* 2131099750 */:
                    button = this.f1107a.D;
                    button.setVisibility(0);
                    button2 = this.f1107a.C;
                    button2.setVisibility(8);
                    button3 = this.f1107a.E;
                    button3.setVisibility(8);
                    return;
                case R.id.edit_vcode /* 2131099753 */:
                    button4 = this.f1107a.D;
                    button4.setVisibility(8);
                    button5 = this.f1107a.C;
                    button5.setVisibility(8);
                    button6 = this.f1107a.E;
                    button6.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }
}
