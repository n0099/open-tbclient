package com.baidu.tieba.account.login;

import android.view.View;
import android.widget.Button;
import com.baidu.tieba.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnFocusChangeListener {
    final /* synthetic */ Login2Activity ayM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Login2Activity login2Activity) {
        this.ayM = login2Activity;
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
                button7 = this.ayM.ayC;
                button7.setVisibility(8);
                button8 = this.ayM.ayB;
                button8.setVisibility(8);
                button9 = this.ayM.ayD;
                button9.setVisibility(0);
            } else if (id == q.login_edit_account) {
                button4 = this.ayM.ayC;
                button4.setVisibility(8);
                button5 = this.ayM.ayB;
                button5.setVisibility(0);
                button6 = this.ayM.ayD;
                button6.setVisibility(8);
            } else if (id == q.login_edit_password) {
                button = this.ayM.ayC;
                button.setVisibility(0);
                button2 = this.ayM.ayB;
                button2.setVisibility(8);
                button3 = this.ayM.ayD;
                button3.setVisibility(8);
            }
        }
    }
}
