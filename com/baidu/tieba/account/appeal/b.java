package com.baidu.tieba.account.appeal;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ AppealActivity aMO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AppealActivity appealActivity) {
        this.aMO = appealActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        String str;
        String str2;
        String str3;
        textView = this.aMO.aMJ;
        String charSequence = textView.getText().toString();
        if (charSequence.length() < 20) {
            this.aMO.showToast(t.j.appeal_min_size);
        } else if (charSequence.length() <= 150) {
            str = this.aMO.aML;
            str2 = this.aMO.aMM;
            str3 = this.aMO.mUserName;
            f.a(str, str2, str3, charSequence, new c(this));
        } else {
            this.aMO.showToast(t.j.appeal_max_size);
        }
    }
}
