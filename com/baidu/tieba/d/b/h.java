package com.baidu.tieba.d.b;

import android.view.View;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bf;
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    private static h bHy;

    public static final h abA() {
        if (bHy != null) {
            return bHy;
        }
        synchronized (h.class) {
            if (bHy == null) {
                bHy = new h();
            }
        }
        return bHy;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            Object tag = view.getTag();
            if (tag instanceof com.baidu.tieba.d.c.a) {
                com.baidu.tieba.d.a.f abF = ((com.baidu.tieba.d.c.a) tag).abF();
                if (!ay.aA(abF.abq().url)) {
                    com.baidu.tbadk.distribute.a.ra().a(view.getContext(), abF.abw(), "area_click", "pb", abF.bHq, abF.threadId);
                    com.baidu.tbadk.distribute.a.ra().a(abF.abw(), abF.bHq, abF.threadId, "PB", "click");
                    bf.mR().b(view.getContext(), new String[]{abF.abq().url});
                }
            }
        }
    }
}
