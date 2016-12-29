package com.baidu.tieba.account.appeal;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ AppealActivity aUL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AppealActivity appealActivity) {
        this.aUL = appealActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        String str;
        String str2;
        String str3;
        textView = this.aUL.aUF;
        String charSequence = textView.getText().toString();
        if (charSequence.length() < 20) {
            this.aUL.showToast(r.j.appeal_min_size);
        } else if (charSequence.length() <= 150) {
            str = this.aUL.aUH;
            str2 = this.aUL.aUI;
            str3 = this.aUL.mUserName;
            f.a(str, str2, str3, charSequence, new c(this));
        } else {
            this.aUL.showToast(r.j.appeal_max_size);
        }
    }
}
