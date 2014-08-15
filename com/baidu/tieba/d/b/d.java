package com.baidu.tieba.d.b;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    private static d a;

    public static final d a() {
        if (a != null) {
            return a;
        }
        synchronized (d.class) {
            if (a == null) {
                a = new d();
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
                com.baidu.tbadk.core.f.a(view.getContext(), "pb_tb_btc");
                int r = h.r();
                if (r == 0) {
                    if (UtilHelper.getNetStatusInfo(view.getContext()) != UtilHelper.NetworkStateInfo.WIFI && (view.getContext() instanceof Activity)) {
                        com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a((Activity) view.getContext());
                        aVar2.a(x.del_post_tip);
                        aVar2.b(x.frs_network_tips);
                        aVar2.a(x.alert_yes_button, new e(this, view, h, g, aVar));
                        aVar2.b(x.alert_no_button, new f(this));
                        aVar2.a();
                        aVar2.b();
                        return;
                    }
                    com.baidu.tbadk.distribute.a.a().a(view.getContext(), h.y(), "btn_download", "pb", h.b, h.c);
                    com.baidu.tbadk.distribute.a.a().a(h.y(), h.b, h.c, "PB", "download");
                    com.baidu.tieba.d.b.a(view.getContext(), h, g);
                    aVar.a();
                } else if (r == 2) {
                    com.baidu.tieba.d.b.a(view.getContext(), h);
                    aVar.a();
                }
            }
        }
    }
}
