package com.baidu.tieba.account.appeal;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ AppealActivity ans;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AppealActivity appealActivity) {
        this.ans = appealActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        String str;
        String str2;
        String str3;
        textView = this.ans.ann;
        String charSequence = textView.getText().toString();
        if (charSequence.length() < 20) {
            this.ans.showToast(z.appeal_min_size);
        } else if (charSequence.length() <= 150) {
            str = this.ans.anp;
            str2 = this.ans.anq;
            str3 = this.ans.mUserName;
            f.a(str, str2, str3, charSequence, new c(this));
        } else {
            this.ans.showToast(z.appeal_max_size);
        }
    }
}
