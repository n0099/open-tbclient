package com.baidu.tieba.account.appeal;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ AppealActivity aWa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AppealActivity appealActivity) {
        this.aWa = appealActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        String str;
        String str2;
        String str3;
        textView = this.aWa.aVV;
        String charSequence = textView.getText().toString();
        if (charSequence.length() < 20) {
            this.aWa.showToast(w.l.appeal_min_size);
        } else if (charSequence.length() <= 150) {
            str = this.aWa.aVX;
            str2 = this.aWa.aVY;
            str3 = this.aWa.mUserName;
            f.a(str, str2, str3, charSequence, new c(this));
        } else {
            this.aWa.showToast(w.l.appeal_max_size);
        }
    }
}
