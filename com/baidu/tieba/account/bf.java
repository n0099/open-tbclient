package com.baidu.tieba.account;

import android.view.View;
import android.widget.Button;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements View.OnClickListener {
    final /* synthetic */ RegisterActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(RegisterActivity registerActivity) {
        this.a = registerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        Button button;
        Button button2;
        z = this.a.q;
        if (z) {
            this.a.q = false;
            button2 = this.a.j;
            button2.setBackgroundResource(R.drawable.account_check_pro);
            return;
        }
        this.a.q = true;
        button = this.a.j;
        button.setBackgroundResource(R.drawable.account_check_pro_on);
    }
}
