package com.baidu.tieba.account.appeal;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ AppealActivity aVt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AppealActivity appealActivity) {
        this.aVt = appealActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        String str;
        String str2;
        String str3;
        textView = this.aVt.aVo;
        String charSequence = textView.getText().toString();
        if (charSequence.length() < 20) {
            this.aVt.showToast(w.l.appeal_min_size);
        } else if (charSequence.length() <= 150) {
            str = this.aVt.aVq;
            str2 = this.aVt.aVr;
            str3 = this.aVt.mUserName;
            f.a(str, str2, str3, charSequence, new c(this));
        } else {
            this.aVt.showToast(w.l.appeal_max_size);
        }
    }
}
