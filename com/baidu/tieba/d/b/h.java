package com.baidu.tieba.d.b;

import android.view.View;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bg;
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    private static h a;

    public static final h a() {
        if (a != null) {
            return a;
        }
        synchronized (h.class) {
            if (a == null) {
                a = new h();
            }
        }
        return a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            Object tag = view.getTag();
            if (tag instanceof com.baidu.tieba.d.c.a) {
                com.baidu.tieba.d.a.f h = ((com.baidu.tieba.d.c.a) tag).h();
                if (!ba.c(h.p().d)) {
                    com.baidu.tbadk.distribute.a.a().a(view.getContext(), h.y(), "area_click", "pb", h.c, h.d);
                    com.baidu.tbadk.distribute.a.a().a(h.y(), h.c, h.d, "PB", "click");
                    bg.a().a(view.getContext(), new String[]{h.p().d});
                }
            }
        }
    }
}
