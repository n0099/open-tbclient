package com.baidu.tieba.frs.view;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.browser.TbWebViewActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h implements View.OnClickListener {
    final /* synthetic */ FrsHeaderView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FrsHeaderView frsHeaderView) {
        this.a = frsHeaderView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        Activity activity;
        Activity activity2;
        String str2;
        str = this.a.ak;
        if (!TextUtils.isEmpty(str)) {
            activity = this.a.B;
            activity2 = this.a.B;
            String string = activity2.getString(com.baidu.tieba.a.k.frs_badge_intro);
            str2 = this.a.ak;
            TbWebViewActivity.b(activity, string, str2);
        }
    }
}
