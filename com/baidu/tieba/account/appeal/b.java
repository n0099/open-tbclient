package com.baidu.tieba.account.appeal;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ AppealActivity aUa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AppealActivity appealActivity) {
        this.aUa = appealActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        String str;
        String str2;
        String str3;
        textView = this.aUa.aTV;
        String charSequence = textView.getText().toString();
        if (charSequence.length() < 20) {
            this.aUa.showToast(w.l.appeal_min_size);
        } else if (charSequence.length() <= 150) {
            str = this.aUa.aTX;
            str2 = this.aUa.aTY;
            str3 = this.aUa.mUserName;
            f.a(str, str2, str3, charSequence, new c(this));
        } else {
            this.aUa.showToast(w.l.appeal_max_size);
        }
    }
}
