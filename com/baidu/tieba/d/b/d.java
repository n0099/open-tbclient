package com.baidu.tieba.d.b;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.j;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    private static d bHJ;

    public static final d abB() {
        if (bHJ != null) {
            return bHJ;
        }
        synchronized (d.class) {
            if (bHJ == null) {
                bHJ = new d();
            }
        }
        return bHJ;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            Object tag = view.getTag();
            if (tag instanceof com.baidu.tieba.d.c.a) {
                com.baidu.tieba.d.c.a aVar = (com.baidu.tieba.d.c.a) tag;
                com.baidu.tieba.d.a.f abI = aVar.abI();
                int position = aVar.getPosition();
                j.l(view.getContext(), "pb_tb_btc");
                int abv = abI.abv();
                if (abv == 0) {
                    if (!com.baidu.adp.lib.util.j.fi() && (view.getContext() instanceof Activity)) {
                        com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a((Activity) view.getContext());
                        aVar2.aW(y.del_post_tip);
                        aVar2.aX(y.frs_network_tips);
                        aVar2.a(y.alert_yes_button, new e(this, view, abI, position, aVar));
                        aVar2.b(y.alert_no_button, new f(this));
                        aVar2.kT();
                        aVar2.kW();
                        return;
                    }
                    com.baidu.tbadk.distribute.a.rc().a(view.getContext(), abI.abz(), "btn_download", "pb", abI.bHE, abI.threadId);
                    com.baidu.tbadk.distribute.a.rc().a(abI.abz(), abI.bHE, abI.threadId, "PB", "download");
                    com.baidu.tieba.d.b.a(view.getContext(), abI, position);
                    aVar.refresh();
                } else if (abv == 2) {
                    com.baidu.tieba.d.b.a(view.getContext(), abI);
                    aVar.refresh();
                }
            }
        }
    }
}
