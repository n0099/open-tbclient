package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.SharedPreferences;
import com.baidu.tieba.TiebaApplication;
import com.baidu.zeus.WebChromeClient;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class be {

    /* renamed from: a  reason: collision with root package name */
    Activity f1093a;
    int b = 0;

    public be(Activity activity) {
        this.f1093a = activity;
    }

    public void a() {
        SharedPreferences sharedPreferences = TiebaApplication.g().getSharedPreferences("settings", 0);
        boolean z = sharedPreferences.getBoolean("frs_first_in", true);
        com.baidu.tieba.util.aq.c("showTip");
        if (z && TiebaApplication.g().an() != 1) {
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.b(R.id.btn_love).a(WebChromeClient.STRING_DLG_BTN_SET).a(true);
            bf bfVar = new bf(this);
            gVar.a(bfVar).a(new bg(this));
            gVar.a().a(this.f1093a);
            com.baidu.tieba.util.aq.e("FrsTipCover", "show", "done");
            sharedPreferences.edit().putBoolean("frs_first_in", false).commit();
        }
    }
}
