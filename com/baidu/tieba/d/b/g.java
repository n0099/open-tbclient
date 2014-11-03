package com.baidu.tieba.d.b;

import android.view.View;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bg;
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    private static g bHL;

    public static final g abC() {
        if (bHL != null) {
            return bHL;
        }
        synchronized (g.class) {
            if (bHL == null) {
                bHL = new g();
            }
        }
        return bHL;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            Object tag = view.getTag();
            if (tag instanceof com.baidu.tieba.d.c.a) {
                com.baidu.tieba.d.a.f abI = ((com.baidu.tieba.d.c.a) tag).abI();
                if (!az.aA(abI.abt().url)) {
                    com.baidu.tbadk.distribute.a.rc().a(view.getContext(), abI.abz(), "btn_click", "pb", abI.bHE, abI.threadId);
                    com.baidu.tbadk.distribute.a.rc().a(abI.abz(), abI.bHE, abI.threadId, "PB", "click");
                    bg.mR().b(view.getContext(), new String[]{abI.abt().url});
                }
            }
        }
    }
}
