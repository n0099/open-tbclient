package com.baidu.tieba.account.appeal;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ AppealActivity aVu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AppealActivity appealActivity) {
        this.aVu = appealActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        String str;
        String str2;
        String str3;
        textView = this.aVu.aVo;
        String charSequence = textView.getText().toString();
        if (charSequence.length() < 20) {
            this.aVu.showToast(r.j.appeal_min_size);
        } else if (charSequence.length() <= 150) {
            str = this.aVu.aVq;
            str2 = this.aVu.aVr;
            str3 = this.aVu.mUserName;
            f.a(str, str2, str3, charSequence, new c(this));
        } else {
            this.aVu.showToast(r.j.appeal_max_size);
        }
    }
}
