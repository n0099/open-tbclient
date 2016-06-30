package com.baidu.tieba.account.appeal;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ AppealActivity aMv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AppealActivity appealActivity) {
        this.aMv = appealActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        String str;
        String str2;
        String str3;
        textView = this.aMv.aMq;
        String charSequence = textView.getText().toString();
        if (charSequence.length() < 20) {
            this.aMv.showToast(u.j.appeal_min_size);
        } else if (charSequence.length() <= 150) {
            str = this.aMv.aMs;
            str2 = this.aMv.aMt;
            str3 = this.aMv.mUserName;
            f.a(str, str2, str3, charSequence, new c(this));
        } else {
            this.aMv.showToast(u.j.appeal_max_size);
        }
    }
}
