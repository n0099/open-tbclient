package com.baidu.tieba.account.appeal;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ AppealActivity aGo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AppealActivity appealActivity) {
        this.aGo = appealActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        String str;
        String str2;
        String str3;
        textView = this.aGo.aGj;
        String charSequence = textView.getText().toString();
        if (charSequence.length() < 20) {
            this.aGo.showToast(i.h.appeal_min_size);
        } else if (charSequence.length() <= 150) {
            str = this.aGo.aGl;
            str2 = this.aGo.aGm;
            str3 = this.aGo.aju;
            f.a(str, str2, str3, charSequence, new c(this));
        } else {
            this.aGo.showToast(i.h.appeal_max_size);
        }
    }
}
