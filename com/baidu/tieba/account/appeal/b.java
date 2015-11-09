package com.baidu.tieba.account.appeal;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ AppealActivity aEm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AppealActivity appealActivity) {
        this.aEm = appealActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        String str;
        String str2;
        String str3;
        textView = this.aEm.aEh;
        String charSequence = textView.getText().toString();
        if (charSequence.length() < 20) {
            this.aEm.showToast(i.h.appeal_min_size);
        } else if (charSequence.length() <= 150) {
            str = this.aEm.aEj;
            str2 = this.aEm.aEk;
            str3 = this.aEm.mUserName;
            f.a(str, str2, str3, charSequence, new c(this));
        } else {
            this.aEm.showToast(i.h.appeal_max_size);
        }
    }
}
