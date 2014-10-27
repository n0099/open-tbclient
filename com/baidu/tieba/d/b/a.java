package com.baidu.tieba.d.b;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private static a bHr;

    public static final a abx() {
        if (bHr != null) {
            return bHr;
        }
        synchronized (a.class) {
            if (bHr == null) {
                bHr = new a();
            }
        }
        return bHr;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            Object tag = view.getTag();
            if (tag instanceof com.baidu.tieba.d.c.a) {
                com.baidu.tieba.d.c.a aVar = (com.baidu.tieba.d.c.a) tag;
                com.baidu.tieba.d.a.f abF = aVar.abF();
                int position = aVar.getPosition();
                if (abF != null) {
                    com.baidu.tbadk.distribute.a.ra().a(view.getContext(), abF.abw(), "area_click", "pb", abF.bHq, abF.threadId);
                    com.baidu.tbadk.distribute.a.ra().a(abF.abw(), abF.bHq, abF.threadId, "PB", "click");
                    TiebaStatic.eventStat(view.getContext(), "pb_ck_app", null, 1, "app_name", abF.abk());
                    int abs = abF.abs();
                    if (abs == 0) {
                        if (view.getContext() instanceof Activity) {
                            com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a((Activity) view.getContext());
                            aVar2.aW(y.del_post_tip);
                            if (!j.fi()) {
                                aVar2.aX(y.frs_network_tips);
                            } else if (StringUtils.isNull(abF.abv())) {
                                aVar2.aX(y.pb_app_download_ask);
                            } else {
                                aVar2.bg(abF.abv());
                            }
                            aVar2.a(y.alert_yes_button, new b(this, view, abF, position, aVar));
                            aVar2.b(y.alert_no_button, new c(this));
                            aVar2.kT();
                            aVar2.kW();
                        }
                    } else if (abs == 2) {
                        com.baidu.tieba.d.b.a(view.getContext(), abF);
                        aVar.refresh();
                    }
                }
            }
        }
    }
}
