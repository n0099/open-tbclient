package com.baidu.tieba.account.appeal;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ AppealActivity aok;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AppealActivity appealActivity) {
        this.aok = appealActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        String str;
        String str2;
        String str3;
        textView = this.aok.aof;
        String charSequence = textView.getText().toString();
        if (charSequence.length() < 20) {
            this.aok.showToast(z.appeal_min_size);
        } else if (charSequence.length() <= 150) {
            str = this.aok.aoh;
            str2 = this.aok.aoi;
            str3 = this.aok.mUserName;
            f.a(str, str2, str3, charSequence, new c(this));
        } else {
            this.aok.showToast(z.appeal_max_size);
        }
    }
}
