package com.baidu.tieba.account.appeal;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ AppealActivity agb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AppealActivity appealActivity) {
        this.agb = appealActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        String str;
        String str2;
        String str3;
        textView = this.agb.afW;
        String charSequence = textView.getText().toString();
        if (charSequence.length() < 20) {
            this.agb.showToast(y.appeal_min_size);
        } else if (charSequence.length() <= 150) {
            str = this.agb.afY;
            str2 = this.agb.afZ;
            str3 = this.agb.mUserName;
            f.a(str, str2, str3, charSequence, new c(this));
        } else {
            this.agb.showToast(y.appeal_max_size);
        }
    }
}
