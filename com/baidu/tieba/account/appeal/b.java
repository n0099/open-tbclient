package com.baidu.tieba.account.appeal;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ AppealActivity aon;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AppealActivity appealActivity) {
        this.aon = appealActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        String str;
        String str2;
        String str3;
        textView = this.aon.aoi;
        String charSequence = textView.getText().toString();
        if (charSequence.length() < 20) {
            this.aon.showToast(z.appeal_min_size);
        } else if (charSequence.length() <= 150) {
            str = this.aon.aok;
            str2 = this.aon.aol;
            str3 = this.aon.mUserName;
            f.a(str, str2, str3, charSequence, new c(this));
        } else {
            this.aon.showToast(z.appeal_max_size);
        }
    }
}
