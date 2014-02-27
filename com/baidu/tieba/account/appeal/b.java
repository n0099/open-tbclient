package com.baidu.tieba.account.appeal;

import android.view.View;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class b implements View.OnClickListener {
    final /* synthetic */ AppealActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AppealActivity appealActivity) {
        this.a = appealActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        TextView textView;
        String str;
        String str2;
        String str3;
        textView = this.a.d;
        String charSequence = textView.getText().toString();
        if (charSequence.length() < 20) {
            this.a.showToast(R.string.appeal_min_size);
        } else if (charSequence.length() <= 150) {
            str = this.a.f;
            str2 = this.a.g;
            str3 = this.a.h;
            f.a(str, str2, str3, charSequence, new c(this));
        } else {
            this.a.showToast(R.string.appeal_max_size);
        }
    }
}
