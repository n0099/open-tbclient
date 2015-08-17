package com.baidu.tieba.account.appeal;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ AppealActivity aFs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AppealActivity appealActivity) {
        this.aFs = appealActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        String str;
        String str2;
        String str3;
        textView = this.aFs.aFn;
        String charSequence = textView.getText().toString();
        if (charSequence.length() < 20) {
            this.aFs.showToast(i.C0057i.appeal_min_size);
        } else if (charSequence.length() <= 150) {
            str = this.aFs.aFp;
            str2 = this.aFs.aFq;
            str3 = this.aFs.ajl;
            f.a(str, str2, str3, charSequence, new c(this));
        } else {
            this.aFs.showToast(i.C0057i.appeal_max_size);
        }
    }
}
