package com.baidu.tieba.account.appeal;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ AppealActivity aHl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AppealActivity appealActivity) {
        this.aHl = appealActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        String str;
        String str2;
        String str3;
        textView = this.aHl.aHg;
        String charSequence = textView.getText().toString();
        if (charSequence.length() < 20) {
            this.aHl.showToast(n.i.appeal_min_size);
        } else if (charSequence.length() <= 150) {
            str = this.aHl.aHi;
            str2 = this.aHl.aHj;
            str3 = this.aHl.mUserName;
            f.a(str, str2, str3, charSequence, new c(this));
        } else {
            this.aHl.showToast(n.i.appeal_max_size);
        }
    }
}
