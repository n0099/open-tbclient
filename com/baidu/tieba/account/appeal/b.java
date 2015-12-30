package com.baidu.tieba.account.appeal;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ AppealActivity aIN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AppealActivity appealActivity) {
        this.aIN = appealActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        String str;
        String str2;
        String str3;
        textView = this.aIN.aII;
        String charSequence = textView.getText().toString();
        if (charSequence.length() < 20) {
            this.aIN.showToast(n.j.appeal_min_size);
        } else if (charSequence.length() <= 150) {
            str = this.aIN.aIK;
            str2 = this.aIN.aIL;
            str3 = this.aIN.mUserName;
            f.a(str, str2, str3, charSequence, new c(this));
        } else {
            this.aIN.showToast(n.j.appeal_max_size);
        }
    }
}
