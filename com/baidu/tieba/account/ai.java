package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class ai implements View.OnFocusChangeListener {
    final /* synthetic */ LoginActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
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
            if (id == R.id.edit_vcode) {
                button7 = this.a.D;
                button7.setVisibility(8);
                button8 = this.a.C;
                button8.setVisibility(8);
                button9 = this.a.E;
                button9.setVisibility(0);
            } else if (id == R.id.login_edit_account) {
                button4 = this.a.D;
                button4.setVisibility(8);
                button5 = this.a.C;
                button5.setVisibility(0);
                button6 = this.a.E;
                button6.setVisibility(8);
            } else if (id == R.id.login_edit_password) {
                button = this.a.D;
                button.setVisibility(0);
                button2 = this.a.C;
                button2.setVisibility(8);
                button3 = this.a.E;
                button3.setVisibility(8);
            }
        }
    }
}
