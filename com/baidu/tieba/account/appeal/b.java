package com.baidu.tieba.account.appeal;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ AppealActivity ayb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AppealActivity appealActivity) {
        this.ayb = appealActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        String str;
        String str2;
        String str3;
        textView = this.ayb.axW;
        String charSequence = textView.getText().toString();
        if (charSequence.length() < 20) {
            this.ayb.showToast(t.appeal_min_size);
        } else if (charSequence.length() <= 150) {
            str = this.ayb.axY;
            str2 = this.ayb.axZ;
            str3 = this.ayb.aec;
            f.a(str, str2, str3, charSequence, new c(this));
        } else {
            this.ayb.showToast(t.appeal_max_size);
        }
    }
}
