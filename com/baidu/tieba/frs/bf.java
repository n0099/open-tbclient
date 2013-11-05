package com.baidu.tieba.frs;

import android.app.Activity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class bf {

    /* renamed from: a  reason: collision with root package name */
    Activity f1275a;
    int b = 0;

    public bf(Activity activity) {
        this.f1275a = activity;
    }

    public void a(boolean z, int i) {
        if (!com.baidu.tieba.im.l.b().e()) {
            new com.baidu.adp.lib.guide.g().b(R.id.frs_lv_thread).a(150).a(true).a(new bg(this, i, z)).a().a(this.f1275a);
            com.baidu.tieba.im.l.b().b(true);
        }
    }
}
