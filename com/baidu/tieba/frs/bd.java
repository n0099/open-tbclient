package com.baidu.tieba.frs;

import android.app.Activity;
import com.baidu.zeus.WebChromeClient;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class bd {

    /* renamed from: a  reason: collision with root package name */
    Activity f1140a;
    int b = 0;

    public bd(Activity activity) {
        this.f1140a = activity;
    }

    public void a() {
        if (com.baidu.tieba.sharedPref.b.a().a("frs_first_in", true)) {
            new com.baidu.adp.lib.guide.g().b(R.id.frs_top_more).a(WebChromeClient.STRING_DLG_BTN_SET).a(true).a(new be(this)).a(new bf(this)).a().a(this.f1140a);
            com.baidu.tieba.sharedPref.b.a().b("frs_first_in", false);
        }
    }
}
