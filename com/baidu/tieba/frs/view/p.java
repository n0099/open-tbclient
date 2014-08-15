package com.baidu.tieba.frs.view;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.browser.TbWebViewActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ n a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.a = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        Activity activity;
        Activity activity2;
        String str2;
        str = this.a.at;
        if (!TextUtils.isEmpty(str)) {
            activity = this.a.B;
            activity2 = this.a.B;
            String string = activity2.getString(com.baidu.tieba.x.frs_badge_intro);
            str2 = this.a.at;
            TbWebViewActivity.startActivity(activity, string, str2);
        }
    }
}
