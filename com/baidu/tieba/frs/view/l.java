package com.baidu.tieba.frs.view;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.a = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        Activity activity;
        Activity activity2;
        String str2;
        str = this.a.an;
        if (!TextUtils.isEmpty(str)) {
            activity = this.a.z;
            activity2 = this.a.z;
            String string = activity2.getString(y.frs_badge_intro);
            str2 = this.a.an;
            TbWebViewActivity.startActivity(activity, string, str2);
        }
    }
}
