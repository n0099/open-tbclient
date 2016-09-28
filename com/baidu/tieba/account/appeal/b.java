package com.baidu.tieba.account.appeal;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ AppealActivity aTt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AppealActivity appealActivity) {
        this.aTt = appealActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        String str;
        String str2;
        String str3;
        textView = this.aTt.aTn;
        String charSequence = textView.getText().toString();
        if (charSequence.length() < 20) {
            this.aTt.showToast(r.j.appeal_min_size);
        } else if (charSequence.length() <= 150) {
            str = this.aTt.aTp;
            str2 = this.aTt.aTq;
            str3 = this.aTt.mUserName;
            f.a(str, str2, str3, charSequence, new c(this));
        } else {
            this.aTt.showToast(r.j.appeal_max_size);
        }
    }
}
