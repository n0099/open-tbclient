package com.baidu.tieba.d.b;

import android.view.View;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bf;
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    private static g bHx;

    public static final g abz() {
        if (bHx != null) {
            return bHx;
        }
        synchronized (g.class) {
            if (bHx == null) {
                bHx = new g();
            }
        }
        return bHx;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            Object tag = view.getTag();
            if (tag instanceof com.baidu.tieba.d.c.a) {
                com.baidu.tieba.d.a.f abF = ((com.baidu.tieba.d.c.a) tag).abF();
                if (!ay.aA(abF.abq().url)) {
                    com.baidu.tbadk.distribute.a.ra().a(view.getContext(), abF.abw(), "btn_click", "pb", abF.bHq, abF.threadId);
                    com.baidu.tbadk.distribute.a.ra().a(abF.abw(), abF.bHq, abF.threadId, "PB", "click");
                    bf.mR().b(view.getContext(), new String[]{abF.abq().url});
                }
            }
        }
    }
}
