package com.baidu.tieba.account.login;

import android.view.View;
import android.widget.Button;
import com.baidu.tieba.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnFocusChangeListener {
    final /* synthetic */ Login2Activity awY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Login2Activity login2Activity) {
        this.awY = login2Activity;
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
            int id = view.getId();
            if (id == v.edit_vcode) {
                button7 = this.awY.awO;
                button7.setVisibility(8);
                button8 = this.awY.awN;
                button8.setVisibility(8);
                button9 = this.awY.awP;
                button9.setVisibility(0);
            } else if (id == v.login_edit_account) {
                button4 = this.awY.awO;
                button4.setVisibility(8);
                button5 = this.awY.awN;
                button5.setVisibility(0);
                button6 = this.awY.awP;
                button6.setVisibility(8);
            } else if (id == v.login_edit_password) {
                button = this.awY.awO;
                button.setVisibility(0);
                button2 = this.awY.awN;
                button2.setVisibility(8);
                button3 = this.awY.awP;
                button3.setVisibility(8);
            }
        }
    }
}
