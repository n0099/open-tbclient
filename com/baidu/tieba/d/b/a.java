package com.baidu.tieba.d.b;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private static a a;

    public static final a a() {
        if (a != null) {
            return a;
        }
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
        }
        return a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            Object tag = view.getTag();
            if (tag instanceof com.baidu.tieba.d.c.a) {
                com.baidu.tieba.d.c.a aVar = (com.baidu.tieba.d.c.a) tag;
                com.baidu.tieba.d.a.f h = aVar.h();
                int g = aVar.g();
                if (h != null) {
                    com.baidu.tbadk.distribute.a.a().a(view.getContext(), h.y(), "area_click", "pb", h.b, h.c);
                    com.baidu.tbadk.distribute.a.a().a(h.y(), h.b, h.c, "PB", "click");
                    TiebaStatic.eventStat(view.getContext(), "pb_ck_app", null, 1, "app_name", h.a());
                    int r = h.r();
                    if (r == 0) {
                        if (view.getContext() instanceof Activity) {
                            com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a((Activity) view.getContext());
                            aVar2.a(x.del_post_tip);
                            if (UtilHelper.getNetStatusInfo(view.getContext()) != UtilHelper.NetworkStateInfo.WIFI) {
                                aVar2.b(x.frs_network_tips);
                            } else if (StringUtils.isNull(h.x())) {
                                aVar2.b(x.pb_app_download_ask);
                            } else {
                                aVar2.b(h.x());
                            }
                            aVar2.a(x.alert_yes_button, new b(this, view, h, g, aVar));
                            aVar2.b(x.alert_no_button, new c(this));
                            aVar2.a();
                            aVar2.b();
                        }
                    } else if (r == 2) {
                        com.baidu.tieba.d.b.a(view.getContext(), h);
                        aVar.a();
                    }
                }
            }
        }
    }
}
