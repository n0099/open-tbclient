package com.baidu.tieba.account.appeal;

import android.view.View;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppealActivity f1044a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AppealActivity appealActivity) {
        this.f1044a = appealActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        String str;
        String str2;
        String str3;
        textView = this.f1044a.d;
        String charSequence = textView.getText().toString();
        if (charSequence.length() < 20) {
            this.f1044a.showToast(R.string.appeal_min_size);
        } else if (charSequence.length() <= 150) {
            str = this.f1044a.f;
            str2 = this.f1044a.g;
            str3 = this.f1044a.h;
            f.a(str, str2, str3, charSequence, new d(this));
        } else {
            this.f1044a.showToast(R.string.appeal_max_size);
        }
    }
}
