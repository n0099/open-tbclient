package com.baidu.tieba.account.appeal;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ AppealActivity aQb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AppealActivity appealActivity) {
        this.aQb = appealActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        String str;
        String str2;
        String str3;
        textView = this.aQb.aPW;
        String charSequence = textView.getText().toString();
        if (charSequence.length() < 20) {
            this.aQb.showToast(r.l.appeal_min_size);
        } else if (charSequence.length() <= 150) {
            str = this.aQb.aPY;
            str2 = this.aQb.aPZ;
            str3 = this.aQb.mUserName;
            f.a(str, str2, str3, charSequence, new c(this));
        } else {
            this.aQb.showToast(r.l.appeal_max_size);
        }
    }
}
