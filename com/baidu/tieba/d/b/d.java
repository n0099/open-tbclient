package com.baidu.tieba.d.b;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.i;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    private static d bHv;

    public static final d aby() {
        if (bHv != null) {
            return bHv;
        }
        synchronized (d.class) {
            if (bHv == null) {
                bHv = new d();
            }
        }
        return bHv;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            Object tag = view.getTag();
            if (tag instanceof com.baidu.tieba.d.c.a) {
                com.baidu.tieba.d.c.a aVar = (com.baidu.tieba.d.c.a) tag;
                com.baidu.tieba.d.a.f abF = aVar.abF();
                int position = aVar.getPosition();
                i.l(view.getContext(), "pb_tb_btc");
                int abs = abF.abs();
                if (abs == 0) {
                    if (!j.fi() && (view.getContext() instanceof Activity)) {
                        com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a((Activity) view.getContext());
                        aVar2.aW(y.del_post_tip);
                        aVar2.aX(y.frs_network_tips);
                        aVar2.a(y.alert_yes_button, new e(this, view, abF, position, aVar));
                        aVar2.b(y.alert_no_button, new f(this));
                        aVar2.kT();
                        aVar2.kW();
                        return;
                    }
                    com.baidu.tbadk.distribute.a.ra().a(view.getContext(), abF.abw(), "btn_download", "pb", abF.bHq, abF.threadId);
                    com.baidu.tbadk.distribute.a.ra().a(abF.abw(), abF.bHq, abF.threadId, "PB", "download");
                    com.baidu.tieba.d.b.a(view.getContext(), abF, position);
                    aVar.refresh();
                } else if (abs == 2) {
                    com.baidu.tieba.d.b.a(view.getContext(), abF);
                    aVar.refresh();
                }
            }
        }
    }
}
