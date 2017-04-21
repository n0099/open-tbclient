package com.baidu.tieba.account.appeal;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ AppealActivity aWc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AppealActivity appealActivity) {
        this.aWc = appealActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        String str;
        String str2;
        String str3;
        textView = this.aWc.aVX;
        String charSequence = textView.getText().toString();
        if (charSequence.length() < 20) {
            this.aWc.showToast(w.l.appeal_min_size);
        } else if (charSequence.length() <= 150) {
            str = this.aWc.aVZ;
            str2 = this.aWc.aWa;
            str3 = this.aWc.mUserName;
            f.a(str, str2, str3, charSequence, new c(this));
        } else {
            this.aWc.showToast(w.l.appeal_max_size);
        }
    }
}
