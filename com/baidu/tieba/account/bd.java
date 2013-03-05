package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements View.OnClickListener {
    final /* synthetic */ RegisterActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(RegisterActivity registerActivity) {
        this.a = registerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        Button button;
        Button button2;
        Button button3;
        Button button4;
        Button button5;
        Button button6;
        Button button7;
        Button button8;
        Button button9;
        Button button10;
        Button button11;
        Button button12;
        i = this.a.q;
        if (i == 1) {
            this.a.q = 2;
            button7 = this.a.g;
            button7.setClickable(true);
            button8 = this.a.g;
            button8.setBackgroundDrawable(null);
            button9 = this.a.g;
            button9.setTextColor(this.a.getResources().getColor(R.color.white));
            button10 = this.a.h;
            button10.setClickable(false);
            button11 = this.a.h;
            button11.setBackgroundResource(R.drawable.account_sex);
            button12 = this.a.h;
            button12.setTextColor(this.a.getResources().getColor(R.color.black));
            return;
        }
        this.a.q = 1;
        button = this.a.g;
        button.setClickable(false);
        button2 = this.a.g;
        button2.setBackgroundResource(R.drawable.account_sex);
        button3 = this.a.g;
        button3.setTextColor(this.a.getResources().getColor(R.color.black));
        button4 = this.a.h;
        button4.setClickable(true);
        button5 = this.a.h;
        button5.setBackgroundDrawable(null);
        button6 = this.a.h;
        button6.setTextColor(this.a.getResources().getColor(R.color.white));
    }
}
