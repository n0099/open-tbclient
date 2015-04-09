package com.baidu.tieba.account.appeal;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ AppealActivity awu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AppealActivity appealActivity) {
        this.awu = appealActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        String str;
        String str2;
        String str3;
        textView = this.awu.awp;
        String charSequence = textView.getText().toString();
        if (charSequence.length() < 20) {
            this.awu.showToast(y.appeal_min_size);
        } else if (charSequence.length() <= 150) {
            str = this.awu.awr;
            str2 = this.awu.aws;
            str3 = this.awu.acU;
            f.a(str, str2, str3, charSequence, new c(this));
        } else {
            this.awu.showToast(y.appeal_max_size);
        }
    }
}
