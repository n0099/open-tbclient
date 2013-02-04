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
        i = this.a.p;
        if (i == 1) {
            this.a.p = 2;
            button7 = this.a.f;
            button7.setClickable(true);
            button8 = this.a.f;
            button8.setBackgroundDrawable(null);
            button9 = this.a.f;
            button9.setTextColor(this.a.getResources().getColor(R.color.white));
            button10 = this.a.g;
            button10.setClickable(false);
            button11 = this.a.g;
            button11.setBackgroundResource(R.drawable.account_sex);
            button12 = this.a.g;
            button12.setTextColor(this.a.getResources().getColor(R.color.black));
            return;
        }
        this.a.p = 1;
        button = this.a.f;
        button.setClickable(false);
        button2 = this.a.f;
        button2.setBackgroundResource(R.drawable.account_sex);
        button3 = this.a.f;
        button3.setTextColor(this.a.getResources().getColor(R.color.black));
        button4 = this.a.g;
        button4.setClickable(true);
        button5 = this.a.g;
        button5.setBackgroundDrawable(null);
        button6 = this.a.g;
        button6.setTextColor(this.a.getResources().getColor(R.color.white));
    }
}
