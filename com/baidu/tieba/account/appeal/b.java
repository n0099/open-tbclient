package com.baidu.tieba.account.appeal;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ AppealActivity aya;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AppealActivity appealActivity) {
        this.aya = appealActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        String str;
        String str2;
        String str3;
        textView = this.aya.axV;
        String charSequence = textView.getText().toString();
        if (charSequence.length() < 20) {
            this.aya.showToast(t.appeal_min_size);
        } else if (charSequence.length() <= 150) {
            str = this.aya.axX;
            str2 = this.aya.axY;
            str3 = this.aya.aec;
            f.a(str, str2, str3, charSequence, new c(this));
        } else {
            this.aya.showToast(t.appeal_max_size);
        }
    }
}
