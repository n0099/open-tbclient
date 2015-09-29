package com.baidu.tieba.account.appeal;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ AppealActivity aFh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AppealActivity appealActivity) {
        this.aFh = appealActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        String str;
        String str2;
        String str3;
        textView = this.aFh.aFc;
        String charSequence = textView.getText().toString();
        if (charSequence.length() < 20) {
            this.aFh.showToast(i.h.appeal_min_size);
        } else if (charSequence.length() <= 150) {
            str = this.aFh.aFe;
            str2 = this.aFh.aFf;
            str3 = this.aFh.aiq;
            f.a(str, str2, str3, charSequence, new c(this));
        } else {
            this.aFh.showToast(i.h.appeal_max_size);
        }
    }
}
