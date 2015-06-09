package com.baidu.tieba.account.login;

import android.view.View;
import android.widget.Button;
import com.baidu.tieba.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnFocusChangeListener {
    final /* synthetic */ Login2Activity ayN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Login2Activity login2Activity) {
        this.ayN = login2Activity;
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
            if (id == q.edit_vcode) {
                button7 = this.ayN.ayD;
                button7.setVisibility(8);
                button8 = this.ayN.ayC;
                button8.setVisibility(8);
                button9 = this.ayN.ayE;
                button9.setVisibility(0);
            } else if (id == q.login_edit_account) {
                button4 = this.ayN.ayD;
                button4.setVisibility(8);
                button5 = this.ayN.ayC;
                button5.setVisibility(0);
                button6 = this.ayN.ayE;
                button6.setVisibility(8);
            } else if (id == q.login_edit_password) {
                button = this.ayN.ayD;
                button.setVisibility(0);
                button2 = this.ayN.ayC;
                button2.setVisibility(8);
                button3 = this.ayN.ayE;
                button3.setVisibility(8);
            }
        }
    }
}
