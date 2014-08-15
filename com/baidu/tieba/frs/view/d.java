package com.baidu.tieba.frs.view;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.browser.TbWebViewActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ FrsHeaderView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FrsHeaderView frsHeaderView) {
        this.a = frsHeaderView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        Activity activity;
        Activity activity2;
        String str2;
        str = this.a.ao;
        if (!TextUtils.isEmpty(str)) {
            activity = this.a.E;
            activity2 = this.a.E;
            String string = activity2.getString(com.baidu.tieba.x.frs_badge_intro);
            str2 = this.a.ao;
            TbWebViewActivity.startActivity(activity, string, str2);
        }
    }
}
