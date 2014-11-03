package com.baidu.tieba.frs.view;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.browser.TbWebViewActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ FrsHeaderView aGd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FrsHeaderView frsHeaderView) {
        this.aGd = frsHeaderView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        Activity activity;
        Activity activity2;
        String str2;
        str = this.aGd.aFX;
        if (!TextUtils.isEmpty(str)) {
            activity = this.aGd.aBP;
            activity2 = this.aGd.aBP;
            String string = activity2.getString(com.baidu.tieba.y.frs_badge_intro);
            str2 = this.aGd.aFX;
            TbWebViewActivity.startActivity(activity, string, str2);
        }
    }
}
