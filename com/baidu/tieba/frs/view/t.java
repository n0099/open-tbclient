package com.baidu.tieba.frs.view;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.browser.TbWebViewActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ r aGu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar) {
        this.aGu = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        Activity activity;
        Activity activity2;
        String str2;
        str = this.aGu.aFX;
        if (!TextUtils.isEmpty(str)) {
            activity = this.aGu.aBP;
            activity2 = this.aGu.aBP;
            String string = activity2.getString(com.baidu.tieba.y.frs_badge_intro);
            str2 = this.aGu.aFX;
            TbWebViewActivity.startActivity(activity, string, str2);
        }
    }
}
